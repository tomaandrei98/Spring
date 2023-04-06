package org.example.annotation.noxml;

import org.example.annotation.inversioncontrolanddependencyinjection.Coach;
import org.example.annotation.inversioncontrolanddependencyinjection.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.example.annotation.noxml")
@PropertySource("classpath:annotation/sport.properties")
public class SportConfig {

    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
