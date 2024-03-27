package com.mindhub.BankHub.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests( (ant) ->
                // permisos genericos
                ant.requestMatchers("/index.html", "/web/login.html", "/web/register.html").permitAll()
                        .requestMatchers("/resources/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/login", "/api/clients").permitAll()
                        // permisos de ADMIN
                        .requestMatchers("/rest/**", "/api/clients", "/web/admin/**").hasAuthority("ADMIN")
                        // permisos para el cliente
                        .requestMatchers(HttpMethod.GET, "/api/clients/currents", "/api/accounts/{id}",
                                "/api/transactions", "/api/loans").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/clients/currents/**", "/api/transactions",
                                "/api/loans", "/api/loans/pay").authenticated()
                        .requestMatchers("/web/accounts.html", "/web/account.html", "/web/cards.html",
                                "/web/create-card.html", "/web/transfers.html", "/web/loan-application.html",
                                "/web/loan-payment.html").authenticated()
                        .requestMatchers("/**").hasAuthority("ADMIN")
                        .anyRequest().denyAll())

                        .csrf(AbstractHttpConfigurer::disable)
                        .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                        .exceptionHandling(exc -> exc.authenticationEntryPoint(((request, response, authException) -> clearAuthenticationAttributes(request))));


        /*
        http.authorizeHttpRequests( (ant) ->
                        ant.requestMatchers("/**").permitAll())
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .exceptionHandling(exc -> exc.authenticationEntryPoint(((request, response, authException) -> clearAuthenticationAttributes(request))));


         */

        /*
        http.authorizeHttpRequests( ant ->
                        ant.requestMatchers("/index.html", "/web/login.html", "/web/register.html", "/resources/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/login", "/api/clients").permitAll()
                                .requestMatchers("/rest/**", "/api/clients", "/web/admin/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/clients/currents", "/api/accounts/{id}",
                                        "/api/transactions", "/api/loans").authenticated()
                                .requestMatchers(HttpMethod.POST, "/api/clients/current/**", "/api/loans/pay").authenticated()
                                .requestMatchers("/web/accounts.html", "/web/account.html", "/web/cards.html",
                                        "/web/create-card.html", "/web/transfers.html", "/web/loan-application.html",
                                        "/web/loan-payment.html").authenticated()
                                .requestMatchers("/**").hasAuthority("ADMIN")
                                .anyRequest().denyAll())
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .exceptionHandling(exc -> exc.authenticationEntryPoint(((request, response, authException) -> clearAuthenticationAttributes(request))));


         */


        http.formLogin( formLogin -> formLogin.loginPage("/Web/login.html")
                        .loginProcessingUrl("/api/login")
                        .usernameParameter("email")
                        .passwordParameter("pwd")
                        .successHandler((request, response, authentication) -> clearAuthenticationAttributes(request))
                        .failureHandler((request, response, exception) -> response.sendError(403)))
                .logout(logout -> logout.logoutUrl("/api/logout")
                        .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                        .deleteCookies("JSESSIONID"))
                .rememberMe(Customizer.withDefaults());

        return http.build();
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {
        // verifica que no haya una sesion activa
        HttpSession session = request.getSession(false);
        if (session != null) {
            // Si hay una sesión, esta línea elimina el atributo denominado
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
    }
}
