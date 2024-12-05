package project.com.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import project.com.Model.Position;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static java.awt.event.KeyEvent.*;


public class LanternaGUI implements GUI {
    private static final List<Integer> SPAM_KEYS = List.of(VK_LEFT, VK_RIGHT);

    private final ScreenCreator screenCreator;
    private final Screen screen;
    /*
    private boolean keySpam;
    private KeyEvent priorityKeyPressed;
    */


    public LanternaGUI(ScreenCreator screenCreator) throws IOException, URISyntaxException, FontFormatException {
        this.screenCreator = screenCreator;
        this.screen= screenCreator.createScreen();
        createScreen();

        //this.keySpam = false;
        //this.priorityKeyPressed = null;
        //this.keyAdapter = createKeyAdapter();
        //this.keyPressed = null;
    }

    private void createScreen() throws IOException, URISyntaxException, FontFormatException {
        screen.startScreen();
        screen.setCursorPosition(null);
        screen.doResizeIfNecessary();
    }

    //still need to understand this
    /*private KeyAdapter createKeyAdapter() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (keySpam && SPAM_KEYS.contains(e.getKeyCode()))
                    keyPressed = priorityKeyPressed = e;
                else
                    keyPressed = e;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (keySpam && SPAM_KEYS.contains(e.getKeyCode()))
                    keyPressed = priorityKeyPressed = null;
                else
                    keyPressed = priorityKeyPressed;
            }
        };
    }*/

    @Override
    public KeyStroke readInput() throws IOException {
        return screen.readInput();
    }

    @Override
    public int getWidth() {
        return screenCreator.getWidth();
    }

    @Override
    public int getHeight() {
        return screenCreator.getHeight();
    }


    @Override
    public void drawPixel(Position position, TextColor color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(color);
        tg.setCharacter(position.getX(), position.getY(), ' ');
    }


    @Override

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        switch (keyStroke.getKeyType()){
            case ArrowLeft -> {
                return ACTION.LEFT;
            }
            case ArrowRight -> {
                return ACTION.RIGHT;
            }
            case ArrowUp -> {
                return ACTION.UP;
            }
            case ArrowDown -> {
                return ACTION.DOWN;
            }
            case Escape -> {
                return ACTION.QUIT;
            }
            case Enter -> {
                return ACTION.SELECT;
            }
            default -> {
                return ACTION.NONE;
            }
        }
    }


    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    /* public KeyAdapter getKeyAdapter() {
        return keyAdapter;
    }*/
}