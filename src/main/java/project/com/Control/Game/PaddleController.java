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
    private final int screenWidth;
    private Position position;
    private Paddle paddle;

    protected PaddleController(Paddle paddle, int screenWidth) {
        super(paddle);
        this.paddle=paddle;
        this.screenWidth = screenWidth;
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException {
        Paddle paddle=getModel();

        switch (action){
            case LEFT:
                paddle.moveLeft();
                break;
            case RIGHT:
                paddle.moveRight(lanternaGUI.getWidth());
                break;
            default:
                break;
        }
        Position velocity = new Position(1,2);
        paddle.setPosition(paddle.updatePosition(velocity));
        // collision logic
    }

    public Position getPosition() {
        return position;
    }

    public int getScreenWidth() {
        return screenWidth;
    }
}
