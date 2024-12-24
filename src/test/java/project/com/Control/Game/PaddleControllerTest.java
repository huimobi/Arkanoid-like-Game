package project.com.Control.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Arkanoid;
import project.com.Model.*;
import project.com.Model.Elements.Ball;
import project.com.Model.Elements.Brick;
import project.com.Model.Elements.Paddle;
import project.com.Model.Levels.Level;
import project.com.gui.GUI;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PaddleControllerTest {
    private Paddle paddle;
    private Level level;
    private PaddleController paddleController;

    @BeforeEach
    void setUp() {
        paddle = new Paddle(new Position(50, 100));

        Ball ball = new Ball(new Position(100, 100));
        ArrayList<Brick> bricks = new ArrayList<>();

        level = new Level(new Rectangle(0, 0, 800, 600), 0, paddle, ball, bricks, 0, 0);
        paddleController = new PaddleController(level);
    }

    @Test
    void testMoveLeft() throws Exception {
        paddleController.step(new Arkanoid(), GUI.ACTION.LEFT, 0);
        assertEquals(40, paddle.getHitBox().x);
    }

    @Test
    void testMoveRight() throws Exception {
        paddleController.step(new Arkanoid(), GUI.ACTION.RIGHT, 0);
        assertEquals(60, paddle.getHitBox().x);
    }

    @Test
    void testMoveLeftOutsideLevel() throws Exception {
        paddle.setPosition(new Position(0, 100));
        paddleController.step(new Arkanoid(), GUI.ACTION.LEFT, 0);
        assertEquals(0, paddle.getHitBox().x);
    }

    @Test
    void testMoveRightOutsideLevel() throws Exception {
        paddle.setPosition(new Position(700, 100));
        paddleController.step(new Arkanoid(), GUI.ACTION.RIGHT, 0);
        assertEquals(710, paddle.getHitBox().x);
    }

    @Test
    void testPowerUpOn() {
        paddle.setPowerUpOn();
        assertTrue(paddle.getPowerUp());
        assertEquals(42, paddle.getWidth());
    }

    @Test
    void testPowerUpOff() {
        paddle.setPowerUpOn();
        paddle.setPowerUpOff();
        assertFalse(paddle.getPowerUp());
        assertEquals(28, paddle.getWidth());
    }

    @Test
    void testDecreaseLives() {
        paddle.decreaseLives();
        assertEquals(2, paddle.getLives());
    }

    @Test
    void testIncreaseLives() {
        paddle.decreaseLives();
        paddle.increaseLives();
        assertEquals(3, paddle.getLives());
    }

    @Test
    void testMaxLives() {
        paddle.decreaseLives();
        paddle.decreaseLives();
        paddle.decreaseLives();
        assertEquals(0, paddle.getLives());
        paddle.increaseLives();
        assertEquals(1, paddle.getLives());
    }
}