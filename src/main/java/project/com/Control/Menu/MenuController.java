package project.com.Control.Menu;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class MenuController<T extends Menu> extends Controller<T> {
    private final OptionsController optionsController;

    public MenuController(T menu, OptionsController optionsController) {
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


    protected abstract void onQuit (Arkanoid arkanoid) throws IOException;


}