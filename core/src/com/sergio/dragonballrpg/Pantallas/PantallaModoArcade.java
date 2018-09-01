package com.sergio.dragonballrpg.Pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.sergio.dragonballrpg.Configuracion.Config;
import com.sergio.dragonballrpg.DragonBall;
import com.sergio.dragonballrpg.Managers.Graficos;
import com.sergio.dragonballrpg.Pantallas.Elementos.Fondo;

public class PantallaModoArcade extends DefaultScreen {

    public static int NUM_PANTALLA= Graficos.FONDO_INT_MODO_ARCADE;
    SpriteBatch batch;
    private Stage gameStage;
    Fondo fondo;
    Graficos graficos;

    public PantallaModoArcade(DragonBall juego, Graficos graficos) {
        super(juego);

        batch = new SpriteBatch();
        ExtendViewport viewport = new ExtendViewport(Config.ANCHO, Config.ALTO);
        gameStage = new Stage(viewport, batch);
        this.graficos = graficos;
   //     prepararMenu();
        fondo = new Fondo();
    }

    public void update(float delta){

        gameStage.act(delta);
    }

    @Override
    public void render(float delta) {

        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        fondo.draw(gameStage, NUM_PANTALLA);
        gameStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        gameStage.getViewport().update(width, height, true);

    }

    @Override
    public void dispose(){

        batch.dispose();
        Gdx.input.setInputProcessor(null);
        super.dispose();
    }


}
