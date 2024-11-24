package project.com;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class PNG_draw {
    private final BufferedImage image;
    private Position position=new Position(0,0);

    public PNG_draw(String filepath) throws IOException {
        URL resource = getClass().getClassLoader().getResource(filepath);
        this.image= ImageIO.read(Objects.requireNonNull(resource));
    }

    public void drawPixel(Position pixel, TextColor color){
        TextGraphics textGraphics= Arkanoid.screen.newTextGraphics();
        textGraphics.setBackgroundColor(color);
        textGraphics.setCharacter(pixel.getX(),pixel.getY(),' '); //color the pixel
    }

    //draws png
    public void drawImage(Position position){
        this.position=position;
        for(int px=0;px<image.getWidth();px++){
            for(int py=0;py<image.getHeight();py++){

                int rgb=image.getRGB(px,py); //get RGB color of the pixel

                if(new Color(rgb,true).getAlpha()==0) continue; //checks if it is a transparent pixel

                Position p=new Position(position.getX()+px, position.getY()+py);
                if(p.getX()< Arkanoid.width && p.getY()<Arkanoid.height){
                    Color color= new Color(rgb,true);
                    drawPixel(p,new TextColor.RGB(color.getRed(),color.getGreen(),color.getBlue()));
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

    public void changePixelColor(ArrayList<Position> positions,TextColor color){
        for(Position p: positions){
            drawPixel(p,color); //changes foreground color
        }
    }
}
