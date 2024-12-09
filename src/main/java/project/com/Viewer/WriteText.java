package project.com.Viewer;

import com.googlecode.lanterna.TextColor;
import project.com.Model.Position;
import project.com.gui.GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteText{
    private final String string;
    private final int length;
    private final List<WriteChar> text=new ArrayList<>();


    //creates strings with default foreground (white)
    public WriteText(String s) throws IOException {
        this.string = s.toUpperCase();
        this.length=s.length();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            text.add(new WriteChar(c));
        }
    }

    public WriteText(String s,String foreground) throws IOException {
        this.string = s.toUpperCase();
        this.length=s.length();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            text.add(new WriteChar(c));
        }
    }

    public void drawText(GUI gui, Position startPosition) throws IOException {
        for(int i=0;i<length;i++){
            text.get(i).draw_char(gui,new Position(startPosition.getX()+ i*text.get(i).getWidth(),startPosition.getY()));
        }
    }

    public void setForegroundColor(GUI gui,String color){
        for(int i=0;i<length;i++){
            text.get(i).setForeground(gui,color);
        }
    }

    public void setForegroundDefault(GUI gui){
        for(int i=0;i<length;i++){
            text.get(i).setForegroundDefault(gui);
        }
    }

    public String getString() {
        return string;
    }

    public int getLength() {
        return length;
    }
}
