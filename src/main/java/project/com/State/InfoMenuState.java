package project.com.State;

import project.com.Control.Controller;
import project.com.Control.Menu.InfoMenuController;
import project.com.Control.Menu.OptionsController;
import project.com.Model.InfoMenu;
import project.com.Viewer.ImageLoader;
import project.com.Viewer.Screen.InfoViewer;
import project.com.Viewer.Screen.Viewer;
import project.com.Viewer.ViewerProvider;

import java.io.IOException;

public class InfoMenuState extends State<InfoMenu> {

    public InfoMenuState(InfoMenu model, ImageLoader imageLoader) throws IOException {
        super(model, imageLoader);
    }

    @Override
    protected Viewer<InfoMenu> createViewer(ViewerProvider viewerProvider) {
        return new InfoViewer(getModel(), viewerProvider);
    }

    @Override
    protected Controller<InfoMenu> createController() {
        return new InfoMenuController(getModel(),new OptionsController(getModel()));
    }

}