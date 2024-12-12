package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.Ball;
import project.com.Model.Brick;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class BrickController extends Controller<List<Brick>> {
    protected BrickController(List<Brick> bricks) {
        super(bricks);
    }

    public boolean checkCollisions(Ball ball){
        boolean collisionDetected = false;
        for (Brick brick : getModel()){
            if (brick.getDurability() > 0 && brick.checkCollision(ball.getHitbox())){
                collisionDetected = true;
                ball.reflectVertical();
                break;
            }
        }
        return collisionDetected;
    }

    public boolean allBricksDestroyed() {
        for (Brick brick:getModel()){
            if (brick.getDurability() > 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException {

    }

    @Override
    public void step() throws IOException, URISyntaxException, FontFormatException {

    }
}
