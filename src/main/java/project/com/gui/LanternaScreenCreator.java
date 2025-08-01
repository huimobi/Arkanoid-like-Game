package project.com.gui;

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


public class LanternaScreenCreator implements ScreenCreator {
    private final DefaultTerminalFactory factory;
    private final TerminalSize terminalSize;
    private final int fontSize;



    public LanternaScreenCreator(DefaultTerminalFactory factory, TerminalSize terminalSize) {
        this.factory = factory;
        this.terminalSize = terminalSize;
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(terminalSize);
        this.fontSize= getFontSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds()); //takes as input the monitor size screen
    }

    //return the screen with all configs
    @Override
    public Screen createScreen() throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        factory.setTerminalEmulatorFontConfiguration(fontConfig);

        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(terminalSize);
        Terminal terminal = factory.createTerminal();

        ((AWTTerminalFrame) terminal).addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });

        return new TerminalScreen(terminal);
    }

    //loads font and put the font size to the terminal configuration
    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, IOException, FontFormatException{
        URL resource = getClass().getClassLoader().getResource("Fonts/square.ttf");
        assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, fontSize);

        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }


    @Override
    public int getHeight() {
        return terminalSize.getRows();
    }

    @Override
    public int getWidth() {
        return terminalSize.getColumns();
    }

    //gives the best fontSize for the terminal
   public int getFontSize(Rectangle terminalBounds) {
        double maxFontWidth = terminalBounds.getWidth() / terminalSize.getColumns(); //compare terminal width with nr of columns
        double maxFontHeight = terminalBounds.getHeight() / terminalSize.getRows();    //compare terminal height with nr of rows
        return (int) Math.min(maxFontWidth, maxFontHeight); //choose one font size that can show all game columns and rows
    }
}