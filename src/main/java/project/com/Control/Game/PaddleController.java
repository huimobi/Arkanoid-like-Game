package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.Paddle;
import project.com.Model.Position;
import project.com.gui.GUI;
import project.com.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class PaddleController extends Controller<Paddle> {
    private GUI lanternaGUI;
    private Position position;
    private Paddle paddle;

    public PaddleController(Paddle paddle) {
        super(paddle);
        this.paddle=paddle;
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action,long frameTime) throws IOException, URISyntaxException, FontFormatException {
        Paddle paddle=getModel();

        switch (action){
            case LEFT:
                paddle.moveLeft();
                if(getModel().getLevel().checkOutsideLevel(getModel().getHitBox(),getModel().getVelocity())){
                    break;
                }
                getModel().move();
                break;
            case RIGHT:
                paddle.moveRight();
                if(getModel().getLevel().checkOutsideLevel(getModel().getHitBox(),getModel().getVelocity())){
                    break;
                }
                getModel().move();
                break;
            default:
                break;
        }
    }

    public Position getPosition() {
        return position;
    }

}
