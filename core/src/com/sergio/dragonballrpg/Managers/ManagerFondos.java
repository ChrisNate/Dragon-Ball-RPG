package com.sergio.dragonballrpg.Managers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ManagerFondos{

    private static int TOTALFONDOS=2;

    public static Texture getFondo(int numFondo){

        if(numFondo>=TOTALFONDOS)return null;

        Texture texture;
        String nombre= Graficos.mapaFondosInt.get(numFondo);
        texture=Graficos.mapaFondosString.get(nombre);
        return texture;

    }
}
