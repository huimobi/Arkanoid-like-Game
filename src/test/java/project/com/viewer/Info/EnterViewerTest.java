package project.com.viewer.Info;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;
import project.com.Viewer.Info.EnterViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class EnterViewerTest {
    private GUI gui;
    private ImageLoader imageLoader;

    @BeforeEach
    public void setup() {
        this.imageLoader = mock(ImageLoader.class);
        this.gui = mock(GUI.class);
    }

    @Test
    public void draw() throws IOException {
        ImageReader EnterImage = mock(ImageReader.class);
        when(imageLoader.get("Info/Enter.png")).thenReturn(EnterImage);
        EnterViewer enterViewer = new EnterViewer(imageLoader);

        enterViewer.draw(gui,new Position(10,10));
        verify(EnterImage, times(1)).draw(gui,new Position(10,10));
    }
}
