package project.com.Control.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.com.Arkanoid;
import project.com.Model.*;
import project.com.Model.Elements.Ball;
import project.com.Model.Elements.Paddle;
import project.com.Model.Levels.COLLISIONS;
import project.com.Model.Levels.Level;
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
        mockLevel = mock(Level.class);
        mockBall = mock(Ball.class);
        mockPaddle = mock(Paddle.class);
        mockArkanoid = mock(Arkanoid.class);
        mockGUI = mock(GUI.class);

        when(mockLevel.getBall()).thenReturn(mockBall);
        when(mockLevel.getPaddle()).thenReturn(mockPaddle);
        when(mockLevel.getGameArea()).thenReturn(new Rectangle(0, 0, 800, 600));

        ballController = new BallController(mockLevel);
    }

    @Test
    void testCollisionWithWalls() {
        when(mockBall.getHitBox()).thenReturn(new Rectangle(100, 100, 10, 10));
        when(mockBall.getVelocity()).thenReturn(new Position(5, 5));

        when(mockLevel.collides(any(Rectangle.class))).thenReturn(COLLISIONS.UP);

        ballController.step(mockArkanoid, GUI.ACTION.NONE, 100L);

        verify(mockBall, times(1)).reflectVertical();

        when(mockLevel.collides(any(Rectangle.class))).thenReturn(COLLISIONS.LEFT);

        ballController.step(mockArkanoid, GUI.ACTION.NONE, 100L);

        verify(mockBall, times(1)).reflectHorizontal();
    }

    @Test
    void testCollisionWithPaddle() {
        when(mockBall.getHitBox()).thenReturn(new Rectangle(100, 100, 10, 10));
        when(mockBall.getVelocity()).thenReturn(new Position(5, 5));

        when(mockLevel.collides(any(Rectangle.class))).thenReturn(COLLISIONS.PADDLEMIDDLELEFT);

        ballController.step(mockArkanoid, GUI.ACTION.NONE, 100L);

        verify(mockBall, times(1)).setAngle135();

        when(mockLevel.collides(any(Rectangle.class))).thenReturn(COLLISIONS.PADDLERIGHT);

        ballController.step(mockArkanoid, GUI.ACTION.NONE, 100L);

        verify(mockBall, times(1)).setAngleLess45();
    }

    @Test
    void testBallMovementWithoutInitialSleep() {
        when(mockBall.getHitBox()).thenReturn(new Rectangle(100, 100, 10, 10));
        when(mockBall.getVelocity()).thenReturn(new Position(5, 5));

        when(mockLevel.collides(any(Rectangle.class))).thenReturn(COLLISIONS.PADDLEMIDDLELEFT);

        ballController.step(mockArkanoid, GUI.ACTION.NONE, 100L);

        verify(mockBall, times(1)).setAngle135();
    }
}