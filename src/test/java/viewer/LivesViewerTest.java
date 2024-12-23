package viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Elements.Paddle;
import project.com.Model.Position;
import project.com.Viewer.Elements.LivesViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LivesViewerTest {
    private GUI gui;
    private ImageLoader imageLoader;
    private Paddle paddle;
    private BufferedImage image;

    @BeforeEach
    public void setup() {
        this.imageLoader = mock(ImageLoader.class);
        this.gui = mock(GUI.class);
        this.paddle= mock(Paddle.class);
        this.image=new BufferedImage(4,4,1);
    }

    @Test
    public void draw3lives() throws IOException {
        ImageReader livesImage = mock(ImageReader.class);
        when(imageLoader.get("Game/lives.png")).thenReturn(livesImage);
        when(gui.getWidth()).thenReturn(100);
        when(livesImage.getImage()).thenReturn(image);
        when(paddle.getLives()).thenReturn(3);
        LivesViewer LivesViewer = new LivesViewer(imageLoader);
        LivesViewer.draw(paddle, gui);
    }


    @Test
    public void draw1lives() throws IOException {
        ImageReader livesImage = mock(ImageReader.class);
        when(imageLoader.get("Game/lives.png")).thenReturn(livesImage);
        when(gui.getWidth()).thenReturn(100);
        when(livesImage.getImage()).thenReturn(image);
        when(paddle.getLives()).thenReturn(1);
        LivesViewer LivesViewer = new LivesViewer(imageLoader);
        LivesViewer.draw(paddle, gui);
        verify(gui, times(1)).drawImage(eq(image), any(Position.class));
    }
}
