package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class Main {
    // аннотации:  @Value, @Scope,  @PostConstruct,   @PreDestroy

    public static void main(String[] args) {

       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

       /* musicPlayer.play(Genre.CLASSICAL);  это с прошлого урока
        musicPlayer.play(Genre.ROCK);
*/

        ClassicalMusic clM = context.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic clM1 = context.getBean("classicalMusic", ClassicalMusic.class);
        RockMusic rM = context.getBean("rockMusic",RockMusic.class);
       RockMusic rM1 = context.getBean("rockMusic",RockMusic.class);

        System.out.println(clM==clM1);//этот @Scope с singleton
        System.out.println(rM==rM1); // этот @Scope с prototype

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());


        context.close();
    }


}