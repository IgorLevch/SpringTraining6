package org.example;

public class MusicPlayer {

    Music music;

    public MusicPlayer(Music music) {
        this.music = music;
    }
    public void playMusic(){
        System.out.println("Playing: " + music.play());
    }

   }
