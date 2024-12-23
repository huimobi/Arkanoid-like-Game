package viewer.Info;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;
import project.com.Viewer.Info.WordInfoViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class WordInfoViewerTest {
    private GUI gui;
    private ImageLoader imageLoader;

    @BeforeEach
    public void setup() {
        this.imageLoader = mock(ImageLoader.class);
        this.gui = mock(project.com.gui.GUI.class);
    }

    @Test
    public void draw() throws IOException {
        ImageReader WordInfoImage = mock(ImageReader.class);
        when(imageLoader.get("Info/INFO.png")).thenReturn(WordInfoImage);
        WordInfoViewer WordInfoViewer = new WordInfoViewer(imageLoader);

        WordInfoViewer.draw(gui,new Position(10,10));
        verify(WordInfoImage, times(1)).draw(gui,new Position(10,10));
    }
}
