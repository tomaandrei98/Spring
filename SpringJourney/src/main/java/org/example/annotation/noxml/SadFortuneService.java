package org.example.annotation.noxml;

import org.example.annotation.inversioncontrolanddependencyinjection.FortuneService;

public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is a sad day..";
    }
}
