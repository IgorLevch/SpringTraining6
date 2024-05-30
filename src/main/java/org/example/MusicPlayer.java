package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

import static org.example.Genre.CLASSICAL;

@Component
public class MusicPlayer {

    Music music1;
    Music music2;
    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,@Qualifier("classicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }


    public void play(Genre genre){

        Random  random  = new Random();
        int r = random.nextInt(3);

        if (genre == CLASSICAL){
            System.out.println(music2.play().get(r));
        }  else {
            System.out.println(music1.play().get(r));
        }


    }


}
