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
    private final Paddle paddle;
    private final int screenWidth;
    private final int screenHeight;

    protected BallController(Ball model, Paddle paddle, int screenWidth, int screenHeight) {
        super(model);
        this.paddle = paddle;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }


    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException {
        Ball ball=getModel();
        Position newposition=ball.updatePosition();
        if(newposition.getX()<=0 || newposition.getX()+ball.getLENGTH() >= screenWidth){
            ball.reflectHorizontal();
        }
        if (newposition.getY()<=0){
            ball.reflectVertical();
        }
        if (ball.getHitbox().intersects(paddle.getHitbox())){
            ball.reflectVertical();
            //spin effect
            int paddleCentre = paddle.getPosition().getX() + paddle.getWIDTH() / 2;
            int ballCentre = newposition.getX() + ball.getLENGTH() / 2;

            int spin = ballCentre - paddleCentre;
            ball.reflectHorizontal();
            ball.reflectVertical();
        }
        if (newposition.getY()>=screenHeight){
            //handle ball lost
            lostBall(arkanoid);
        }
        ball.setPosition(newposition);
    }

    private void lostBall(Arkanoid arkanoid){
        Ball ball = getModel();
        ball.setPosition(new Position(screenWidth / 2, screenHeight - 20));
        ball.reflectVertical();
        // should include the logic of another level
    }
}
