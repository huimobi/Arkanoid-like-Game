package project.com.Viewer.Info;

import project.com.Model.Position;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

public class LeftViewer {
    private final ImageReader image;

    public LeftViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("Info/Left.png");
    }

    public void draw(GUI gui, Position position) {
        image.draw(gui, position);
    }
}