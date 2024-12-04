package project.com;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import project.com.gui.LanternaGUI;
import project.com.gui.LanternaScreenCreator;
import project.com.gui.ScreenCreator;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


class Arkanoid {
    final static int width = 264; //terminal width
    final static int height = 144;//terminal height
    static Screen screen; //all classes will use same screen
    //private final LanternaGUI gui;

    //creates the screen that will be used through the game
    public Arkanoid() throws IOException, URISyntaxException, FontFormatException, NullPointerException {
        screen = new LanternaScreenCreator(new DefaultTerminalFactory(),new TerminalSize(width, height)).createScreen();
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();
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
