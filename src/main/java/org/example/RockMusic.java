package org.example;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {
    @Override
    public String play() {
        return "Show must go on";
    }
}
