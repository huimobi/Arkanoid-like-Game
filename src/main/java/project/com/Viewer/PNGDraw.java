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

public class PNGDraw {
    private final BufferedImage image;
    private Position position;

    public PNGDraw(String filepath) throws IOException {
        URL resource = getClass().getClassLoader().getResource(filepath);
        this.image= ImageIO.read(Objects.requireNonNull(resource));
    }

    public void drawPixel(GUI gui,Position pixel, TextColor color){
        gui.drawPixel(pixel,color); //color the pixel
    }

    //draws png
    public void drawImage(GUI gui, Position position){
        this.position=position;
        for(int px=0;px<image.getWidth();px++){
            for(int py=0;py<image.getHeight();py++){

                int rgb=image.getRGB(px,py); //get RGB color of the pixel

                if(new Color(rgb,true).getAlpha()==0) continue; //checks if it is a transparent pixel

                Position p=new Position(position.getX()+px, position.getY()+py);
                if(p.getX()< gui.getWidth() && p.getY()< gui.getHeight()){
                    Color color= new Color(rgb,true);
                    gui.drawPixel(p,new TextColor.RGB(color.getRed(),color.getGreen(),color.getBlue()));
                }
            }
        }
    }


    public ArrayList<Position> get_white_pixels() {
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

    public void changePixelColor(GUI gui,ArrayList<Position> positions,TextColor color){
        for(Position p: positions){
            drawPixel(gui,p,color); //changes foreground color
        }
    }

    public BufferedImage getImage() {
        return image;
    }

}
