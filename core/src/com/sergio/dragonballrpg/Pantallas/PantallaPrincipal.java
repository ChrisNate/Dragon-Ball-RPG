package com.sergio.dragonballrpg.Pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
import com.sergio.dragonballrpg.Managers.Sonido;
import com.sergio.dragonballrpg.Pantallas.Elementos.Fondo;

public class PantallaPrincipal extends DefaultScreen{

    public static int NUM_PANTALLA= Graficos.FONDO_INT_PANTALLA_PRINCIPAL;
    SpriteBatch batch;
    private Stage gameStage;
    Fondo fondo;
    Graficos graficos;

    public PantallaPrincipal(DragonBall juego, Graficos graficos) {
        super(juego);

        batch=new SpriteBatch();
        ExtendViewport viewport= new ExtendViewport(Config.ANCHO, Config.ALTO);
        gameStage=new Stage(viewport, batch);
        this.graficos=graficos;
        prepararMenu();
        fondo=new Fondo();

    }

    public void prepararMenu(){

        ImageButton modoArcade=new ImageButton(new TextureRegionDrawable(new TextureRegion(this.graficos.modoArcade)));
        modoArcade.setPosition(gameStage.getWidth()/12, gameStage.getHeight()*2/3);
        modoArcade.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                Sonido.playBotonClick();
                super.clicked(event, x, y);
            }
        });



        gameStage.addActor(modoArcade);

        Label.LabelStyle buttonStyle=new Label.LabelStyle();
        buttonStyle.font=graficos.gameFont;
        buttonStyle.fontColor= Color.YELLOW;

        Label lblModoArcade= new Label("MODO ARCADE", buttonStyle);
        lblModoArcade.setAlignment(Align.left);
        lblModoArcade.setPosition(gameStage.getWidth()/12 + modoArcade.getWidth()+10, modoArcade.getY() + (modoArcade.getHeight()-lblModoArcade.getHeight())/2 );
        gameStage.addActor(lblModoArcade);
    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(gameStage);
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

        super.dispose();
        batch.dispose();
        Gdx.input.setInputProcessor(null);
    }
}
