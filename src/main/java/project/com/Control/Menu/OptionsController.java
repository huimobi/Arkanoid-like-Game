package project.com.Control.Menu;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.Elements.Paddle;
import project.com.Model.Levels.LevelCreator;
import project.com.Model.Menus.InfoMenu;
import project.com.Model.Menus.MainMenu;
import project.com.Model.*;
import project.com.Model.Menus.Menu;
import project.com.State.GameState;
import project.com.State.InfoMenuState;
import project.com.State.MainMenuState;
import project.com.gui.GUI;

import java.io.IOException;

import static project.com.Model.Levels.HighScore.loadHighScore;

public class OptionsController extends Controller<Menu> {
    public OptionsController(Menu Menu) {
        super(Menu);
        if (Menu == null){
            throw new NullPointerException("Menu cannot be null");
        }
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action, long frameCount) throws IOException {
        switch (getModel().getCurrentOption().type()){
           case START_GAME:
                if (action == GUI.ACTION.SELECT){
                    int highestScore=loadHighScore();
                    arkanoid.setState(new GameState(new LevelCreator(1).createLevel(new Paddle(new Position(60,130)),0, highestScore),arkanoid.getImageLoader()));
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
