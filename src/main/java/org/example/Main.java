package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    //создание инверсии управления через сеттер :
    // не с пом-ю Джава кода, а с пом-ю Спринг ФРеймворка
    //6 урок
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");



        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);


        musicPlayer.playMusic();
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());
        context.close();
    }


}