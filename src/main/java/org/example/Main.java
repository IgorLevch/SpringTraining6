package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    //создание инверсии управления не вручную (не через конструктор):
    // не с пом-ю Джава кода, а с пом-ю Спринг ФРеймворка
    //5 урок
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");

        //Music6 testBean = context.getBean("musicBean",Music6.class);
        //MusicPlayer6 musicPalyer = new MusicPlayer6(testBean);  это с прошлого урока - убираем

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);


        musicPlayer.playMusic();
        context.close();
    }
//
//  это и есть автоматическое (неручное) внедрение бина: мы 1 бин внедрили в конструктор другого:
//    <bean id ="musicBean"
//    class = "org.example.RockMusic66">
//
//    </bean>
//
//    <bean id = "musicPlayer"
//    class = "org.example.MusicPlayer6">
//        <constructor-arg ref = "musicBean"/>

}