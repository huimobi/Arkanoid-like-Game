package project.com.Viewer.Elements;

import project.com.gui.GUI;

import java.io.IOException;

public interface ElementViewer<T> {
    void draw(T model, GUI gui) throws IOException;
}