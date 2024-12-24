package project.com.Control.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Arkanoid;
import project.com.Model.*;
import project.com.Model.Elements.Paddle;
import project.com.Model.Elements.PowerUp;
import project.com.Model.Levels.Level;
import project.com.gui.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PowerUpControllerTest {
    private PowerUpController powerUpController;
    private Level mockLevel;
    private Arkanoid mockArkanoid;

    @BeforeEach
    void setUp() {
        mockLevel = mock(Level.class);
        mockArkanoid = mock(Arkanoid.class);
        powerUpController = new PowerUpController(mockLevel);
    }

    @Test
    void step_ShouldActivatePowerUpOnPaddleCollision() {
        PowerUp powerUp = mock(PowerUp.class);
        Paddle mockPaddle = mock(Paddle.class);
        ArrayList<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(powerUp);
        when(powerUp.getHitBox()).thenReturn(new Rectangle(50, 50, 10, 10));
        when(powerUp.getVelocity()).thenReturn(new Position(0, 1));
        when(powerUp.getPowerUp()).thenReturn(PowerUp.Bonus.extraPaddle);
        when(mockPaddle.getHitBox()).thenReturn(new Rectangle(50, 51, 10, 10));

        when(mockLevel.getPowerUps()).thenReturn(powerUps);
        when(mockLevel.getPaddle()).thenReturn(mockPaddle);

        powerUpController.step(mockArkanoid, GUI.ACTION.NONE, 1);

        assertFalse(powerUps.contains(powerUp));
        verify(mockLevel).setPowerUpsOff();
        verify(mockLevel).setCurPowerUp(PowerUp.Bonus.extraPaddle);
    }
    @Test
    void step_ShouldApplyExtraPaddlePowerUp() {
        PowerUp powerUp = mock(PowerUp.class);
        Paddle mockPaddle = mock(Paddle.class);
        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(powerUp);

        when(powerUp.getHitBox()).thenReturn(new Rectangle(50, 50, 10, 10));
        when(powerUp.getVelocity()).thenReturn(new Position(0, 1));
        when(powerUp.getPowerUp()).thenReturn(PowerUp.Bonus.extraPaddle);
        when(mockPaddle.getHitBox()).thenReturn(new Rectangle(50, 51, 10, 10));

        when(mockLevel.getPowerUps()).thenReturn((ArrayList<PowerUp>) powerUps);
        when(mockLevel.getPaddle()).thenReturn(mockPaddle);

        powerUpController.step(mockArkanoid, GUI.ACTION.NONE, 1);

        assertFalse(powerUps.contains(powerUp));
        verify(mockPaddle).increaseLives();
    }

    @Test
    void step_ShouldApplyPaddleSizeUpPowerUp() {
        PowerUp powerUp = mock(PowerUp.class);
        Paddle mockPaddle = mock(Paddle.class);
        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(powerUp);

        when(powerUp.getHitBox()).thenReturn(new Rectangle(50, 50, 10, 10));
        when(powerUp.getVelocity()).thenReturn(new Position(0, 1));
        when(powerUp.getPowerUp()).thenReturn(PowerUp.Bonus.PaddleSizeUp);
        when(mockPaddle.getHitBox()).thenReturn(new Rectangle(50, 51, 10, 10)); // Colisão

        when(mockLevel.getPowerUps()).thenReturn((ArrayList<PowerUp>) powerUps);
        when(mockLevel.getPaddle()).thenReturn(mockPaddle);

        powerUpController.step(mockArkanoid, GUI.ACTION.NONE, 1);

        assertFalse(powerUps.contains(powerUp));
        verify(mockPaddle).setPowerUpOn();
    }
}