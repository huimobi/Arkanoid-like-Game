package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.Ball;
import project.com.Model.Level;
import project.com.Model.Position;
import project.com.gui.GUI;

import java.awt.*;

public class BallController extends Controller<Ball> {
    public BallController(Ball model) {
        super(model);
    }


    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action,long frameTime) {
        Level level=getModel().getLevel();
        Position defaultPosition=new Position(level.getPaddle().getPosition().getX() + 5*(level.getPaddle().getWidth()/8), level.getPaddle().getPosition().getY() - 5);
        Rectangle ballHitBox=getModel().getHitBox();
        Position velocity=getModel().getVelocity();
        Rectangle nextMove = new Rectangle(ballHitBox.x + velocity.getX(), ballHitBox.y + velocity.getY(), ballHitBox.width, ballHitBox.height);

        if (level.isInitialSleep()) {
            getModel().setPosition(defaultPosition);
            return;
        }

        switch (level.collides(nextMove)){
            case UP: case DOWN:
                getModel().reflectVertical();
                break;
            case LEFT: case RIGHT:
                getModel().reflectHorizontal();
                break;
            case TOPRIGHT:
                getModel().setAngle45();
                break;
            case TOPLEFT:
                getModel().setAngle135();
                break;
            case BOTTOMLEFT:
                getModel().setAngle225();
                break;
            case BOTTOMRIGHT:
                getModel().setAngle315();
                break;

            case PADDLELEFT:
                getModel().setAngleBigger135();
                break;
            case PADDLEMIDDLELEFT:
                getModel().setAngle135();
                break;
            case PADDLEMIDDLERIGHT:
                getModel().setAngle45();
                break;
            case PADDLERIGHT:
                getModel().setAngleLess45();
                break;
        }

        if(level.collisionDown(level.getGameArea(),nextMove)) {
            level.updateLives();
            return;
        }
        getModel().move();

    }
}
