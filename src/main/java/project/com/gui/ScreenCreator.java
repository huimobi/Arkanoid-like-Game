package project.com.gui;

import com.googlecode.lanterna.screen.Screen;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public interface ScreenCreator {
    Screen createScreen()
            throws IOException, URISyntaxException, FontFormatException;

    int getWidth();
    int getHeight();
}
