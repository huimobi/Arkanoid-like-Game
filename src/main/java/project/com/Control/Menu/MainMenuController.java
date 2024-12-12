package project.com.Control.Menu;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.MainMenu;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainMenuController extends Controller<MainMenu> {
    private final OptionsController optionsController;

    public MainMenuController(MainMenu menu, OptionsController optionsController) {
        super(menu);
        this.optionsController = optionsController;
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action, long frameCount) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case UP:
                this.getModel().moveUp();
                break;

            case DOWN:
                this.getModel().moveDown();
                break;

            case QUIT:
                onQuit(arkanoid);
                break;

            default:
                optionsController.step(arkanoid, action, frameCount);
        }
    }


    protected void onQuit (Arkanoid arkanoid) throws IOException {
        arkanoid.setState(null);
    }

}
