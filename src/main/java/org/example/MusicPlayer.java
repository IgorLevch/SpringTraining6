package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    private PopMusic popMusic;



    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic, PopMusic popMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.popMusic = popMusic;

    }


    /*public String playMusic(){
        return "Playing: " + classicalMusic.play();
        это было до ДЗ
    }*/

    Random random = new Random();
    int o = random.nextInt(3);

    public String play(Genre genre) {
        if (genre == Genre.CLASSICAL_MUSIC) {
           return classicalMusic.play();
        } else if (genre == Genre.POP_MUSIC) {
            return popMusic.play();
        } else {
          return  rockMusic.play();
        }

    }}







