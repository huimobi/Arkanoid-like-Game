package project.com;

import project.com.Model.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteText{
    private String string;
    private int lenght;
    private List<WriteChar> text=new ArrayList<>();


    public WriteText(String s) throws IOException {
        this.string = s.toUpperCase();
        this.lenght=s.length();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            text.add(new WriteChar(c));
        }
    }

    public void drawText(Position startPosition) throws IOException {
        for(int i=0;i<lenght;i++){
            text.get(i).draw_char(new Position(startPosition.getX()+ i*text.get(i).getWidth(),startPosition.getY()));
        }
    }

    public void setForegroundColor(String color){
        for(int i=0;i<lenght;i++){
            text.get(i).setForeground(color);
        }
    }

    public void setForegroundDefault(){
        for(int i=0;i<lenght;i++){
            text.get(i).setForegroundDefault();
        }
    }

    public String getString() {
        return string;
    }

    public int getLenght() {
        return lenght;
    }
}
