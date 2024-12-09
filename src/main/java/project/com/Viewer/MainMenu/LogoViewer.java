package project.com.Viewer.MainMenu;

import project.com.Model.Position;
import project.com.Viewer.ImageLoader;
import project.com.Viewer.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

public class LogoViewer {
    private final ImageReader image;

    public LogoViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("Menu/arkanoid.png");
    }

    public void draw(GUI gui,Position position) {
        image.draw(gui,position);
    }
}
