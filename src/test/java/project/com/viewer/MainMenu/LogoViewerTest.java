package project.com.viewer.MainMenu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;
import project.com.Viewer.MainMenu.LogoViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LogoViewerTest {
    private GUI gui;
    private ImageLoader imageLoader;

    @BeforeEach
    public void setup() {
        this.imageLoader = mock(ImageLoader.class);
        this.gui = mock(GUI.class);
    }

    @Test
    public void draw() throws IOException {
        ImageReader logoImage = mock(ImageReader.class);
        when(imageLoader.get("Menu/arkanoid.png")).thenReturn(logoImage);
        LogoViewer logoViewer = new LogoViewer(imageLoader);

        logoViewer.draw(gui,new Position(10,10));
        verify(logoImage, times(1)).draw(gui,new Position(10,10));
    }
}
