package project.com.Viewer;

import com.googlecode.lanterna.TextColor;
import project.com.Model.Position;
import project.com.gui.GUI;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface ImageReader {
    void draw(GUI gui, Position position);
    void changePixelColor(GUI gui, Position topLeftPosition,ArrayList<Position> positions, TextColor PixelColor);
    void changePixelColor(GUI gui, Position topLeftPosition,ArrayList<Position> positions, String PixelColor);
    BufferedImage getImage();

}
