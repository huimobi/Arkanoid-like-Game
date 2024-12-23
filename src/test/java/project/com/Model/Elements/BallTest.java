package project.com.Model.Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;


import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    private Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball(new Position(0, 0));
    }

    @Test
    void testInitialState() {
        assertNotNull(ball);
        assertEquals(new Position(2, -2), ball.getVelocity());
        assertFalse(ball.isPowerUp());
    }

    @Test
    void testSetPowerUpOn() {
        ball.setPowerUpOn();
        assertTrue(ball.isPowerUp());
        assertEquals(new Position(1, -1), ball.getVelocity());
    }

    @Test
    void testSetPowerUpOff() {
        ball.setPowerUpOn(); // Ensure power-up is on first
        ball.setPowerUpOff();
        assertFalse(ball.isPowerUp());
        assertEquals(new Position(2, -2), ball.getVelocity()); // Default angle 45

        ball.setVelocity(new Position(-2, 2)); // Down left
        ball.setPowerUpOff();
        assertEquals(new Position(-2, 2), ball.getVelocity());

        ball.setVelocity(new Position(2, 2)); // Down right
        ball.setPowerUpOff();
        assertEquals(new Position(2, 2), ball.getVelocity());
    }

    @Test
    void testReflectHorizontal() {
        ball.reflectHorizontal();
        assertEquals(new Position(-2, -2), ball.getVelocity());
    }

    @Test
    void testReflectVertical() {
        ball.reflectVertical();
        assertEquals(new Position(2, 2), ball.getVelocity());
    }

    @Test
    void testSetAngles() {
        ball.setAngle45();
        assertEquals(new Position(2, -2), ball.getVelocity());

        ball.setAngle135();
        assertEquals(new Position(-2, -2), ball.getVelocity());

        ball.setAngle225();
        assertEquals(new Position(-2, 2), ball.getVelocity());

        ball.setAngle315();
        assertEquals(new Position(2, 2), ball.getVelocity());

        ball.setAngleBigger135();
        assertEquals(new Position(-3, -2), ball.getVelocity());

        ball.setAngleLess45();
        assertEquals(new Position(3, -2), ball.getVelocity());
    }
}