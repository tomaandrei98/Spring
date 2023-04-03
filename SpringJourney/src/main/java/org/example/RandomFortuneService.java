package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomFortuneService implements FortuneService {
    private List<String> fortunes;

    public RandomFortuneService() {
        fortunes = Arrays.asList("You miss 100% of the shots you don't take.",
                "We don't want to tell our dreams, we want to show them.",
                "Nothing can stop you and nothing can define you.");
    }

    @Override
    public String getFortune() {
        return fortunes.get(new Random().nextInt(3));
    }
}
