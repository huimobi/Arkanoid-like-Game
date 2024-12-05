package project.com;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import project.com.gui.LanternaGUI;
import project.com.gui.LanternaScreenCreator;
import project.com.gui.ScreenCreator;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class Arkanoid {
    final private int width = 264; //terminal width
    final private int height = 144;//terminal height
    private final LanternaGUI gui;
    //private State<T>state

    //creates the screen that will be used through the game
    public Arkanoid() throws IOException, URISyntaxException, FontFormatException, NullPointerException {

        ScreenCreator screenCreator = new LanternaScreenCreator(new DefaultTerminalFactory(),new TerminalSize(width,height));
        this.gui = new LanternaGUI(screenCreator);
        run();
        //        this.gui = new LanternaGUI(screenCreator, "Timeless Odyssey");
        //        this.spriteLoader = new GameSpriteLoader();
        //        this.state = new MainMenuState(new MainMenu(), spriteLoader);
    }

    //starts the Main Menu
    public void run() throws IOException, FontFormatException {
        new MainMenu(gui);
    }


    //starts the game
    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Arkanoid();
    }
}
