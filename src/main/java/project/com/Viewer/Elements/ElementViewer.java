package project.com.Viewer.Elements;

import project.com.gui.GUI;

public interface ElementViewer<T> {
    void draw(T model, GUI gui);
}