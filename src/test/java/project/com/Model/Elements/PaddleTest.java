package project.com.Model.Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PaddleTest {

    private Paddle paddle;

    @BeforeEach
    void setUp() {
        paddle = new Paddle(new Position(50, 50));
    }

    @Test
    void testInitialState() {
        assertNotNull(paddle);
        assertEquals(new Dimension(28, 6), paddle.getHitBox().getSize());
        assertEquals(3, paddle.getLives());
        assertFalse(paddle.getPowerUp());
        assertEquals(new Position(0, 0), paddle.getVelocity());
    }

    @Test
    void testMoveLeft() {
        paddle.moveLeft();
        assertEquals(new Position(-10, 0), paddle.getVelocity());
    }

    @Test
    void testMoveRight() {
        paddle.moveRight();
        assertEquals(new Position(10, 0), paddle.getVelocity());
    }

    @Test
    void testSetPowerUpOn() {
        paddle.setPowerUpOn();
        assertTrue(paddle.getPowerUp());
        assertEquals(42, paddle.getWidth());
    }

    @Test
    void testSetPowerUpOff() {
        paddle.setPowerUpOn();
        paddle.setPowerUpOff();
        assertFalse(paddle.getPowerUp());
        assertEquals(new Dimension(28, 6), paddle.getHitBox().getSize());
    }

    @Test
    void testHitBoxSections() {
        Rectangle farLeft = paddle.farLeft();
        assertEquals(new Rectangle(50, 50, 7, 6), farLeft);

        Rectangle middleLeft = paddle.middleLeft();
        assertEquals(new Rectangle(57, 50, 7, 6), middleLeft);

        Rectangle middleRight = paddle.middleRight();
        assertEquals(new Rectangle(64, 50, 7, 6), middleRight);

        Rectangle farRight = paddle.farRight();
        assertEquals(new Rectangle(71, 50, 7, 6), farRight);
    }

    @Test
    void testLives() {
        assertEquals(3, paddle.getLives());

        paddle.decreaseLives();
        assertEquals(2, paddle.getLives());

        paddle.increaseLives();
        assertEquals(3, paddle.getLives());

        paddle.increaseLives();
        assertEquals(3, paddle.getLives());
    }
}