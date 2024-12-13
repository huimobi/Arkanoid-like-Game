package project.com.State;

import project.com.Control.Controller;
import project.com.Model.Info;
import project.com.Viewer.ImageLoader;
import project.com.Viewer.Screen.InfoViewer;
import project.com.Viewer.Screen.Viewer;
import project.com.Viewer.ViewerProvider;

import java.io.IOException;

public class InfoState extends State<Info> {

    public InfoState(Info model, ImageLoader imageLoader) throws IOException {
        super(model, imageLoader);
    }

    @Override
    protected Viewer<Info> createViewer(ViewerProvider viewerProvider) {
        return new InfoViewer(getModel(), viewerProvider);
    }

    @Override
    protected Controller<Info> createController() {
        return null;
    }

    @Override
    protected boolean allowArrowSpam() {
        return false;
    }

}