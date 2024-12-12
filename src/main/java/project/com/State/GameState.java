package project.com.State;

import project.com.Control.Controller;
import project.com.Model.Level;
import project.com.Viewer.ImageLoader;
import project.com.Viewer.Screen.GameViewer;
import project.com.Viewer.Screen.Viewer;
import project.com.Viewer.ViewerProvider;

import java.io.IOException;

public class GameState extends State<Level>{
    public GameState(Level model, ImageLoader imageLoader) throws IOException {
        super(model, imageLoader);
    }

    @Override
    protected Viewer<Level> createViewer(ViewerProvider viewerProvider) {
        return new GameViewer(getModel(), viewerProvider);
    }

    @Override
    protected Controller<Level> createController() {
        return null;
    }

    @Override
    protected boolean allowArrowSpam() {
        return false;
    }
}
