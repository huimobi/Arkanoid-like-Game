package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.Level;
import project.com.Model.LevelCreator;
import project.com.Model.MainMenu;
import project.com.State.GameState;
import project.com.State.MainMenuState;
import project.com.gui.GUI;

import java.io.IOException;


import static project.com.Model.HighScore.loadHighScore;
import static project.com.Model.HighScore.setHighScore;

public class GameController extends Controller<Level> {
    private final BallController ballController;
    private final PaddleController paddleController;
    private final PowerUpController powerUpController;

    public GameController(Level model, BallController ballController, PaddleController paddleController,PowerUpController powerUpController) {
        super(model);
        this.ballController=ballController;
        this.paddleController=paddleController;
        this.powerUpController=powerUpController;
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action,long frameTime) throws IOException {
        switch (action) {
            case RIGHT, LEFT:
                paddleController.step(arkanoid, action, frameTime);
                break;

            case QUIT:
                onQuit(arkanoid);
                break;

            default:
                break;
        }

        //when initial sleep, ball follows paddle
        ballController.step(arkanoid, action, frameTime);


        powerUpController.step(arkanoid,action,frameTime);


        //when level cleared gives next level or return mainMenu
        if (getModel().isLevelClear()) {
            if (getModel().getLevelNumber() < arkanoid.getLevels()) {
                LevelCreator levelCreator = new LevelCreator((getModel().getLevelNumber() + 1));
                Level newLevel = levelCreator.createLevel(getModel().getPaddle(), getModel().getScore(), getModel().getHighestScore());
                arkanoid.setState(new GameState(newLevel, arkanoid.getImageLoader()));
            } else {
                arkanoid.setState(new MainMenuState(new MainMenu(), arkanoid.getImageLoader()));
            }
        }

        //Game Over
        if (getModel().getPaddle().getLives() == 0) {
            if (getModel().getScore()>loadHighScore()) {
                setHighScore(getModel().getScore());
            }
            arkanoid.setState(new MainMenuState(new MainMenu(), arkanoid.getImageLoader()));
        }
    }
     private void onQuit(Arkanoid arkanoid){
        arkanoid.setState(null);
     }
}
