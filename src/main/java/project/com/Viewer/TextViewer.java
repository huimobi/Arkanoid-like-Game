package project.com.Viewer;

import project.com.Model.Position;
import project.com.gui.GUI;

import java.io.IOException;

public interface TextViewer {
    void draw(char character, Position position, String foregroundColor, GUI gui) throws IOException;
    void draw(String string, Position position,  String foregroundColor, GUI gui) throws IOException;
    void draw(char character, Position position, GUI gui) throws IOException;
    void draw(String string, Position position, GUI gui) throws IOException;
    void setForegroundDefault(GUI gui,Position startPosition,char c);
    void setForegroundDefault(GUI gui,Position startPosition,String string);
    void setForeground(GUI gui,String color,Position startPosition,String text) throws IOException;

}
