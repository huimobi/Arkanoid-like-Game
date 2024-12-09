package project.com.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import project.com.Model.Position;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface GUI {
    KeyStroke readInput() throws IOException;

    enum ACTION { UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}

    int getWidth();
    int getHeight();
    void drawPixel(Position position, TextColor color);
    void drawImage(BufferedImage image, Position TopLeftposition);
    void clear();
    ACTION getNextAction() throws IOException;
    void refresh() throws IOException;
    void close() throws IOException;
}
