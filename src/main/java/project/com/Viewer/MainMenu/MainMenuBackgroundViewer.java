package project.com.Viewer.MainMenu;

import project.com.Model.Position;
import project.com.Viewer.ImageLoader;
import project.com.Viewer.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

public class MainMenuBackgroundViewer {
    private final ImageReader image;

    public MainMenuBackgroundViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("Menu/background.png");
    }

    public void draw(GUI gui) {
        image.draw(gui,new Position(0,0));
    }
}
