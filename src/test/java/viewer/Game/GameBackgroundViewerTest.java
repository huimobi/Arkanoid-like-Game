package viewer.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;
import project.com.Viewer.Game.GameBackgroundViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class GameBackgroundViewerTest {
    private GUI gui;
    private ImageLoader imageLoader;

    @BeforeEach
    public void setup() {
        this.imageLoader = mock(ImageLoader.class);
        this.gui = mock(GUI.class);
    }

    @Test
    public void draw() throws IOException {
        ImageReader backgroundImage = mock(ImageReader.class);
        when(imageLoader.get("Game/background.png")).thenReturn(backgroundImage);
        GameBackgroundViewer backgroundViewer = new GameBackgroundViewer(imageLoader);

        backgroundViewer.draw(gui);
        verify(backgroundImage, times(1)).draw(gui,new Position(0,0));
    }
}
