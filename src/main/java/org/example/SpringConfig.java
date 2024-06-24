package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
//@ComponentScan("org.example") -- это если не прописывать бины в конфиге
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public ClassicalMusic classicalMusic(){
        return  new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }

    @Bean
    public PopMusic popMusic() {return new PopMusic();}

    @Bean
    public List<Music> music(){
        return Arrays.asList(popMusic(), rockMusic(),classicalMusic());
    }

    @Bean
    public MusicPlayer musicPlayer(){
        return new MusicPlayer(music());
    }



}
