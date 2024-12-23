package viewer.Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Elements.Ball;
import project.com.Model.Position;
import project.com.Viewer.Elements.BallViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class BallViewerTest{
    private GUI gui;
    private ImageLoader imageLoader;

    @BeforeEach
    public void setup() {
        this.imageLoader = mock(ImageLoader.class);
        this.gui = mock(GUI.class);
    }

    @Test
    public void draw() throws IOException {
        ImageReader ballImage = mock(ImageReader.class);
        when(imageLoader.get("Elements/Ball/ball.png")).thenReturn(ballImage);
        BallViewer ballViewer = new BallViewer(imageLoader);
        Ball ball = new Ball(new Position(10,10));
        ballViewer.draw(ball, gui);
        verify(ballImage, times(1)).draw(gui, ball.getPosition());
    }
}
