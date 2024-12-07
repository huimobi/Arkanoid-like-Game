package project.com.Viewer;

import com.googlecode.lanterna.TextColor;
import project.com.Model.Position;
import project.com.Viewer.ImageReader;
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
    private Position position;

    public PNGReader(String filepath) throws IOException {
        URL resource = getClass().getClassLoader().getResource(filepath);
        this.image= ImageIO.read(Objects.requireNonNull(resource));
    }

    //draws png
    public void draw(GUI gui, Position position){
        this.position=position;
        gui.drawImage(image,position);
    }


    public ArrayList<Position> getForeground() {
        ArrayList<Position> white_pixels= new ArrayList<>();

        for (int px = 0; px < image.getWidth(); px++) {
            for (int py = 0; py < image.getHeight(); py++) {
                int rgb=image.getRGB(px,py);
                if(new Color(rgb,true).getAlpha()==0) continue;
                if(Color.white.equals(new Color(rgb,true))){
                    white_pixels.add(new Position(px+position.getX(),py+position.getY()));
                }
            }
        }
        return white_pixels;
    }

    public void changePixelColor(GUI gui, ArrayList<Position> positions, TextColor color){
        for(Position p: positions){
            gui.drawPixel(p,color); //changes foreground color
        }
    }

    public BufferedImage getImage() {
        return image;
    }

}
