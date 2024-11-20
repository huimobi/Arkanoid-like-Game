package project.com;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


class Arkanoid {
    final static int width = 264; //terminal width
    final static int height = 144   ;//terminal height
    static Screen screen; //all classes will use same screen


    //creates the screen that will be used through the game
    public Arkanoid() throws IOException, URISyntaxException, FontFormatException, NullPointerException {

        URL resource = getClass().getClassLoader().getResource("Fonts/square.ttf");

        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        DefaultTerminalFactory factory = new DefaultTerminalFactory();

        Font loadedFont = font.deriveFont(Font.PLAIN, 7);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        factory.setTerminalEmulatorFontConfiguration(fontConfig);
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(new TerminalSize(Arkanoid.width, Arkanoid.height));

        Terminal terminal = factory.createTerminal();
        ((AWTTerminalFrame) terminal).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        //screen.doResizeIfNecessary();
    }

    //starts the Main Menu
    public void run() throws IOException, InterruptedException, URISyntaxException, FontFormatException {
        MainMenu mainMenu=new MainMenu();
    }

    //starts the game
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, FontFormatException {
        Arkanoid arkanoid = new Arkanoid();
        arkanoid.run();
    }
}
