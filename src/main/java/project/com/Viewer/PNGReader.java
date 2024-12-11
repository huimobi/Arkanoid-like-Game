package project.com.Viewer;

import com.googlecode.lanterna.TextColor;
import project.com.Model.Position;
import project.com.gui.GUI;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class PNGReader implements ImageReader {
    private final BufferedImage image;

    public PNGReader(String filepath) throws IOException {
        URL resource = getClass().getClassLoader().getResource(filepath);
        this.image= ImageIO.read(Objects.requireNonNull(resource));
    }

    //draws png
    public void draw(GUI gui, Position position){
        gui.drawImage(image,position);
    }


    public void changePixelColor(GUI gui, ArrayList<Position> positions, TextColor color){
        for(Position p: positions){
            gui.drawPixel(p,color); //changes foreground color
        }
    }

    public void changePixelColor(GUI gui, ArrayList<Position> positions, String PixelColor){
        TextColor color=parseColor(PixelColor);
        for(Position p: positions){
            gui.drawPixel(p,color); //changes foreground color
        }
    }
    private TextColor parseColor(String color){
        return new TextColor.RGB(getRed(color),getGreen(color),getBlue(color));
    }

    private int getRed(String s){
        return Color.decode(s).getRed();
    }
    private int getGreen(String s){
        return Color.decode(s).getGreen();
    }
    private int getBlue(String s){
        return Color.decode(s).getBlue();
    }

    public BufferedImage getImage() {
        return image;
    }
}
