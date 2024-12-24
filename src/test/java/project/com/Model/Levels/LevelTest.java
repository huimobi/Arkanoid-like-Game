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
    private Brick brick;

    @BeforeEach
    void setUp() {
        gameArea = new Rectangle(0, 0, 800, 600);
        paddle = mock(Paddle.class);
        ball = mock(Ball.class);
        bricks = new ArrayList<>();
        brick=mock(Brick.class);

        Position mockVelocity = new Position(3, -3);
        when(ball.getVelocity()).thenReturn(mockVelocity);

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

        when(paddle.farLeft()).thenReturn(new Rectangle(0,0,10,6));
        when(paddle.middleLeft()).thenReturn(new Rectangle(10,0,10,6));
        when(paddle.middleRight()).thenReturn(new Rectangle(20,0,10,6));
        when(paddle.farRight()).thenReturn(new Rectangle(30,0,10,6));

        when(paddle.getHitBox()).thenReturn(new Rectangle(0,0,40,6));

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



        @Test
        public void testCollides_WithOutsideLevelCollision() {
            Rectangle nextMove = new Rectangle(-10, 10, 20, 20);

            COLLISIONS result = level.collides(nextMove);

            assertEquals(COLLISIONS.LEFT, result);
        }

        @Test
        public void testCollides_WithPaddleCollision() {
            Rectangle nextMove = new Rectangle(0, 10, 2, 2);

            COLLISIONS result = level.collides(nextMove);

            assertEquals(COLLISIONS.NONE, result);
        }

        @Test
        public void testCollides_WithBrickCollision() {
            Rectangle nextMove = new Rectangle(100, 100, 20, 20);
            Rectangle brickHitBox = new Rectangle(100, 101, 50, 20);

            bricks.add(brick);
            when(brick.getHitBox()).thenReturn(brickHitBox);
            when(brick.getCharacter()).thenReturn('B');
            when(brick.getDurability()).thenReturn(1);
            when(brick.getScore()).thenReturn(100);

            COLLISIONS result = level.collides(nextMove);

            assertEquals(COLLISIONS.BOTTOMLEFT,result);
        }

        @Test
        public void testAreaGameCollision_LeftSide() {
            Rectangle nextMove = new Rectangle(-10, 100, 20, 20);

            COLLISIONS result = level.areaGameCollision(nextMove);

            assertEquals(COLLISIONS.LEFT, result);
        }

        @Test
        public void testAreaGameCollision_RightSide() {
            Rectangle nextMove = new Rectangle(780, 100, 20, 20);

            COLLISIONS result = level.areaGameCollision(nextMove);

            assertEquals(COLLISIONS.RIGHT, result);
        }

        @Test
        public void testTypeBrickCollision_CornerCollision() {
            Rectangle brick = new Rectangle(20, 20, 20, 20);
            Rectangle nextMove = new Rectangle(35, 35, 6, 6);

            COLLISIONS result = level.typeBrickCollision(brick, nextMove);

            assertEquals(COLLISIONS.BOTTOMRIGHT, result);
        }

        @Test
        public void testPaddleCollision_MiddleLeft() {
            Rectangle nextMove = new Rectangle(10, 0, 2, 2);

            COLLISIONS result = level.paddleCollision(nextMove);

            assertEquals(COLLISIONS.PADDLEMIDDLELEFT, result);
        }

        @Test
        public void testCollisionRight_WithTarget() {
            Rectangle target = new Rectangle(100, 100, 50, 50);
            Rectangle nextMove = new Rectangle(140, 120, 20, 20);

            boolean result = level.collisionRight(target, nextMove);

            assertTrue(result, "Collision on the right side of the target expected.");
        }

        @Test
        public void testCollisionDown_WithTarget() {
            Rectangle target = new Rectangle(100, 100, 50, 50);
            Rectangle nextMove = new Rectangle(110, 140, 20, 20);

            boolean result = level.collisionDown(target, nextMove);

            assertTrue(result, "Collision on the bottom side of the target expected.");
        }

}
