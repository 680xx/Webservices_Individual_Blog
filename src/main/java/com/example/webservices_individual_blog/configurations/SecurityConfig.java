package com.example.webservices_individual_blog.configurations;

import com.example.webservices_individual_blog.JwtAuthConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    // Authentication, Authorization, users, roles, crypto
    // Authentication = Är du inloggad
    // Authorization = Vilken roll/behörighet har du, vad har du åtkomst till
    // Crypto = Kryptering av t.ex. lösenord

    // SecurityFilterChain (Böna) = Kedja av filter att ta sig igenom

    @Autowired
    private JwtAuthConverter jwtAuthConverter;

    @Bean
    protected SessionAuthenticationStrategy strategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // http.csrf((csrf)-> csrf.disable());          // Disables CSRF
        http.csrf((csrf) -> csrf.disable()).authorizeHttpRequests((auth) -> auth.requestMatchers("/api/***", "api/posts/***").permitAll().anyRequest().authenticated())

                .oauth2ResourceServer((oath2) -> oath2.jwt((jwt) -> jwt.jwtAuthenticationConverter(jwtAuthConverter)))

                .sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    }
}