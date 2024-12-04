package project.com.gui;

import com.googlecode.lanterna.TextColor;

import java.io.IOException;

public interface GUI {
    enum ACTION { UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, JUMP, DASH }

    int getWidth();
    int getHeight();
    void drawPixel(double x, double y, TextColor color);
    void clear();
    ACTION getNextAction() throws IOException;
    void refresh() throws IOException;
    void close() throws IOException;
}
