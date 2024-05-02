package com.example.springsecurity.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("Jaikanth")
                .password("passsj")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/api/books/**").authenticated() // Require authentication for all paths under /api/books
                        .anyRequest().permitAll()
                )
                .httpBasic()
                .and()
                .csrf().disable() // Disable CSRF protection for simplicity
                .cors().disable() // Disable CORS for simplicity
                .headers().frameOptions().disable() // Disable X-Frame-Options for H2 Console if present
                .and()
                .formLogin().disable() // Disable form-based login
                .logout().disable() // Disable logout
                .build();
    }
}
