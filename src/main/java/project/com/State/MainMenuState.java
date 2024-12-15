package project.com.State;

import project.com.Control.Controller;
import project.com.Control.Menu.MainMenuController;
import project.com.Control.Menu.OptionsController;
import project.com.Model.MainMenu;
import project.com.Model.Menu;
import project.com.Viewer.ImageLoader;
import project.com.Viewer.Screen.MainMenuViewer;
import project.com.Viewer.Screen.Viewer;
import project.com.Viewer.ViewerProvider;

import java.io.IOException;

public class MainMenuState extends State<MainMenu> {

    public MainMenuState(MainMenu model, ImageLoader ImageLoader) throws IOException {
        super(model, ImageLoader);
    }

    @Override
    protected Viewer<MainMenu> createViewer(ViewerProvider viewerProvider) {
        return new MainMenuViewer(getModel(), viewerProvider);
    }

    @Override
    protected Controller<MainMenu> createController() {
        return new MainMenuController(getModel(), new OptionsController(getModel()));
    }
}
