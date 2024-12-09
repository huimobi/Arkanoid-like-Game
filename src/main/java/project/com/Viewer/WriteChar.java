package project.com.Viewer;

import com.googlecode.lanterna.TextColor;
import project.com.Model.Position;
import project.com.gui.GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class WriteChar {
    private final char c;
    int height = 7;
    int width = 7;
    private final ImageReader image;
    private Position position;
    private final TextColor foregroundColor;

    public WriteChar(char c1) throws IOException {
        this.c=Character.toUpperCase(c1);
        this.image= new PNGReader("Characters/" + c);
        this.foregroundColor=TextColor.ANSI.WHITE_BRIGHT;
    }

    //draws char on the position
    public void draw_char(GUI gui, Position position) throws IOException {
        image.draw(gui,position);
        this.position=position;
    }

    //changes character foreground
    public void setForeground(GUI gui,String foreground){
        TextColor color= parseColor(foreground); //picks the color
        ArrayList<Position> char_foreground=getForeground(); //get foreground pixels
        image.changePixelColor(gui,char_foreground,color);
    }

    public void setForeground(GUI gui){
        ArrayList<Position> char_foreground=getForeground(); //get foreground pixels
        image.changePixelColor(gui,char_foreground,foregroundColor);
    }

    //set foreground white
    public void setForegroundDefault(GUI gui){
        image.changePixelColor(gui,getForeground(),foregroundColor);
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

    public int getWidth() {
        return width;
    }

    public ArrayList<Position> getForeground() {
        ArrayList<Position> white_pixels= new ArrayList<>();

        BufferedImage character=image.getImage();

        for (int px = 0; px < character.getWidth(); px++) {
            for (int py = 0; py < character.getHeight(); py++) {
                int rgb=character.getRGB(px,py);
                if(new Color(rgb,true).getAlpha()==0) continue;
                if(Color.white.equals(new Color(rgb,true))){
                    white_pixels.add(new Position(px+position.getX(),py+position.getY()));
                }
            }
        }
        return white_pixels;
    }

}
