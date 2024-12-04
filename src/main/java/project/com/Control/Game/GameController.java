package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.MainMenu;

public abstract class GameController<T extends MainMenu> extends Controller<T> {
    public abstract void step (Arkanoid arkanoid);
}
