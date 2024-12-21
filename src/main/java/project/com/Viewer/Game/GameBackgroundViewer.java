package project.com.Viewer.Game;

import project.com.Model.Position;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

public class GameBackgroundViewer {
    private final ImageReader image;

    public GameBackgroundViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("Game/background.png");
    }

    public void draw(GUI gui) {
        image.draw(gui,new Position(0,0));
    }
}
