package project.com.Viewer.Info;

import project.com.Model.Position;
import project.com.Viewer.ImageLoader;
import project.com.Viewer.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

public class ESCViewer {
    private final ImageReader image;

    public ESCViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("Info/ESC.png");
    }

    public void draw(GUI gui, Position position) {
        image.draw(gui, position);
    }
}