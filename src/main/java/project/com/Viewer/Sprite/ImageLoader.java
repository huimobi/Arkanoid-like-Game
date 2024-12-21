package project.com.Viewer.Sprite;

import java.io.IOException;

public interface ImageLoader {
    ImageReader get(String spriteFilepath) throws IOException;
}
