package project.com.Model.Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.com.Model.Position;

import static org.junit.jupiter.api.Assertions.*;

class PowerUpTest {

    private PowerUp powerUp;

    @BeforeEach
    void setUp() {
        Position mockPosition = Mockito.mock(Position.class);
        Mockito.when(mockPosition.getX()).thenReturn(50);
        Mockito.when(mockPosition.getY()).thenReturn(100);
        powerUp = new PowerUp(mockPosition);
    }

    @Test
    void testConstructor_initializesCorrectly() {
        assertEquals(50, powerUp.getPosition().getX());
        assertEquals(100, powerUp.getPosition().getY());
        assertEquals(13, powerUp.getWidth());
        assertEquals(6, powerUp.getHeight());
        assertEquals(0, powerUp.getVelocity().getX());
        assertEquals(1, powerUp.getVelocity().getY());
    }

    @Test
    void testMove_updatesPositionCorrectly() {
        powerUp.move();

        assertEquals(50, powerUp.getPosition().getX());
        assertEquals(101, powerUp.getPosition().getY());
    }

    @Test
    void testGetPowerUp_returnsValidBonus() {
        PowerUp.Bonus result = powerUp.getPowerUp();
        assertNotNull(result);
    }
}
