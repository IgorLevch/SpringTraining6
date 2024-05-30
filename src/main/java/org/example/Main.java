package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class Main {


    public static void main(String[] args) {

        // используем аннотацию @Qualifier

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.play(Genre.CLASSICAL);
        musicPlayer.play(Genre.ROCK);


        context.close();
    }


}