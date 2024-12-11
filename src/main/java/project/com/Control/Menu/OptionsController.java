package project.com.Control.Menu;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.MainMenu;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class OptionsController extends Controller<MainMenu> {
    public OptionsController(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action, long frameCount) throws IOException, URISyntaxException, FontFormatException {
        switch (getModel().getCurrentOption().getType()){
            case START_GAME:
                if (action == GUI.ACTION.SELECT){
                    arkanoid.setState(new );
                }
        }
    }
}

