//package com.project.Security;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//
//                .authorizeHttpRequests(auth -> auth
//
//                        .requestMatchers("/login","/loginAgain").permitAll()
//                        .requestMatchers("/home", "/chat").authenticated()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(login -> login
//                        .loginPage("/loginAgain")// Our LoGin PaGe
//                        .defaultSuccessUrl("/home")
//                        .permitAll())
//                .logout(logout -> {
//                    logout
//                            .permitAll();
//                })
//                .build();
//    }
//
//}
//
