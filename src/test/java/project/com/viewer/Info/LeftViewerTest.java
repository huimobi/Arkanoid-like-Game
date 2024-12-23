package project.com.viewer.Info;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;
import project.com.Viewer.Info.LeftViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LeftViewerTest {
    private GUI gui;
    private ImageLoader imageLoader;

    @BeforeEach
    public void setup() {
        this.imageLoader = mock(ImageLoader.class);
        this.gui = mock(project.com.gui.GUI.class);
    }

    @Test
    public void draw() throws IOException {
        ImageReader LeftImage = mock(ImageReader.class);
        when(imageLoader.get("Info/Left.png")).thenReturn(LeftImage);
        LeftViewer LeftViewer = new LeftViewer(imageLoader);

        LeftViewer.draw(gui,new Position(10,10));
        verify(LeftImage, times(1)).draw(gui,new Position(10,10));
    }
}
