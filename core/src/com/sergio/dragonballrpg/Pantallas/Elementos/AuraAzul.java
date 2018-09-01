package com.sergio.dragonballrpg.Pantallas.Elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class AuraAzul {

    Animation animacion;
    public TextureRegion currentFrame;
    float tiempo;
    public Vector2 posicion;
    Color color;

    public AuraAzul(float x, float y, Color c){

        color=c;
        posicion=new Vector2(x,y);
        TextureRegion texturas[]=new TextureRegion[50];

        for(int i=0; i<50; i++){

            String ceros="000";
            if(i<10){
                ceros="0000";
            }else{
                ceros="000";
            }
            texturas[i]=new Sprite(new Texture(Gdx.files.internal("ElementosMenus/AuraAzul/aura"+ ceros + i+ ".png")));
        }

        animacion=new Animation(1/25f, texturas);
    }

    public void update(float delta){
        tiempo+=delta;
        currentFrame= (TextureRegion) animacion.getKeyFrame(tiempo, true);
    }

    public void draw(SpriteBatch batch){

        Color col=batch.getColor();
        if(color==Color.RED){

            batch.setColor(color.r, color.g, color.b, 0.75f);

        }else{
            batch.setColor(col.r, col.g, col.b, 0.75f);
        }

        batch.begin();
        batch.draw(currentFrame, posicion.x, posicion.y);
        batch.end();
        batch.setColor(col);
    }
}
