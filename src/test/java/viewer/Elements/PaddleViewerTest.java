package viewer.Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Elements.Paddle;
import project.com.Model.Position;
import project.com.Viewer.Elements.PaddleViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class PaddleViewerTest {
    private GUI gui;
    private ImageLoader imageLoader;
    private Paddle paddle;

    @BeforeEach
    public void setup() {
        this.imageLoader = mock(ImageLoader.class);
        this.gui = mock(GUI.class);
        this.paddle=mock(Paddle.class);
    }

    @Test
    public void draw() throws IOException {
        ImageReader paddleImage = mock(ImageReader.class);
        ImageReader powerUpImage= mock(ImageReader.class);
        when(imageLoader.get("Elements/Paddle/paddle.png")).thenReturn(paddleImage);
        when(imageLoader.get("Elements/Paddle/powerUpPaddle.png")).thenReturn(powerUpImage);

        PaddleViewer paddleViewer = new PaddleViewer(imageLoader);

        when(paddle.getPowerUp()).thenReturn(false);
        when(paddle.getPosition()).thenReturn(new Position(10,10));

        paddleViewer.draw(paddle, gui);

        when(paddle.getPowerUp()).thenReturn(true); //powerUpOn
        paddleViewer.draw(paddle,gui);

        verify(paddleImage,times(1)).draw(gui, paddle.getPosition());
        verify(paddleImage,times(1)).draw(gui, paddle.getPosition());
    }
}
