package org.example.annotation.inversioncontrolanddependencyinjection;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    private List<String> fortunes = Arrays.asList(
            "Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    );
    Random random = new Random();

    @Override
    public String getFortune() {
        return fortunes.get(random.nextInt(fortunes.size()));
    }
}
