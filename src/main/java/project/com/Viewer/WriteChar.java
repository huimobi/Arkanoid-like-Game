package project.com.Viewer;

import com.googlecode.lanterna.TextColor;
import project.com.Model.Position;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class WriteChar {
    private final char c;
    int height = 7;
    int width = 7;
    private final PNGReader char_png;


    public WriteChar(char c1) throws IOException {
        this.c=Character.toUpperCase(c1);
        this.char_png= new PNGReader("Characters/" + c +".png");
    }

    //draws char on the position
    public void draw_char(GUI gui, Position p) throws IOException {
        char_png.draw(gui,p);
    }

    //changes character foreground
    public void setForeground(GUI gui,String foreground){
        TextColor color=new TextColor.RGB(getRed(foreground),getGreen(foreground),getBlue(foreground)); //picks the color
        ArrayList<Position> char_foreground=char_png.getForeground(); //get foreground pixels from png
        char_png.changePixelColor(gui,char_foreground,color);
    }

    //set foreground white
    public void setForegroundDefault(GUI gui){
        char_png.changePixelColor(gui,char_png.getForeground(),TextColor.ANSI.WHITE_BRIGHT);
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

}
