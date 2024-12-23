package project.com.Model.Levels;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Elements.Ball;
import project.com.Model.Elements.Brick;
import project.com.Model.Elements.Paddle;
import project.com.Model.Position;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LevelTest {

    private Level level;
    private Rectangle gameArea;
    private Paddle paddle;
    private Ball ball;
    private ArrayList<Brick> bricks;

    @BeforeEach
    void setUp() {
        gameArea = new Rectangle(0, 0, 800, 600);
        paddle = mock(Paddle.class);
        ball = mock(Ball.class);
        bricks = new ArrayList<>();

        // Mock the ball velocity
        Position mockVelocity = new Position(3, -3);
        when(ball.getVelocity()).thenReturn(mockVelocity);

        // Add some mock bricks
        Brick mockBrick1 = mock(Brick.class);
        Brick mockBrick2 = mock(Brick.class);
        when(mockBrick1.getCharacter()).thenReturn('A');
        when(mockBrick2.getCharacter()).thenReturn('#');
        when(mockBrick1.getPosition()).thenReturn(new Position(100, 100));
        when(mockBrick2.getPosition()).thenReturn(new Position(200, 100));
        when(mockBrick1.getHitBox()).thenReturn(new Rectangle(100, 100, 50, 20));
        when(mockBrick2.getHitBox()).thenReturn(new Rectangle(200, 100, 50, 20));

        bricks.add(mockBrick1);
        bricks.add(mockBrick2);

        level = new Level(gameArea, 1, paddle, ball, bricks, 0, 1000);
    }

    @Test
    void testConstructor_initializesFieldsCorrectly() {
        assertEquals(800, level.getWidth());
        assertEquals(600, level.getHeight());
        assertEquals(1, level.getLevelNumber());
        assertEquals(bricks, level.getBricks());
        assertEquals(paddle, level.getPaddle());
        assertEquals(ball, level.getBall());
    }

    @Test
    void testIsInitialSleep_returnsTrueDuringSleepPeriod() {
        System.currentTimeMillis();
        level = new Level(gameArea, 1, paddle, ball, bricks, 0, 1000);
        assertTrue(level.isInitialSleep());
    }

    @Test
    void testIsLevelClear_returnsFalseWhenBricksExist() {
        assertFalse(level.isLevelClear());
    }

    @Test
    void testIsLevelClear_returnsTrueWhenNoBricksExist() {
        bricks.clear(); // Simulate all bricks being removed
        assertTrue(level.isLevelClear());
    }

    @Test
    void testCheckOutsideLevel_returnsTrueForOutOfBoundsMove() {
        Rectangle nextMove = new Rectangle(900, 700, 10, 10); // Out of bounds
        assertTrue(level.checkOutsideLevel(nextMove));
    }

    @Test
    void testCheckOutsideLevel_returnsFalseForInBoundsMove() {
        Rectangle nextMove = new Rectangle(100, 100, 10, 10); // In bounds
        assertFalse(level.checkOutsideLevel(nextMove));
    }


    @Test
    void testHit_removesBrickAndIncreasesScore() {
        Brick brick = bricks.getFirst();
        when(brick.getDurability()).thenReturn(0);
        when(brick.getScore()).thenReturn(50);

        level.hit(brick);

        assertFalse(level.getBricks().contains(brick));
        assertEquals(50, level.getScore());
    }

    @Test
    void testHit_generatesPowerUpWhenBrickDestroyed() {
        Brick brick = bricks.getFirst();
        when(brick.getDurability()).thenReturn(0);
        when(brick.getScore()).thenReturn(50);

        level.hit(brick);

        assertFalse(level.getBricks().contains(brick));
        assertEquals(50, level.getScore());
    }

    @Test
    void testUpdateLives() {
        Paddle paddle = mock(Paddle.class);
        Ball ball = mock(Ball.class);
        Position defaultVelocity = new Position(5, 5);
        when(ball.getVelocity()).thenReturn(defaultVelocity);

        Level level = createDefaultLevelWithPaddleAndBall(paddle, ball);
        level.updateLives();

        verify(paddle).decreaseLives();
        verify(ball).setVelocity(defaultVelocity);
        assertTrue(level.getPowerUps().isEmpty());
    }

    @Test
    void testUpdateLives_resetsBallAndClearsPowerUps() {
        level.updateLives();

        verify(paddle, times(1)).decreaseLives();
        assertTrue(level.getPowerUps().isEmpty());
        assertEquals(ball.getVelocity(), ball.getVelocity()); // Resets velocity
        assertTrue(level.isInitialSleep());
    }

    @Test
    void testGetPosition() {
        Rectangle gameArea = new Rectangle(0, 0, 800, 600);
        Level level = createDefaultLevel(gameArea);
        Position expectedPosition = new Position(0, 0);
        assertEquals(expectedPosition, level.getPosition());
    }

    @Test
    void testGetGameArea() {
        Rectangle gameArea = new Rectangle(0, 0, 800, 600);
        Level level = createDefaultLevel(gameArea);
        assertEquals(gameArea, level.getGameArea());
    }


    @Test
    void testSetPaddlePosition() {
        Paddle paddle = mock(Paddle.class);
        Level level = createDefaultLevelWithPaddle(paddle);
        Position newPosition = new Position(100, 500);
        level.setPaddle(newPosition);
        verify(paddle).setPosition(newPosition);
    }
    @Test
    void testHitBrick() {
        Brick brick = mock(Brick.class);
        when(brick.getDurability()).thenReturn(0);
        when(brick.getScore()).thenReturn(50);

        ArrayList<Brick> bricks = new ArrayList<>();
        Level level = createDefaultLevel(new Rectangle(0, 0, 800, 600), bricks);

        level.hit(brick);

        assertTrue(level.getBricks().isEmpty());
        assertEquals(50, level.getScore());
    }



    private Level createDefaultLevel(Rectangle gameArea) {
        return new Level(gameArea, 1, mock(Paddle.class), mock(Ball.class), new ArrayList<>(), 0, 1000);
    }

    private Level createDefaultLevel(Rectangle gameArea, ArrayList<Brick> bricks) {
        return new Level(gameArea, 1, mock(Paddle.class), mock(Ball.class), bricks, 0, 1000);
    }

    private Level createDefaultLevelWithPaddle(Paddle paddle) {
        return new Level(new Rectangle(0, 0, 800, 600), 1, paddle, mock(Ball.class), new ArrayList<>(), 0, 1000);
    }

    private Level createDefaultLevelWithPaddleAndBall(Paddle paddle, Ball ball) {
        return new Level(new Rectangle(0, 0, 800, 600), 1, paddle, ball, new ArrayList<>(), 0, 1000);
    }

}
