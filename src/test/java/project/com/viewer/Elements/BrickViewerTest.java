package project.com.viewer.Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Elements.Brick;
import project.com.Model.Position;
import project.com.Viewer.Elements.BrickViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class BrickViewerTest {
    private GUI gui;
    private ImageLoader imageLoader;
    @BeforeEach
    public void setup() {
        this.imageLoader = mock(ImageLoader.class);
        this.gui = mock(GUI.class);
    }

    @Test
    public void draw() throws IOException {
        ImageReader brick1image = mock(ImageReader.class);
        ImageReader brick2image =  mock(ImageReader.class);

        when(imageLoader.get("Elements/Brick/brick1.png")).thenReturn(brick1image);
        when(imageLoader.get("Elements/Brick/brick2.png")).thenReturn(brick2image);


        Brick brick1 = new Brick(new Position(10, 10),'B');
        Brick brick2= new Brick(new Position(20, 20),'Y');

        BrickViewer brickViewer= new BrickViewer(imageLoader);

        brickViewer.draw(brick1,gui);
        brickViewer.draw(brick2,gui);

        verify(brick1image, times(1)).draw(gui, brick1.getPosition());
        verify(brick2image, times(1)).draw(gui, brick2.getPosition());
    }
}
