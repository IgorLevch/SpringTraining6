package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class RockMusic implements Music {

   private List<String> rM = new ArrayList<>();

    {
        rM.add("Tsoy");
        rM.add("CorroziyaMetalla");
        rM.add("Metallica");
    }

    @Override
    public List<String> play() {
        return rM;
    }
}
