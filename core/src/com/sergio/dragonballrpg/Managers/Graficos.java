package com.sergio.dragonballrpg.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class Graficos {

    public static String FONDO_STRING_PANTALLA_PRINCIPAL="fondoPantallaPrincipal";
    public static int FONDO_INT_PANTALLA_PRINCIPAL=0;
    public static String FONDO_STRING_MODO_ARCADE="fondoModoArcade";
    public static int FONDO_INT_MODO_ARCADE=1;

    public TextureAtlas gameSprites;

    public static HashMap<String, Texture> mapaFondosString;
    public static HashMap<Integer, String> mapaFondosInt;

    public Texture modoArcade;
    public BitmapFont gameFont;
    public Sprite gokumenu;
    public Sprite hiperCellmenu;
    public Sprite legendary;

    public void Load(){


        // Fuentes

        gameFont= new BitmapFont(Gdx.files.internal("Fuentes/Dragon Ball.fnt"), Gdx.files.internal("Fuentes/Dragon Ball.png"), false);

        gameSprites=new TextureAtlas(Gdx.files.internal("packed/game.atlas"));

        // Fondos


        mapaFondosString=new HashMap<String, Texture>();
        mapaFondosInt=new HashMap<Integer, String>();

        mapaFondosString.put(FONDO_STRING_PANTALLA_PRINCIPAL, new Texture(Gdx.files.internal("Fondos/fondoPantallaPrincipal.jpg")));
        mapaFondosInt.put(FONDO_INT_PANTALLA_PRINCIPAL, FONDO_STRING_PANTALLA_PRINCIPAL);

        mapaFondosString.put(FONDO_STRING_MODO_ARCADE, new Texture(Gdx.files.internal("Fondos/fondoModoArcade.jpg")));
        mapaFondosInt.put(FONDO_INT_MODO_ARCADE, FONDO_STRING_MODO_ARCADE);


        // Elementos Menus

        modoArcade=new Texture(Gdx.files.internal("ElementosMenus/modoArcade.jpg"));
        gokumenu=new Sprite(new Texture(Gdx.files.internal("ElementosMenus/goku.png")));
        hiperCellmenu=new Sprite(new Texture(Gdx.files.internal("ElementosMenus/HiperCell.png")));
        legendary=new Sprite(new Texture(Gdx.files.internal("ElementosMenus/legendary.png")));
    }

    public void dispose(){
        gameSprites.dispose();
    }
}
