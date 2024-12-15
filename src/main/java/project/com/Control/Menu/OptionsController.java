package project.com.Control.Menu;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.MainMenu;
import project.com.Model.*;
import project.com.Model.Menu;
import project.com.State.GameState;
import project.com.State.InfoMenuState;
import project.com.State.MainMenuState;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static project.com.Model.Option.Type.*;

public class OptionsController extends Controller<Menu> {
    public OptionsController(Menu Menu) {
        super(Menu);
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action, long frameCount) throws IOException, URISyntaxException, FontFormatException {
        switch (getModel().getCurrentOption().getType()){
           case START_GAME:
                if (action == GUI.ACTION.SELECT){
                    arkanoid.setState(new GameState(new LevelCreator(1).createLevel(new Paddle(new Position(60,130))), arkanoid.getImageLoader()));
                }
                break;
           case INFO:
                if(action == GUI.ACTION.SELECT){
                    arkanoid.setState(new InfoMenuState(new InfoMenu(), arkanoid.getImageLoader()));
                }
                break;
           case EXIT:
                if (action == GUI.ACTION.SELECT){
                    arkanoid.setState(null);
                }
                break;
            case TO_MAIN_MENU:
                if (action == GUI.ACTION.SELECT){
                    arkanoid.setState(new MainMenuState(new MainMenu(), arkanoid.getImageLoader()));
                }
        }
    }
}
