package org.example;

import jdk.jfr.DataAmount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ClassicalMusic implements Music {

 /*   List<String> clM = new ArrayList<>();
    {
        clM.add("Bohemian");
        clM.add("Chaykovsky");
        clM.add("Mousorgsky");

    }*/

    @Override
    public String play() {

        return "Bohemian Rapsody";
    }

   /* Random random = new Random();
    int o = random.nextInt(3);
    public String play(){

        return clM.get(o);
    }*/
}
