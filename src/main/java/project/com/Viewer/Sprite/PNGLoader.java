package project.com.Viewer.Sprite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PNGLoader implements ImageLoader{
    final Map<String, ImageReader> imageMap;

    public PNGLoader() {
        this.imageMap = new HashMap<>();
    }

    @Override
    public ImageReader get(String imageFilepath) throws IOException {
        if (!imageMap.containsKey(imageFilepath))
            imageMap.put(imageFilepath, new PNGReader(imageFilepath));
        return imageMap.get(imageFilepath);
    }
}
