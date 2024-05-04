package org.example;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {

    // Music music;  для домашки убираем

    private List<Music>  musicList = new ArrayList<>(); // домашка





    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    private String name;
    private int volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
  //  для домашки убираем:
 /*   public MusicPlayer(Music music) {
        this.music = music;
    }
    // делаем сеттер:
    public void setMusic(Music music) {
        this.music = music;
    }*/

    // делаем констр-р без аргументов:
    public MusicPlayer() {
    }

   // public void playMusic(){     //  это без домашки:
//        System.out.println("Playing: " + music.play());
//    }


    public void playMusic(){
        for (Music music:musicList){
        System.out.println("Playing: " + music.play());
    }}


   }
