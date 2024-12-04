package project.com.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;



import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class LanternaScreenCreator implements ScreenCreator {
    private final DefaultTerminalFactory factory;
    private final TerminalSize terminalSize;
    private final int fontSize=5; //ver função que escolhe a font size no timeless



    public LanternaScreenCreator(DefaultTerminalFactory factory, TerminalSize terminalSize) {
        this.factory = factory;
        this.terminalSize = terminalSize;
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(terminalSize);
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
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, fontSize);

        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }


    @Override
    public int getWidth() {
        return terminalSize.getRows();
    }

    @Override
    public int getHeight() {
        return terminalSize.getColumns();
    }
}