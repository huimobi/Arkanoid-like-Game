package project.com.Viewer;

import java.io.IOException;

public interface ImageLoader {
    ImageReader get(String spriteFilepath) throws IOException;
}
