package project.com.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import project.com.Model.Position;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static java.awt.event.KeyEvent.*;


public class LanternaGUI implements GUI {
    private final ScreenCreator screenCreator;
    private final Screen screen;
    private KeyStroke keyPressed;



    public LanternaGUI(ScreenCreator screenCreator) throws IOException, URISyntaxException, FontFormatException {
        this.screenCreator = screenCreator;
        this.screen= screenCreator.createScreen();
        createScreen();
        this.keyPressed = readInput();
    }

    private void createScreen() throws IOException, URISyntaxException, FontFormatException {
        screen.startScreen();
        screen.setCursorPosition(null);
        screen.doResizeIfNecessary();
    }



    @Override
    public KeyStroke readInput() throws IOException {
        return screen.pollInput();
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
    public void drawImage(BufferedImage image, Position TopLeftposition) {
        for(int px=0;px<image.getWidth();px++){
            for(int py=0;py<image.getHeight();py++){

                int rgb=image.getRGB(px,py); //get RGB color of the pixel

                if(new Color(rgb,true).getAlpha()==0) continue; //checks if it is a transparent pixel

                Position p=new Position(TopLeftposition.getX()+px, TopLeftposition.getY()+py);
                if(p.getX()< getWidth() && p.getY()< getHeight()){
                    Color color= new Color(rgb,true);
                    drawPixel(p,new TextColor.RGB(color.getRed(),color.getGreen(),color.getBlue()));
                }
            }
        }
    }

    @Override
    public void changedDrawImage(BufferedImage image, Position TopLeftposition, ArrayList<Position> positions, TextColor differentColor) {
        for(int px=0;px<image.getWidth();px++){
            for(int py=0;py<image.getHeight();py++){

                int rgb=image.getRGB(px,py); //get RGB color of the pixel

                if(new Color(rgb,true).getAlpha()==0) continue; //checks if it is a transparent pixel

                Position p=new Position(TopLeftposition.getX()+px, TopLeftposition.getY()+py);
                if(p.getX()< getWidth() && p.getY()< getHeight()){
                    if (positions.contains(p)) {
                        drawPixel(p,new TextColor.RGB(differentColor.getRed(),differentColor.getGreen(),differentColor.getBlue()));
                    }else{
                    Color color= new Color(rgb,true);
                    drawPixel(p,new TextColor.RGB(color.getRed(),color.getGreen(),color.getBlue()));}
                }
            }
        }
    }

    @Override

    public ACTION getNextAction() throws IOException {
        this.keyPressed=readInput();

        if (keyPressed == null)
            return ACTION.NONE;

        switch (keyPressed.getKeyType()){
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
            case Escape, EOF -> {
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

    /*public KeyAdapter getKeyAdapter() {
        return keyAdapter;
    }*/
}