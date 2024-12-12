package project.com.Control.Menu;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.MainMenu;
import project.com.gui.GUI;

public abstract class MenuController extends Controller<MainMenu> {
    public MenuController() {
        super();
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action) {

    }
}
