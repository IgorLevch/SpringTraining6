package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PopMusic implements Music {


 /*   List<String> pM = new ArrayList<>();

    {
        pM.add("Kirkorov");
        pM.add("Alla B");
        pM.add("NaNa");

    }*/
    @Override
    public String play() {
        return "Philipp Kirkorov song";
    }
/*
    Random random = new Random();
    int o = random.nextInt(3);
    public String play(){

        return pM.get(o);
    }*/
}



