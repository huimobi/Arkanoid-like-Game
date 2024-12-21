package project.com.Viewer.Elements;

import project.com.Model.Elements.Brick;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BrickViewer implements ElementViewer<Brick>{
    private final Map<Character, ImageReader> brickMap;


    public BrickViewer(ImageLoader ImageLoader) throws IOException {
        brickMap = new HashMap<>();
        brickMap.put('B', ImageLoader.get("Elements/Brick/brick1.png"));
        brickMap.put('Y', ImageLoader.get("Elements/Brick/brick2.png"));
        brickMap.put('G', ImageLoader.get("Elements/Brick/brick3.png"));
        brickMap.put('P', ImageLoader.get("Elements/Brick/brick4.png"));
        brickMap.put('#', ImageLoader.get("Elements/Brick/unbreakableBrick.png"));
    }

    //depending on the character the corresponding brick will be drawn
    @Override
    public void draw(Brick model, GUI gui) {
        ImageReader image= brickMap.get(model.getCharacter());
        image.draw(gui,model.getPosition());
    }
}
