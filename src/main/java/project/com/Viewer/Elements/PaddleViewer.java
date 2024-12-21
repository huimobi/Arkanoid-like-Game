package project.com.Viewer.Elements;

import project.com.Model.Elements.Paddle;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

public class PaddleViewer implements ElementViewer<Paddle>{
    private final ImageReader defaultPaddle;
    private final ImageReader powerUpPaddle;


    public PaddleViewer(ImageLoader imageLoader) throws IOException {
        this.defaultPaddle=imageLoader.get("Elements/Paddle/paddle.png");
        this.powerUpPaddle=imageLoader.get("Elements/Paddle/powerUpPaddle.png");
    }
    @Override
    public void draw(Paddle model, GUI gui) {
        if(model.getPowerUp()) powerUpPaddle.draw(gui,model.getPosition());
        else defaultPaddle.draw(gui,model.getPosition());
    }
}
