package project.com.Viewer.Elements;

import project.com.Model.Elements.Ball;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

public class BallViewer implements ElementViewer<Ball>{
    private final ImageReader image;

    public BallViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("Elements/Ball/ball.png");
    }
    @Override
    public void draw(Ball model, GUI gui) {
        image.draw(gui,model.getPosition());
    }
}
