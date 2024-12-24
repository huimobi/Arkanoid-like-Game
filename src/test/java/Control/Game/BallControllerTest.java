package project.com.Control.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.com.Arkanoid;
import project.com.Model.*;
import project.com.gui.GUI;

import java.awt.*;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BallControllerTest {

    private BallController ballController;
    private Level mockLevel;
    private Ball mockBall;
    private Paddle mockPaddle;
    private Arkanoid mockArkanoid;
    private GUI mockGUI;



    @BeforeEach
    void setUp() {
        // Mockar dependências
        mockLevel = mock(Level.class);
        mockBall = mock(Ball.class);
        mockPaddle = mock(Paddle.class);
        mockArkanoid = mock(Arkanoid.class);
        mockGUI = mock(GUI.class);

        // Configurar mocks
        when(mockLevel.getBall()).thenReturn(mockBall);
        when(mockLevel.getPaddle()).thenReturn(mockPaddle);
        when(mockLevel.getGameArea()).thenReturn(new Rectangle(0, 0, 800, 600));

        ballController = new BallController(mockLevel);
    }

    @Test
    void testCollisionWithWalls() {
        // Configurar velocidade e posição da bola
        when(mockBall.getHitBox()).thenReturn(new Rectangle(100, 100, 10, 10));
        when(mockBall.getVelocity()).thenReturn(new Position(5, 5));

        // Configurar colisão com a parte superior
        when(mockLevel.collides(any(Rectangle.class))).thenReturn(COLLISIONS.UP);

        // Executar o método step
        ballController.step(mockArkanoid, GUI.ACTION.NONE, 100L);

        // Verificar que a bola reflete verticalmente
        verify(mockBall, times(1)).reflectVertical();

        // Configurar colisão com a lateral esquerda
        when(mockLevel.collides(any(Rectangle.class))).thenReturn(COLLISIONS.LEFT);

        // Executar novamente
        ballController.step(mockArkanoid, GUI.ACTION.NONE, 100L);

        // Verificar que a bola reflete horizontalmente
        verify(mockBall, times(1)).reflectHorizontal();
    }

    @Test
    void testCollisionWithPaddle() {
        // Configurar mock da bola
        when(mockBall.getHitBox()).thenReturn(new Rectangle(100, 100, 10, 10));  // Garantir que o HitBox é inicializado
        when(mockBall.getVelocity()).thenReturn(new Position(5, 5));

        // Configurar colisão com a parte do paddle
        when(mockLevel.collides(any(Rectangle.class))).thenReturn(COLLISIONS.PADDLEMIDDLELEFT);

        // Executar o método step
        ballController.step(mockArkanoid, GUI.ACTION.NONE, 100L);

        // Verificar que o ângulo da bola foi ajustado
        verify(mockBall, times(1)).setAngle135();

        // Configurar colisão com o lado direito do paddle
        when(mockLevel.collides(any(Rectangle.class))).thenReturn(COLLISIONS.PADDLERIGHT);

        // Executar novamente
        ballController.step(mockArkanoid, GUI.ACTION.NONE, 100L);

        // Verificar que o ângulo da bola foi ajustado corretamente
        verify(mockBall, times(1)).setAngleLess45();
    }

    @Test
    public void testCollisionWithBottomEdge() {
        // Mock de Ball
        Ball mockBall = mock(Ball.class);

        // Configurar velocity
        Position mockVelocity = mock(Position.class);
        when(mockVelocity.getX()).thenReturn(5); // Velocidade no eixo X
        when(mockVelocity.getY()).thenReturn(-5); // Velocidade no eixo Y
        when(mockBall.getVelocity()).thenReturn(mockVelocity);

        // Configurar o HitBox
        Rectangle ballHitBox = new Rectangle(100, 100, 10, 10); // Valores de exemplo
        when(mockBall.getHitBox()).thenReturn(ballHitBox);

        // Mock do Level
        Level mockLevel = mock(Level.class);
        when(mockLevel.getBall()).thenReturn(mockBall);
        when(mockLevel.getGameArea()).thenReturn(new Rectangle(0, 0, 500, 500));
        when(mockLevel.collides(any(Rectangle.class))).thenReturn(COLLISIONS.DOWN);

        // Configurar BallController
        BallController ballController = new BallController(mockLevel);

        // Mock do GUI.ACTION
        GUI.ACTION mockAction = mock(GUI.ACTION.class);

        // Executar o método
        ballController.step(mock(Arkanoid.class), mockAction, 0);

        // Verificar comportamento
        verify(mockBall).reflectVertical();
    }

    @Test
    void testBallMovementWithoutInitialSleep() {
        // Mocking do ballHitBox e do comportamento de getVelocity
        when(mockBall.getHitBox()).thenReturn(new Rectangle(100, 100, 10, 10)); // Inicializando corretamente
        when(mockBall.getVelocity()).thenReturn(new Position(5, 5));

        // Simulando a colisão com o nível
        when(mockLevel.collides(any(Rectangle.class))).thenReturn(COLLISIONS.PADDLEMIDDLELEFT);

        // Chama o método step para verificar o movimento da bola
        ballController.step(mockArkanoid, GUI.ACTION.NONE, 100L);

        // Verifica se a bola foi ajustada corretamente
        verify(mockBall, times(1)).setAngle135();
    }
}