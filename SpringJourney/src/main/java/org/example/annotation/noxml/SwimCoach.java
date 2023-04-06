package org.example.annotation.noxml;

import org.example.annotation.inversioncontrolanddependencyinjection.Coach;
import org.example.annotation.inversioncontrolanddependencyinjection.FortuneService;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
