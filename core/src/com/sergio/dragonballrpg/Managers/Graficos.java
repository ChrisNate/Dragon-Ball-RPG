package com.sergio.dragonballrpg.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class Graficos {

    public static String FONDO_STRING_PANTALLA_PRINCIPAL="fondoPantallaPrincipal";
    public static int FONDO_INT_PANTALLA_PRINCIPAL=0;

    public TextureAtlas gameSprites;

    public static HashMap<String, Texture> mapaFondosString;
    public static HashMap<Integer, String> mapaFondosInt;

    public Texture modoArcade;
    public BitmapFont gameFont;

    public void Load(){


        // Fuentes

        gameFont= new BitmapFont(Gdx.files.internal("Fuentes/Dragon Ball.fnt"), Gdx.files.internal("Fuentes/Dragon Ball.png"), false);

        gameSprites=new TextureAtlas(Gdx.files.internal("packed/game.atlas"));
        mapaFondosString=new HashMap<String, Texture>();
        mapaFondosInt=new HashMap<Integer, String>();
        Texture fondoPantallaPrincipal=new Texture(Gdx.files.internal("Fondos/fondoPantallaPrincipal.jpg"));
        mapaFondosString.put(FONDO_STRING_PANTALLA_PRINCIPAL, fondoPantallaPrincipal);
        mapaFondosInt.put(FONDO_INT_PANTALLA_PRINCIPAL, FONDO_STRING_PANTALLA_PRINCIPAL);

        // Elementos Menus

        modoArcade=new Texture(Gdx.files.internal("ElementosMenus/modoArcade.jpg"));

    }

    public void dispose(){
        gameSprites.dispose();
    }
}
