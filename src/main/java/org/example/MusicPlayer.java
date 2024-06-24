package org.example;

import org.springframework.beans.factory.annotation.Value;

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

    ClassicalMusic classicalMusic;
    PopMusic popMusic;
    RockMusic rockMusic;

    /*public String playMusic(){
        return "Playing: " + classicalMusic.play();
        это было до ДЗ
    }*/

/*  private List<Music> music;

    public MusicPlayer(List<Music> music) {
        this.music = music;
    }*/

    public MusicPlayer(ClassicalMusic classicalMusic, PopMusic popMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.popMusic = popMusic;
        this.rockMusic = rockMusic;
    }


  /*  public String play(){

        return "Playing: " + music.get(r.nextInt(music.size())).play()+"\nvolume :"+this.volume;
    }*/

    public String play(Genre genre){

        if (genre == Genre.CLASSICAL_MUSIC){
            return classicalMusic.play();
        } else if (genre==Genre.ROCK_MUSIC) {
            return rockMusic.play();
        } else {
            return popMusic.play();
        }

    }

}







