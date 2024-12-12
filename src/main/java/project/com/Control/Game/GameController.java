package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.MainMenu;
import project.com.Model.Brick;
import project.com.gui.GUI;

import java.awt.*;
import java.beans.beancontext.BeanContext;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class GameController<T extends MainMenu> extends Controller<T> {
    private final BallController ballController;
    private final BrickController brickController;

    public GameController(T model, BallController ballController, BrickController brickController) {
        super(model);
        this.ballController=ballController;
        this.brickController=brickController;
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException{

    };
}
