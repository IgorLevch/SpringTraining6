package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {

        // используем аннотацию @Autowired

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");


     /*   MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
        musicPlayer.playMusic();*/

        Computer comp = context.getBean("computer", Computer.class);
        System.out.println(comp);

        context.close();
    }


}