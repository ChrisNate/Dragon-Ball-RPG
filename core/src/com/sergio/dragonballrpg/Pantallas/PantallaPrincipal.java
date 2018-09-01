package com.sergio.dragonballrpg.Pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.sergio.dragonballrpg.Configuracion.Config;
import com.sergio.dragonballrpg.DragonBall;
import com.sergio.dragonballrpg.Managers.Graficos;
import com.sergio.dragonballrpg.Managers.Musica;
import com.sergio.dragonballrpg.Managers.Sonido;
import com.sergio.dragonballrpg.Pantallas.Elementos.AuraAzul;
import com.sergio.dragonballrpg.Pantallas.Elementos.Fondo;

public class PantallaPrincipal extends DefaultScreen{

    public static int NUM_PANTALLA= Graficos.FONDO_INT_PANTALLA_PRINCIPAL;
    SpriteBatch batch;
    private Stage gameStage;
    Fondo fondo;
    Graficos graficos;
    AuraAzul aura;
    AuraAzul auraRoja;
    ImageButton modoArcade;

    public PantallaPrincipal(DragonBall juego, Graficos graficos) {
        super(juego);

        batch=new SpriteBatch();

        ExtendViewport viewport= new ExtendViewport(Config.ANCHO, Config.ALTO);
        gameStage=new Stage(viewport, batch);
        aura=new AuraAzul(gameStage.getWidth()- graficos.gokumenu.getWidth()*5.5f, 0 /*gameStage.getHeight()/6*/, Color.BLUE);
        auraRoja=new AuraAzul(-120,0, Color.RED );
        this.graficos=graficos;
        prepararMenu();
        fondo=new Fondo();
        Musica.play();


    }

    public void prepararMenu(){

        modoArcade=new ImageButton(new TextureRegionDrawable(new TextureRegion(this.graficos.modoArcade)));
        modoArcade.setPosition((gameStage.getWidth()-this.graficos.modoArcade.getWidth())/2, gameStage.getHeight()*2/3);
        modoArcade.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Sonido.playBotonClick();
                Musica.stop();
                dispose();
                juego.setScreen(new PantallaModoArcade(juego, graficos));


            }
        });



        gameStage.addActor(modoArcade);

    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(gameStage);
    }

    public void update(float delta){

        gameStage.act(delta);
        aura.update(delta);
        auraRoja.update(delta);
    }

    @Override
    public void render(float delta) {

        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        fondo.draw(gameStage, NUM_PANTALLA);
        gameStage.draw();
        graficos.gokumenu.setBounds(aura.posicion.x + aura.currentFrame.getRegionWidth()/2-graficos.gokumenu.getWidth()/2, aura.posicion.y + aura.currentFrame.getRegionHeight()/4, graficos.gokumenu.getWidth(), graficos.gokumenu.getHeight());
        graficos.hiperCellmenu.setBounds(auraRoja.posicion.x + auraRoja.currentFrame.getRegionWidth()/2-graficos.hiperCellmenu.getWidth()/2+10, aura.posicion.y + aura.currentFrame.getRegionHeight()/4, graficos.hiperCellmenu.getWidth(), graficos.hiperCellmenu.getHeight());
        graficos.legendary.setBounds(gameStage.getWidth()/2-graficos.legendary.getWidth()/2, gameStage.getHeight()/6, graficos.legendary.getWidth(), graficos.legendary.getHeight());


        aura.draw(batch);
        auraRoja.draw(batch);

        batch.begin();
        graficos.gokumenu.draw(batch, 0.75f);
        graficos.hiperCellmenu.draw(batch, 0.75f);
        graficos.legendary.draw(batch);
       // batch.draw(graficos.gokumenu, aura.posicion.x + aura.currentFrame.getRegionWidth()/2-graficos.gokumenu.getWidth()/2, aura.posicion.y + aura.currentFrame.getRegionHeight()/4);
       // batch.draw(graficos.hiperCellmenu,  auraRoja.currentFrame.getRegionWidth()/2-graficos.hiperCellmenu.getWidth()/2, aura.posicion.y + aura.currentFrame.getRegionHeight()/4);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        gameStage.getViewport().update(width, height, true);
        aura.posicion=new Vector2(gameStage.getWidth()- graficos.gokumenu.getWidth()*5.5f,0);
        modoArcade.setPosition((gameStage.getWidth()-this.graficos.modoArcade.getWidth())/2, gameStage.getHeight()*2/3);

    }

    @Override
    public void dispose(){

        batch.dispose();
        Gdx.input.setInputProcessor(null);
        Musica.dispose();
        super.dispose();
    }
}
