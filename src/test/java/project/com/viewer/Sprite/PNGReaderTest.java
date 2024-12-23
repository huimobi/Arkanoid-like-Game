package project.com.viewer.Sprite;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;
import project.com.Viewer.Sprite.ImageReader;
import project.com.Viewer.Sprite.PNGReader;
import project.com.gui.GUI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PNGReaderTest {
    private GUI gui;
    @BeforeEach
    public void SetUp(){
        this.gui=mock(GUI.class);
    }
    @Test
    public void drawTest() throws IOException {
        Position position = new Position(10, 20);
        ImageReader pngReader = new PNGReader("Images/test1.png");

        URL resource1 = getClass().getClassLoader().getResource("Images/test1.png");
        assertNotNull(resource1);
        BufferedImage image = ImageIO.read(new File(resource1.getFile()));

        pngReader.draw(gui, position);
        verify(gui,times(1)).drawImage(any(BufferedImage.class),any(Position.class));
        assertTrue(equal(image, pngReader.getImage()));
    }
    @Test
    public void changePixelColorTest() throws IOException {
        Position position = new Position(10, 20);
        ImageReader pngReader = new PNGReader("Images/test1.png");
        ArrayList<Position> positions= new ArrayList<>();
        TextColor pixelColor= new TextColor.RGB(255,255,255);

        URL resource1 = getClass().getClassLoader().getResource("Images/test1.png");
        assertNotNull(resource1);
        BufferedImage image = ImageIO.read(new File(resource1.getFile()));

        pngReader.changePixelColor(gui, position,positions,pixelColor);

        verify(gui,times(1)).changedDrawImage(any(BufferedImage.class),any(Position.class),eq(positions),any(TextColor.class));
        assertTrue(equal(image, pngReader.getImage()));
    }

    @Test
    public void testChangePixelColor() throws IOException {
        Position topLeftPosition = new Position(0, 0); // Example top-left position

        ArrayList<Position> positions = new ArrayList<>();
        positions.add(new Position(0, 0));
        positions.add(new Position(1, 0));

        URL resource1 = getClass().getClassLoader().getResource("Images/test1.png");
        assertNotNull(resource1);
        BufferedImage image = ImageIO.read(new File(resource1.getFile()));

        ImageReader pngReader = new PNGReader("Images/test1.png");
        String pixelColor = "#FF5733";

        pngReader.changePixelColor(gui, topLeftPosition, positions, pixelColor);

        verify(gui).changedDrawImage(
                any(BufferedImage.class),
                eq(topLeftPosition),
                eq(positions),
                eq(new TextColor.RGB(255, 87, 51))
        );
        assertTrue(equal(image, pngReader.getImage()));
    }

    private boolean equal(BufferedImage image1,BufferedImage image2){
        int[] colors1 = image1.getRGB(0, 0, image1.getWidth(), image1.getHeight(), null, 0, image1.getWidth());
        int[] colors2 = image2.getRGB(0, 0, image2.getWidth(), image2.getHeight(), null, 0, image2.getWidth());
        return Arrays.equals(colors1, colors2);
    }
}
