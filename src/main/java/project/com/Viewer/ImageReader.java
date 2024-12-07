package project.com.Viewer;

import com.googlecode.lanterna.TextColor;
import project.com.Model.Position;
import project.com.gui.GUI;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface ImageReader {
    public void draw(GUI gui, Position position);
    public ArrayList<Position> getForeground();
    public void changePixelColor(GUI gui, ArrayList<Position> positions, TextColor color);
    public BufferedImage getImage();
}
