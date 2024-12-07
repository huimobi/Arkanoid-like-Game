package project.com.Viewer.Elements;

import project.com.Model.Bricks;
import project.com.Viewer.ImageLoader;
import project.com.Viewer.ImageReader;
import project.com.Viewer.PNGReader;
import project.com.gui.GUI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BrickViewer implements ElementViewer<Bricks>{
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
    public void draw(Bricks model, GUI gui) {
        ImageReader png= brickMap.get(model.getCharacter());
        png.draw(gui, model.getPosition());
    }
}
