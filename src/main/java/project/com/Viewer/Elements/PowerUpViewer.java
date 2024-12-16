package project.com.Viewer.Elements;


import project.com.Model.PowerUp;
import project.com.Viewer.ImageLoader;
import project.com.Viewer.ImageReader;
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
