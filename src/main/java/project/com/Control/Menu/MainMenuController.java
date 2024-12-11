package project.com.Control.Menu;

import project.com.Arkanoid;
import project.com.MainMenu;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainMenuController extends MenuController<MainMenu> {
    public MainMenuController(MainMenu mainMenu, OptionsController optionsController) {
        super(mainMenu, optionsController);
    }

    @Override
    protected void onQuit(Arkanoid arkanoid) {
        arkanoid.setState(null);
    }
}
