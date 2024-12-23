package viewer.Sprite;

import org.junit.jupiter.api.Test;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.Viewer.Sprite.PNGLoader;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PNGLoaderTest {
    @Test
    public void get() throws IOException {
        ImageLoader pngLoader = new PNGLoader();
        String filepath1 = "Images/test1.png";
        URL resource1 = getClass().getClassLoader().getResource("Images/test1.png");
        assertNotNull(resource1);
        BufferedImage image1 = ImageIO.read(new File(resource1.getFile()));

        String filepath2 = "Images/test2.png";
        URL resource2 = getClass().getClassLoader().getResource("Images/test2.png");
        assertNotNull(resource2);
        BufferedImage image2 = ImageIO.read(new File(resource2.getFile()));

        ImageReader sprite1 = pngLoader.get(filepath1);
        ImageReader sprite2 = pngLoader.get(filepath2);
        ImageReader sprite3 = pngLoader.get(filepath1);

        assertTrue(equal(image1, sprite1.getImage()));
        assertTrue(equal(image2, sprite2.getImage()));
        assertSame(sprite1, sprite3);
    }

    private boolean equal(BufferedImage image1,BufferedImage image2){
        int[] colors1 = image1.getRGB(0, 0, image1.getWidth(), image1.getHeight(), null, 0, image1.getWidth());
        int[] colors2 = image2.getRGB(0, 0, image2.getWidth(), image2.getHeight(), null, 0, image2.getWidth());
        return Arrays.equals(colors1, colors2);
    }
}
