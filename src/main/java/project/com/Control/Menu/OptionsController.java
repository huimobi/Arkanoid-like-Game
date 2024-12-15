package project.com.Control.Menu;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.MainMenu;
import project.com.Model.Ball;
import project.com.Model.LevelCreator;
import project.com.Model.Paddle;
import project.com.Model.Position;
import project.com.State.GameState;
import project.com.State.MainMenuState;
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
                    arkanoid.setState(new GameState(new LevelCreator(1).createLevel(new Paddle(new Position(60,130),null),0),arkanoid.getImageLoader()));
                }
                break;
            /*case INFO:
                if(action == GUI.ACTION.SELECT){
                    arkanoid.setState(new InfoMenuState(new InfoMenu(), arkanoid.getImageLoader()));
                }
                break;*/

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
