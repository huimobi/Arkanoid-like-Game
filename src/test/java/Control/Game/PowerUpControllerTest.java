package project.com.Control.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import project.com.Arkanoid;
import project.com.Model.*;
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
        // Arrange
        PowerUp powerUp = mock(PowerUp.class);
        Paddle mockPaddle = mock(Paddle.class);
        ArrayList<PowerUp> powerUps = new ArrayList<>(); // Lista real
        powerUps.add(powerUp);
        when(powerUp.getHitBox()).thenReturn(new Rectangle(50, 50, 10, 10));
        when(powerUp.getVelocity()).thenReturn(new Position(0, 1));
        when(powerUp.getPowerUp()).thenReturn(PowerUp.Bonus.extraPaddle); // Configuração correta
        when(mockPaddle.getHitBox()).thenReturn(new Rectangle(50, 51, 10, 10)); // Colisão

        when(mockLevel.getPowerUps()).thenReturn(powerUps);
        when(mockLevel.getPaddle()).thenReturn(mockPaddle);

        // Act
        powerUpController.step(mockArkanoid, GUI.ACTION.NONE, 1);

        // Assert
        assertFalse(powerUps.contains(powerUp)); // O power-up foi removido
        verify(mockLevel).setPowerUpsOff();
        verify(mockLevel).setCurPowerUp(PowerUp.Bonus.extraPaddle);
    }
    @Test
    void step_ShouldApplyExtraPaddlePowerUp() {
        // Arrange
        PowerUp powerUp = mock(PowerUp.class);
        Paddle mockPaddle = mock(Paddle.class);
        List<PowerUp> powerUps = new ArrayList<>(); // Lista real
        powerUps.add(powerUp);

        when(powerUp.getHitBox()).thenReturn(new Rectangle(50, 50, 10, 10));
        when(powerUp.getVelocity()).thenReturn(new Position(0, 1));
        when(powerUp.getPowerUp()).thenReturn(PowerUp.Bonus.extraPaddle);
        when(mockPaddle.getHitBox()).thenReturn(new Rectangle(50, 51, 10, 10)); // Colisão

        when(mockLevel.getPowerUps()).thenReturn((ArrayList<PowerUp>) powerUps);
        when(mockLevel.getPaddle()).thenReturn(mockPaddle);

        // Act
        powerUpController.step(mockArkanoid, GUI.ACTION.NONE, 1);

        // Assert
        assertFalse(powerUps.contains(powerUp)); // O power-up foi removido
        verify(mockPaddle).increaseLives(); // Vida adicional aplicada
    }

    @Test
    void step_ShouldApplyPaddleSizeUpPowerUp() {
        // Arrange
        PowerUp powerUp = mock(PowerUp.class);
        Paddle mockPaddle = mock(Paddle.class);
        List<PowerUp> powerUps = new ArrayList<>(); // Use uma lista real
        powerUps.add(powerUp);

        when(powerUp.getHitBox()).thenReturn(new Rectangle(50, 50, 10, 10));
        when(powerUp.getVelocity()).thenReturn(new Position(0, 1));
        when(powerUp.getPowerUp()).thenReturn(PowerUp.Bonus.PaddleSizeUp);
        when(mockPaddle.getHitBox()).thenReturn(new Rectangle(50, 51, 10, 10)); // Colisão

        when(mockLevel.getPowerUps()).thenReturn((ArrayList<PowerUp>) powerUps);
        when(mockLevel.getPaddle()).thenReturn(mockPaddle);

        // Act
        powerUpController.step(mockArkanoid, GUI.ACTION.NONE, 1);

        // Assert
        assertFalse(powerUps.contains(powerUp)); // O power-up foi removido
        verify(mockPaddle).setPowerUpOn(); // Paddle aumentado
    }
}