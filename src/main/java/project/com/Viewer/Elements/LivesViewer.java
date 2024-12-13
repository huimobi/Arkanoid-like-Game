package project.com.Viewer.Elements;

import project.com.Model.Paddle;
import project.com.Model.Position;
import project.com.Viewer.ImageLoader;
import project.com.Viewer.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

public class LivesViewer implements ElementViewer<Paddle>{
    private final ImageReader image;
    public LivesViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("Game/lives.png");

    }

    @Override
    public void draw(Paddle model, GUI gui) {
        Position position = new Position(gui.getWidth() - image.getImage().getWidth() -3, 3);
        switch (model.getLives()) {
            case 1 -> gui.drawImage(image.getImage(), position);
            case 2 -> {
                gui.drawImage(image.getImage(), position);
                gui.drawImage(image.getImage(), new Position(position.getX() - image.getImage().getWidth(), position.getY()));
            }
            case 3 -> {
                gui.drawImage(image.getImage(), position);
                gui.drawImage(image.getImage(), new Position(position.getX() - image.getImage().getWidth(), position.getY()));
                gui.drawImage(image.getImage(), new Position(position.getX() - 2 * image.getImage().getWidth(), position.getY()));
            }
        }
    }
}
