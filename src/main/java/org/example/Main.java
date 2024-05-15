package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {

        // используем аннотацию @Component

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");

        Music music = context.getBean("rockMusic", Music.class);
        Music music1 = context.getBean("classicalMusic", Music.class);


        MusicPlayer musicPlayer = new MusicPlayer(music);
        MusicPlayer musicPlayer1 = new MusicPlayer(music1);


       musicPlayer.playMusic();
       musicPlayer1.playMusic();

        context.close();
    }


}