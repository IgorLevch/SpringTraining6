package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RockMusic implements Music {

/*    List<String> rM = new ArrayList<>();

    {
        rM.add("Tsoy");
        rM.add("Rock2");
        rM.add("Rock3");
    }*/


    @Override
    public String play() {
        return "Show must go on";
    }

 /*   Random random = new Random();
    int o = random.nextInt(3);
    public String play(){

        return rM.get(o);
    }*/
}



