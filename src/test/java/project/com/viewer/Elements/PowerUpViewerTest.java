package project.com.viewer.Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Elements.PowerUp;
import project.com.Model.Position;
import project.com.Viewer.Elements.PowerUpViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class PowerUpViewerTest {
    private GUI gui;
    private ImageLoader imageLoader;

    @BeforeEach
    public void setup() {
        this.imageLoader = mock(ImageLoader.class);
        this.gui = mock(GUI.class);
    }

    @Test
    public void draw() throws IOException {
        ImageReader PowerUpImage = mock(ImageReader.class);
        when(imageLoader.get("Elements/PowerUp/powerup.png")).thenReturn(PowerUpImage);
        PowerUpViewer PowerUpViewer = new PowerUpViewer(imageLoader);
        PowerUp PowerUp = new PowerUp(new Position(10,10));
        PowerUpViewer.draw(PowerUp, gui);
        verify(PowerUpImage, times(1)).draw(gui, PowerUp.getPosition());
    }
}
