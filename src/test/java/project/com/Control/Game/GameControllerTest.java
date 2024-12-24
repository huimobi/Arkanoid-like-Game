package project.com.Control.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import project.com.Arkanoid;
import project.com.Model.Levels.HighScore;
import project.com.Model.Levels.Level;
import project.com.Model.Elements.Paddle;
import project.com.State.GameState;
import project.com.State.MainMenuState;
import project.com.Viewer.Sprite.ImageReader;
import project.com.gui.GUI;
import project.com.Viewer.Sprite.ImageLoader;

import javax.swing.text.Position;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static project.com.Model.Levels.HighScore.setHighScore;

public class GameControllerTest {

    private GameController gameController;
    private Arkanoid arkanoid;
    private BallController ballController;
    private PaddleController paddleController;
    private PowerUpController powerUpController;
    private Level level;

    @Mock
    private Position mockPosition;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        ballController = mock(BallController.class);
        paddleController = mock(PaddleController.class);
        powerUpController = mock(PowerUpController.class);
        arkanoid = mock(Arkanoid.class);
        level = mock(Level.class);

        Paddle mockPaddle = mock(Paddle.class);
        when(level.getPaddle()).thenReturn(mockPaddle);

        project.com.Model.Position mockPosition = mock(project.com.Model.Position.class);
        when(mockPaddle.getPosition()).thenReturn(mockPosition);

        ImageLoader imageLoader = mock(ImageLoader.class);
        when(imageLoader.get(anyString())).thenReturn(mock(ImageReader.class));
        when(arkanoid.getImageLoader()).thenReturn(imageLoader);

        gameController = new GameController(level, ballController, paddleController, powerUpController);
    }

    @Test
    void testStep_GameOverAndReturnToMainMenu() throws Exception {
        ImageLoader imageLoader = mock(ImageLoader.class);
        when(arkanoid.getImageLoader()).thenReturn(imageLoader);
        when(imageLoader.get(anyString())).thenReturn(mock(ImageReader.class));

        Paddle mockPaddle = mock(Paddle.class);
        when(level.getPaddle()).thenReturn(mockPaddle);
        when(mockPaddle.getLives()).thenReturn(0);

        gameController.step(arkanoid, GUI.ACTION.QUIT, 1000L);

        verify(arkanoid).setState(any(MainMenuState.class));
    }

}