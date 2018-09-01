package com.sergio.dragonballrpg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sergio.dragonballrpg.Managers.Graficos;
import com.sergio.dragonballrpg.Managers.Musica;
import com.sergio.dragonballrpg.Managers.Sonido;
import com.sergio.dragonballrpg.Pantallas.PantallaPrincipal;

public class DragonBall extends Game {

	Graficos graficos;

	@Override
	public void create () {

		graficos=new Graficos();
		graficos.Load();
        Musica.load();
        Sonido.LoadSounds();
		setScreen(new PantallaPrincipal(this, graficos));


	}
	@Override
	public void dispose () {

		graficos.dispose();
		Musica.dispose();
	}
}
