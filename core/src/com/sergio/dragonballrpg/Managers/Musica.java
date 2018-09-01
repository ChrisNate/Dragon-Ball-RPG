package com.sergio.dragonballrpg.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Musica {

    public static Music musica;

    public static void load(){

        musica= Gdx.audio.newMusic(Gdx.files.internal("Musica/musica.mp3"));
    }

    public static void play(){

        musica.setLooping(true);
        musica.play();
    }

    public static void stop(){

        musica.stop();
    }

    public static void dispose(){

        if(musica!=null)musica.dispose();
    }
}
