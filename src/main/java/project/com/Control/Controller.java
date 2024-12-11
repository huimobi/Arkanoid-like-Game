package project.com.Control;

import project.com.Arkanoid;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Controller<T> {
    private final T model;

    protected Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step (Arkanoid arkanoid, GUI.ACTION action, long frameCount) throws IOException, URISyntaxException, FontFormatException;

}
