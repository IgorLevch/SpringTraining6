package org.example;

import org.springframework.stereotype.Component;

@Component
public class PopMusic implements Music {
    @Override
    public String play() {
        return "Philipp Kirkorov song";
    }
}
