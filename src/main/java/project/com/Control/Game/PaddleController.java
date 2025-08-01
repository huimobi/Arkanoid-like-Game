package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.Levels.Level;
import project.com.Model.Elements.Paddle;
import project.com.Model.Position;
import project.com.gui.GUI;

import java.awt.*;

public class PaddleController extends Controller<Level> {
    private final Paddle paddle;

    public PaddleController(Level level) {
        super(level);
        this.paddle=level.getPaddle();
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action,long frameTime) {
        Level level=getModel();
        Rectangle nextMove = new Rectangle(paddle.getHitBox().x + paddle.getVelocity().getX(), paddle.getHitBox().y + paddle.getVelocity().getY(), paddle.getHitBox().width, paddle.getHitBox().height);

        switch (action){
            case LEFT:
                paddle.moveLeft();
                nextMove.setLocation(paddle.getHitBox().x + paddle.getVelocity().getX(), paddle.getHitBox().y + paddle.getVelocity().getY());
                if(level.checkOutsideLevel(nextMove)){
                    paddle.setPosition(new Position(level.getGameArea().x,paddle.getPosition().getY()));
                    break;
                }
                paddle.move();
                break;
            case RIGHT:
                paddle.moveRight();
                nextMove.setLocation(paddle.getHitBox().x + paddle.getVelocity().getX(), paddle.getHitBox().y + paddle.getVelocity().getY());
                if(level.checkOutsideLevel(nextMove)){
                    paddle.setPosition(new Position(level.getGameArea().x+level.getWidth()-paddle.getWidth()-1,paddle.getPosition().getY()));
                    break;
                }
                paddle.move();
                break;
            default:
                break;
        }


    }

}
