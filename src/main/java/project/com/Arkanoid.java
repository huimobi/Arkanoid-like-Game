package project.com;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import project.com.Model.*;
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
    public final static int WIDTH = 264;
    public final static int HEIGHT = 144;
    private final LanternaGUI gui;
    private final ImageLoader imageLoader;
    private State state;

    //creates the screen that will be used through the game
    public Arkanoid() throws IOException, URISyntaxException, FontFormatException, NullPointerException {

        ScreenCreator screenCreator = new LanternaScreenCreator(new DefaultTerminalFactory(),new TerminalSize(WIDTH,HEIGHT));
        this.gui = new LanternaGUI(screenCreator);
        this.imageLoader = new PNGLoader();
        this.state = new MainMenuState(new MainMenu(), imageLoader);
        //this.state=new GameState(new LevelCreator(1).createLevel(new Paddle(new Position(60,130))),imageLoader);
    }


    public ImageLoader getImageLoader() {
        return imageLoader;
    }


    //starts the game
    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException, InterruptedException {
        new Arkanoid().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException, InterruptedException, URISyntaxException, FontFormatException {
        int FPS = 60;
        long frameTime = 1000 /FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();
            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) Thread.sleep(sleepTime);
        }

        gui.close();
    }

    public int getLevels(){
        return 10;
    }
}
