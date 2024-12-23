package project.com.Viewer.Text;

import com.googlecode.lanterna.TextColor;
import project.com.Model.Position;
import project.com.Viewer.Sprite.ImageReader;
import project.com.Viewer.Sprite.PNGReader;
import project.com.gui.GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class WriteChar {
    static int CHARWIDTH = 7;
    private final ImageReader image;
    private final TextColor foregroundColor;

    public WriteChar(char c1) throws IOException {
        char c = Character.toUpperCase(c1);
        this.image= new PNGReader("Characters/" + c +".png");
        this.foregroundColor=TextColor.ANSI.WHITE_BRIGHT;
    }

    public void setForeground(GUI gui,String foreground,Position position){
        ArrayList<Position> char_foreground=getForeground(position); //get foreground pixels
        image.changePixelColor(gui,position,char_foreground,foreground);
    }


    //set foreground white (REMOVE)
    public void setForegroundDefault(GUI gui,Position position){
        image.changePixelColor(gui,position,getForeground(position),foregroundColor);
    }

    //DONT REMOVE PEDRO
    public ArrayList<Position> getForeground(Position position) {
        ArrayList<Position> whitePixels= new ArrayList<>();

        BufferedImage character=image.getImage();

        for (int px = 0; px < character.getWidth(); px++) {
            for (int py = 0; py < character.getHeight(); py++) {
                int rgb=character.getRGB(px,py);
                if(new Color(rgb,true).getAlpha()==0) continue;
                if(Color.white.equals(new Color(rgb,true))){
                    whitePixels.add(new Position(px+position.getX(),py+position.getY()));
                }
            }
        }
        return whitePixels;
    }

}
