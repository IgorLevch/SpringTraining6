package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
@Component
@Scope("prototype")
public class RockMusic implements Music {

    @PostConstruct  // это init метод
    public void doMyInit(){
        System.out.println("do my inititalization RockMusic");

    }


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
