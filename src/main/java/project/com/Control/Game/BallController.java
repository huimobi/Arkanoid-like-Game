package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.*;
import project.com.gui.GUI;

import java.awt.*;

import static project.com.Model.COLLISIONS.*;

public class BallController extends Controller<Level> {
    private Ball ball;
    public BallController(Level level) {
        super(level);
        this.ball=level.getBall();
    }


    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action,long frameTime) {
        Rectangle ballHitBox=ball.getHitBox();
        Position velocity=ball.getVelocity();

        Rectangle nextMove = new Rectangle(ballHitBox.x + velocity.getX(), ballHitBox.y + velocity.getY(), ballHitBox.width, ballHitBox.height);

        switch (getModel().collides(nextMove)){
            case UP:
                ball.reflectVertical();
                break;
            case LEFT: case RIGHT:
                 ball.reflectHorizontal();
                 break;
            case PADDLELEFT:
                 ball.setAngleBigger135();
                 break;
            case PADDLEMIDDLELEFT:
                ball.setAngle135();
                break;
            case PADDLEMIDDLERIGHT:
                ball.setAngle45();
                break;
            case PADDLERIGHT:
                ball.setAngleLess45();
                break;
            }


        //controll lives
        if(getModel().collisionDown(getModel().getGameArea(),getModel().getBall().getHitBox())) {
            getModel().updateLives();
        }

        //intial time sleep
        if (getModel().isInitialSleep()) {
            ball.setPosition(new Position(getModel().getPaddle().getPosition().getX() + 5*(getModel().getPaddle().getWidth()/8), getModel().getPaddle().getPosition().getY() - 5));
        }else{
            ball.move();}


        COLLISIONS collision=getModel().brickCollision(nextMove);

        //ball destroys all blocks
        if(getModel().getCurPowerUp().equals(PowerUp.Bonus.breakAll)) return;

        switch (collision){
            case UP: case DOWN:
                ball.reflectVertical();
                break;
            case LEFT: case RIGHT:
                ball.reflectHorizontal();
                break;
            case TOPRIGHT:
                ball.setAngle45();
                break;
            case TOPLEFT:
                ball.setAngle135();
                break;
            case BOTTOMLEFT:
                ball.setAngle225();
                break;
            case BOTTOMRIGHT:
                ball.setAngle315();
                break;

        }


    }
}
