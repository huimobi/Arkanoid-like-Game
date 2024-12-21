package project.com.State;


import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Screen.Viewer;
import project.com.Viewer.ViewerProvider;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class State<T> {
    private final T model;
    protected final Controller<T> controller;
    protected final Viewer<T> viewer;

    public State(T model, ImageLoader imageLoader) throws IOException {
        this.model = model;
        this.viewer = createViewer(new ViewerProvider(imageLoader));
        this.controller = createController();
    }

    protected abstract Viewer<T> createViewer(ViewerProvider viewerProvider);

    protected abstract Controller<T> createController();


    public T getModel() {
        return model;
    }

    public Viewer<T> getViewer() {
        return viewer;
    }

    public Controller<T> getController() {
        return controller;
    }

    public void step(Arkanoid arkanoid, GUI gui, long frameTime) throws IOException, URISyntaxException, FontFormatException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(arkanoid, action, frameTime);
        viewer.draw(gui);
    }
}

