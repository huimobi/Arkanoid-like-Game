package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.Ball;
import project.com.Model.Paddle;
import project.com.Model.Position;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class BallController extends Controller<Ball> {
    public BallController(Ball model) {
        super(model);
    }


    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action,long frameTime) {
        if(getModel().getLevel().isInitialSleep()) {
            getModel().setPosition(new Position(getModel().getLevel().getPaddle().getPosition().getX()+15,getModel().getLevel().getPaddle().getPosition().getY()-5));
            return;
        }
        getModel().move();
    }
}
