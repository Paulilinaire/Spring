package com.example.spring_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // à ne pas oublier sur method POST car enlève une sécurité qu'il y a sur la méthode (attention faille csrf)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("api/v1/products").permitAll()
                )
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/v1/products/post").authenticated()
                )
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/v1/products/get/{id}").authenticated()
                )

                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }


    // Ajouter user et password depuis bdd
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

//    Ajouter user et password en mémoire, en dur
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.builder()
//                .username("user")
//                .password("{noop}password") // noop : précise que le mdp ne doit pas être encodé (no PasswordEncoder), sans ça erreur 401
//                .roles("USER")
//                .build();
//
//        UserDetails userDetails1 = User.builder()
//                .username("user1")
//                .password("{noop}password1")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails, userDetails1);


    }

