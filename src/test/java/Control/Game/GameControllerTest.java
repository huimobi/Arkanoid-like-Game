package project.com.Control.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import project.com.Arkanoid;
import project.com.Model.HighScore;
import project.com.Model.Level;
import project.com.Model.Paddle;
import project.com.State.GameState;
import project.com.State.MainMenuState;
import project.com.Viewer.ImageReader;
import project.com.gui.GUI;
import project.com.Viewer.ImageLoader;

import javax.swing.text.Position;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static project.com.Model.HighScore.setHighScore;

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

        // Certifique-se de usar o tipo correto
        project.com.Model.Position mockPosition = mock(project.com.Model.Position.class);
        when(mockPaddle.getPosition()).thenReturn(mockPosition);

        ImageLoader imageLoader = mock(ImageLoader.class);
        when(imageLoader.get(anyString())).thenReturn(mock(ImageReader.class));
        when(arkanoid.getImageLoader()).thenReturn(imageLoader);

        gameController = new GameController(level, ballController, paddleController, powerUpController);
    }

    @Test
    void testStep_GameOverAndReturnToMainMenu() throws Exception {
        // Mock para o ImageLoader dentro do estado MainMenuState
        ImageLoader imageLoader = mock(ImageLoader.class);
        when(arkanoid.getImageLoader()).thenReturn(imageLoader);
        when(imageLoader.get(anyString())).thenReturn(mock(ImageReader.class));

        // Configurar mocks para simular o fim do jogo
        Paddle mockPaddle = mock(Paddle.class);
        when(level.getPaddle()).thenReturn(mockPaddle);
        when(mockPaddle.getLives()).thenReturn(0);

        // Chamar o método step
        gameController.step(arkanoid, GUI.ACTION.QUIT, 1000L);

        // Verificar se o estado foi alterado para o menu principal
        verify(arkanoid).setState(any(MainMenuState.class));
    }

    @Test
    void testStep_UpdateHighScoreWhenGameOver() throws Exception {
        // Configurar mocks para simular o fim do jogo e um placar alto
        when(level.getPaddle()).thenReturn(mock(Paddle.class));
        when(level.getPaddle().getLives()).thenReturn(0);
        when(level.getScore()).thenReturn(100);

        // Usar mockStatic para mockar os métodos estáticos
        try (MockedStatic<HighScore> highScoreMocked = mockStatic(HighScore.class)) {
            // Mock do método estático loadHighScore
            highScoreMocked.when(HighScore::loadHighScore).thenReturn(50);

            // Chamar o método step
            gameController.step(arkanoid, GUI.ACTION.QUIT, 1000L);

            // Verificar se o método setHighScore foi chamado corretamente
            highScoreMocked.verify(() -> setHighScore(100));
        }
    }

}
