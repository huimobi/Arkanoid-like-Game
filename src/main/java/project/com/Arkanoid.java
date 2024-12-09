package project.com;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import project.com.State.MainMenuState;
import project.com.State.State;
import project.com.Viewer.ImageLoader;
import project.com.Viewer.PNGLoader;
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
    private final ImageLoader imageLoader;
    private State state;

    //creates the screen that will be used through the game
    public Arkanoid() throws IOException, URISyntaxException, FontFormatException, NullPointerException {

        ScreenCreator screenCreator = new LanternaScreenCreator(new DefaultTerminalFactory(),new TerminalSize(width,height));
        this.gui = new LanternaGUI(screenCreator);
        run();
        this.imageLoader = new PNGLoader();
        //this.state = new MainMenuState(new MainMenu(gui), imageLoader);
    }

    //starts the Main Menu
    public void run() throws IOException, FontFormatException {
        new MainMenu(gui);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }


    //starts the game
    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Arkanoid();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException, InterruptedException, URISyntaxException, FontFormatException {
        int FPS = 60;
        long frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) Thread.sleep(sleepTime);
        }

        gui.close();
    }
}
