package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class ClassicalMusic implements Music {
    @PostConstruct  // это init метод
    public void doMyInit(){
        System.out.println("do my inititalization");

    }
    @PreDestroy  // это  destroy метод
    public void doMyDestroy(){
        System.out.println("doing my destruction");

    }

    private List<String> clM = new ArrayList<>();

    {
        clM.add("Betkhoven");
        clM.add("Chaikovsky");
        clM.add("Mousrgsky");
    }

    @Override
    public List<String> play() {
        return clM;
    }
}
