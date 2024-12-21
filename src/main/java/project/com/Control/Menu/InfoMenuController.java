package project.com.Control.Menu;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.Menus.InfoMenu;
import project.com.Model.Menus.MainMenu;
import project.com.Model.Menus.Option;
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
        Option currentInfo = getModel().getCurrentInfo();
        if (currentInfo == null || currentInfo.getType() == Option.Type.TO_MAIN_MENU) {

            if (currentInfo == null) {
                arkanoid.setState(new MainMenuState(new MainMenu(), arkanoid.getImageLoader()));
                return;
            }
            switch (getModel().getCurrentInfo().getType()) {
                case TO_MAIN_MENU:
                    if (action == GUI.ACTION.SELECT) {
                        arkanoid.setState(new MainMenuState(new MainMenu(), arkanoid.getImageLoader()));
                    }
                    break;
            }
            if (action == GUI.ACTION.QUIT) {
                arkanoid.setState(new MainMenuState(new MainMenu(), arkanoid.getImageLoader()));
                return;
            }
        if (Objects.requireNonNull(getModel().getCurrentInfo().type()) == Option.Type.TO_MAIN_MENU) {
            if (action == GUI.ACTION.SELECT) {
                arkanoid.setState(new MainMenuState(new MainMenu(), arkanoid.getImageLoader()));
            }
        }
        }

        optionsController.step(arkanoid, action, frameCount);
    }

}