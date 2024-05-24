package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MusicPlayer {
   /* @Autowired
    @Qualifier("rockMusic")*/
    private Music music1;
  /*  @Autowired
    @Qualifier("popMusic")*/
    private Music music2;

    @Autowired
    public MusicPlayer( @Qualifier("popMusic") Music music1,  @Qualifier("rockMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String playMusic(){
        return "Playing: " + music1.play()+", "+music2.play();

    }}



