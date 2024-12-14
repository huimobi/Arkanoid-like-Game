package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.Ball;
import project.com.Model.Level;
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
        Level level=getModel().getLevel();
        Position defaultPosition=new Position(level.getPaddle().getPosition().getX() + 15, level.getPaddle().getPosition().getY() - 5);
        Rectangle ballHitbox=getModel().getHitBox();
        Position velocity=getModel().getVelocity();

        if (level.isInitialSleep()) {
            getModel().setPosition(defaultPosition);
            return;
        }

        if(level.collides(ballHitbox,velocity)){
            getModel().reflectVertical();
        }

        if (level.colisionLeft(level.getGameArea(),ballHitbox, velocity) || level.colisionRight(level.getGameArea(),ballHitbox,velocity)) {
            getModel().reflectHorizontal();
        }

        if(level.colisionUP(level.getGameArea(),ballHitbox,velocity)){
            getModel().reflectVertical();
        }

        if(level.colisionDown(level.getGameArea(),ballHitbox,velocity)) {
            level.updateLives();
        }
        getModel().move();

    }
}
