package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.MainMenu;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class BallController extends GameController {

    protected BallController(MainMenu model) {
        super(model);
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action, long frameCount) throws IOException, URISyntaxException, FontFormatException {}
}
