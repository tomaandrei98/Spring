package org.example.annotation.inversioncontrolanddependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("thatSillyCoach")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("TennisCoach: inside TennisCoach() constructor");
    }

    //    @Autowired
//    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

//    @Autowired
//    public void regularMethod(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @PostConstruct
    public void doMyStartUpStuff() {
        System.out.println("TennisCoach: inside doMyStartUpStuff()");
    }

    @PreDestroy
    public void doMyCleanUpStuff() {
        System.out.println("TennisCoach: inside doMyCleanUpStuff()");
    }
}
