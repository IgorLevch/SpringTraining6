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



    /*public String playMusic(){
        return "Playing: " + classicalMusic.play();
        это было до ДЗ
    }*/

  private List<Music> music;

    public MusicPlayer(List<Music> music) {
        this.music = music;
    }

    Random r = new Random();

    public String play(){

        return "Playing: " + music.get(r.nextInt(music.size())).play()+"\nvolume :"+this.volume;
    }
}







