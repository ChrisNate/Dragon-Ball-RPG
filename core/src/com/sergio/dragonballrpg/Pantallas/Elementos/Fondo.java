package com.sergio.dragonballrpg.Pantallas.Elementos;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sergio.dragonballrpg.Configuracion.Config;
import com.sergio.dragonballrpg.Managers.ManagerFondos;

public class Fondo {


    public Fondo(){

    }

    public void draw(Stage stage, int numFondo){

        stage.getBatch().begin();
        stage.getBatch().draw(ManagerFondos.getFondo(numFondo), 0,0, stage.getWidth(), stage.getHeight());
        stage.getBatch().end();

    }

    public void resize(){


    }

}
