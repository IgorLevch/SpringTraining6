package org.example;

import jdk.jfr.DataAmount;


public class ClassicalMusic implements Music {

    int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    private ClassicalMusic() {} // это мы ограничили создание объектов данного класса с пом-ю ключевого слова new;
    public static ClassicalMusic getClassicalMusic(){  // фабричный метод - должен быть статическим
        // и возвращать объект класса
        return new ClassicalMusic();
    }

    public void doMyInit(){

        System.out.println("Doing my initialization");

    }


    public void doMyDestroy(){

        System.out.println("Doing my destruction");
    }


    @Override
    public String play() {
       return "Bohemian Rapsody";
    }
}
