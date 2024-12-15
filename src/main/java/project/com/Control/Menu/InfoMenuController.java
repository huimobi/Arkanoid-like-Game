package project.com.Control.Menu;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.InfoMenu;
import project.com.Model.MainMenu;
import project.com.State.InfoMenuState;
import project.com.State.MainMenuState;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;



public class InfoMenuController extends Controller<InfoMenu> {
    private OptionsController optionsController;

    public InfoMenuController(InfoMenu menu, OptionsController optionsController) {
        super(menu);
        this.optionsController = optionsController;
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action, long frameCount) throws IOException, URISyntaxException, FontFormatException {
        if(action == GUI.ACTION.QUIT){
            arkanoid.setState(new MainMenuState(new MainMenu(), arkanoid.getImageLoader()));
            return;
        }
        optionsController.step(arkanoid, action, frameCount);
    }

}