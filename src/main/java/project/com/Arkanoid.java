package project.com;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import project.com.Model.Menus.MainMenu;
import project.com.Sound.SoundLoader;
import project.com.Sound.SoundTrack;
import project.com.State.MainMenuState;
import project.com.State.State;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.PNGLoader;
import project.com.gui.LanternaGUI;
import project.com.gui.LanternaScreenCreator;
import project.com.gui.ScreenCreator;

import javax.sound.sampled.AudioSystem;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;


public class Arkanoid {
    public static int WIDTH = 264;
    public static int HEIGHT = 144;
    private final LanternaGUI gui;
    private final ImageLoader imageLoader;
    private State state;
    private SoundTrack sound;

    //creates the screen that will be used through the game
    public Arkanoid() throws Exception {

        ScreenCreator screenCreator = new LanternaScreenCreator(new DefaultTerminalFactory(),new TerminalSize(WIDTH,HEIGHT));
        this.gui = new LanternaGUI(screenCreator);
        this.imageLoader = new PNGLoader();
        this.state = new MainMenuState(new MainMenu(), imageLoader);
        this.sound = new SoundTrack(new SoundLoader().loadSound(AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("Sound/Soundtrack.wav"))), AudioSystem.getClip()));
    }


    public ImageLoader getImageLoader() {
        return imageLoader;
    }


    //starts the game
    public static void main(String[] args) throws Exception {
        new Arkanoid().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException, InterruptedException, URISyntaxException, FontFormatException {
        int FPS = 60;
        long frameTime = 1000 /FPS;

        sound.start();
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
