package project.com.Control.Menu;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.*;
import project.com.State.MainMenuState;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;


public class InfoMenuController extends Controller<InfoMenu> {
    private final OptionsController optionsController;

    public InfoMenuController(InfoMenu menu, OptionsController optionsController) {
        super(menu);
        this.optionsController = optionsController;
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action, long frameCount) throws IOException, URISyntaxException, FontFormatException {
        if (Objects.requireNonNull(getModel().getCurrentInfo().type()) == Option.Type.TO_MAIN_MENU) {
            if (action == GUI.ACTION.SELECT) {
                arkanoid.setState(new MainMenuState(new MainMenu(), arkanoid.getImageLoader()));
            }
        }
        if(action == GUI.ACTION.QUIT){
            arkanoid.setState(new MainMenuState(new MainMenu(), arkanoid.getImageLoader()));
            return;
        }

        optionsController.step(arkanoid, action, frameCount);
    }

}