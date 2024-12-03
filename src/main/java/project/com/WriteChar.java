package project.com;

import com.googlecode.lanterna.TextColor;
import project.com.Model.Position;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class WriteChar {
    private char c;
    int height = 7;
    int width = 7;
    private final PNG_draw char_png;


    public WriteChar(char c1) throws IOException {
        this.c=Character.toUpperCase(c1);
        this.char_png= new PNG_draw("Characters/" + c +".png");
    }

    //draws char on the position
    public void draw_char(Position p) throws IOException {
        char_png.drawImage(p);
    }

    //changes character foreground
    public void setForeground(String foreground){
        TextColor color=new TextColor.RGB(getRed(foreground),getGreen(foreground),getBlue(foreground)); //picks the color
        ArrayList<Position> char_foreground=char_png.get_white_pixels(); //get foreground pixels from png
        char_png.changePixelColor(char_foreground,color);
    }

    //set foreground white
    public void setForegroundDefault(){
        char_png.changePixelColor(char_png.get_white_pixels(),TextColor.ANSI.WHITE_BRIGHT);
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

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public char getC() {
        return c;
    }
}
