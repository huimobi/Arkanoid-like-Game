package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.MainMenu;
import project.com.Model.Brick;
import project.com.Model.Level;
import project.com.Model.Position;
import project.com.gui.GUI;

import java.awt.*;
import java.beans.beancontext.BeanContext;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameController extends Controller<Level> {
    private final BallController ballController;
    private final PaddleController paddleController;


    public GameController(Level model, BallController ballController, PaddleController paddleController) {
        super(model);
        this.ballController=ballController;
        this.paddleController=paddleController;
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action,long frameTime) throws IOException, URISyntaxException, FontFormatException{

        switch (action) {
            case RIGHT, LEFT:
                paddleController.step(arkanoid,action,frameTime);
                break;
            case QUIT:
                onQuit(arkanoid);
                break;

            default:
                break;
        }
        ballController.step(arkanoid,action,frameTime);

    }
    protected void onQuit (Arkanoid arkanoid) throws IOException {
        arkanoid.setState(null);
    }
}
