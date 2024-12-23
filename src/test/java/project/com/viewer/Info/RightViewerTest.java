package project.com.viewer.Info;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;
import project.com.Viewer.Info.RightViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class RightViewerTest {
    private GUI gui;
    private ImageLoader imageLoader;

    @BeforeEach
    public void setup() {
        this.imageLoader = mock(ImageLoader.class);
        this.gui = mock(project.com.gui.GUI.class);
    }

    @Test
    public void draw() throws IOException {
        ImageReader RightImage = mock(ImageReader.class);
        when(imageLoader.get("Info/Right.png")).thenReturn(RightImage);
        RightViewer RightViewer = new RightViewer(imageLoader);

        RightViewer.draw(gui,new Position(10,10));
        verify(RightImage, times(1)).draw(gui,new Position(10,10));
    }
}
