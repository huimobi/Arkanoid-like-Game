package project.com.Viewer.Elements;


import project.com.Model.Elements.PowerUp;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

public class PowerUpViewer implements ElementViewer<PowerUp>{

    private final ImageReader image;

    public PowerUpViewer(ImageLoader imageLoader) throws IOException {
        this.image = imageLoader.get("Elements/PowerUp/powerup.png");
    }
    @Override
    public void draw(PowerUp model, GUI gui) {
        image.draw(gui,model.getPosition());
    }
}
