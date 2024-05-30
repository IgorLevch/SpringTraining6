package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music {

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
