package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    //создание инверсии управления через сеттер :
    // не с пом-ю Джава кода, а с пом-ю Спринг ФРеймворка
    //6 урок
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");

       ClassicalMusic music = context.getBean("musicBean", ClassicalMusic.class);
        System.out.println(music.play());

          // далее ДЗ
        music.setVolume(150);
        ClassicalMusic music1 = context.getBean("musicBean",ClassicalMusic.class);
        ClassicalMusic music2 =context.getBean("musicBean",ClassicalMusic.class);
        System.out.println(music.getVolume());

        System.out.println(music1.play());
        System.out.println(music2.play());

        System.out.println(music1.getVolume());
        System.out.println(music2.getVolume());





      /*  MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        boolean comparison = firstMusicPlayer == secondMusicPlayer;
        System.out.println(comparison);
        System.out.println(firstMusicPlayer);
        System.out.println(secondMusicPlayer);


        firstMusicPlayer.setVolume(10);

        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());*/

   /*     musicPlayer.playMusic();
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());*/
        context.close();
    }


}