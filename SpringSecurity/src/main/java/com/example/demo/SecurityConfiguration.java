package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("john")
                .password("test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("mary")
                .password("test123")
                .roles("MANAGER")
                .build();

        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("susan")
                .password("test123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}
