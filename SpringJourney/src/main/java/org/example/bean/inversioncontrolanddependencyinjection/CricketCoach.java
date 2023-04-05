package org.example.bean.inversioncontrolanddependencyinjection;

public class CricketCoach implements Coach {
    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    public CricketCoach() {
        System.out.println("CricketCoach: inside no-args constructor");
    }

    public CricketCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
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
        System.out.println("CricketCoach: inside setter method - setFortuneService");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        System.out.println("CricketCoach: inside setter method - setEmailAddress");
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
        System.out.println("CricketCoach: inside setter method - setTeam");
    }
}
