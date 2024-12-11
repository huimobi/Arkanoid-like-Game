package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.MainMenu;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class GameController<T extends MainMenu> extends Controller<T> {
    protected GameController(T model) {
        super(model);
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action, long frameCount) throws IOException, URISyntaxException, FontFormatException {}
}
