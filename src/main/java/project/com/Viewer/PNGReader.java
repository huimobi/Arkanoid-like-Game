package project.com.Viewer;

import com.googlecode.lanterna.TextColor;
import project.com.Model.Position;
import project.com.gui.GUI;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class PNGReader implements ImageReader {
    private final BufferedImage image;

    public PNGReader(String filepath) throws IOException {
        URL resource = getClass().getClassLoader().getResource(filepath + ".png");
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

    public BufferedImage getImage() {
        return image;
    }
}
