package org.example;

import jdk.jfr.DataAmount;
import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {

    @Override
    public String play() {
       return "Bohemian Rapsody";
    }
}
