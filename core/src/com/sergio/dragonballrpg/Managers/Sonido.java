package com.sergio.dragonballrpg.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;

public class Sonido {

    public static AssetManager assets=new AssetManager();

    public static void LoadSounds(){

        assets.load(Gdx.files.internal("Sonidos/ClickMenu.mp3").path(), Sound.class);
        assets.finishLoading();

    }

    public static void playBotonClick(){

        Sound s=assets.get("Sonidos/ClickMenu.mp3", Sound.class);
        s.play();
    }


}


