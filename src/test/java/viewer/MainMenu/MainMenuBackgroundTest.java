package viewer.MainMenu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;
import project.com.Viewer.MainMenu.MainMenuBackgroundViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class MainMenuBackgroundTest {
    private GUI gui;
    private ImageLoader imageLoader;

    @BeforeEach
    public void setup() {
        this.imageLoader = mock(ImageLoader.class);
        this.gui = mock(GUI.class);
    }

    @Test
    public void draw() throws IOException {
        ImageReader MainMenuBackgroundImage = mock(ImageReader.class);
        when(imageLoader.get("Menu/background.png")).thenReturn(MainMenuBackgroundImage);
        MainMenuBackgroundViewer MainMenuBackgroundViewer = new MainMenuBackgroundViewer(imageLoader);

        MainMenuBackgroundViewer.draw(gui);
        verify(MainMenuBackgroundImage, times(1)).draw(gui,new Position(0,0));
    }
}
