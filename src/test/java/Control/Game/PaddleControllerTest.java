package project.com.Control.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Arkanoid;
import project.com.Control.Game.PaddleController;
import project.com.Model.*;
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

        // Criação de um objeto Ball
        Ball ball = new Ball(new Position(100, 100)); // Cria a bola com uma posição inicial
        ArrayList<Brick> bricks = new ArrayList<>(); // Cria uma lista vazia de tijolos

        // Ajuste os parâmetros conforme necessário
        level = new Level(new Rectangle(0, 0, 800, 600), 0, paddle, ball, bricks, 0, 0);
        paddleController = new PaddleController(level);
    }

    @Test
    void testMoveLeft() throws Exception {
        paddleController.step(new Arkanoid(), GUI.ACTION.LEFT, 0);
        assertEquals(40, paddle.getHitBox().x); // Verifica se a posição do paddle foi atualizada
    }

    @Test
    void testMoveRight() throws Exception {
        paddleController.step(new Arkanoid(), GUI.ACTION.RIGHT, 0);
        assertEquals(60, paddle.getHitBox().x); // Verifica se a posição do paddle foi atualizada
    }

    @Test
    void testMoveLeftOutsideLevel() throws Exception {
        paddle.setPosition(new Position(0, 100)); // Coloca o paddle na borda esquerda
        paddleController.step(new Arkanoid(), GUI.ACTION.LEFT, 0);
        assertEquals(0, paddle.getHitBox().x); // Verifica se a posição não saiu da borda
    }

    @Test
    void testMoveRightOutsideLevel() throws Exception {
        paddle.setPosition(new Position(700, 100)); // Coloca o paddle perto da borda direita
        paddleController.step(new Arkanoid(), GUI.ACTION.RIGHT, 0);
        assertEquals(710, paddle.getHitBox().x); // Verifica se a posição não saiu da borda
    }

    @Test
    void testPowerUpOn() {
        paddle.setPowerUpOn();
        assertTrue(paddle.getPowerUp()); // Verifica se o power-up está ativado
        assertEquals(42, paddle.getWidth()); // Verifica se a largura do paddle foi aumentada
    }

    @Test
    void testPowerUpOff() {
        paddle.setPowerUpOn(); // Ativa o power-up
        paddle.setPowerUpOff(); // Desativa o power-up
        assertFalse(paddle.getPowerUp()); // Verifica se o power-up está desativado
        assertEquals(28, paddle.getWidth()); // Verifica se a largura do paddle voltou ao normal
    }

    @Test
    void testDecreaseLives() {
        paddle.decreaseLives();
        assertEquals(2, paddle.getLives()); // Verifica se as vidas foram diminuídas
    }

    @Test
    void testIncreaseLives() {
        paddle.decreaseLives(); // Decrementa uma vida
        paddle.increaseLives(); // Incrementa uma vida
        assertEquals(3, paddle.getLives()); // Verifica se as vidas voltaram ao máximo
    }

    @Test
    void testMaxLives() {
        paddle.decreaseLives(); // Decrementa uma vida
        paddle.decreaseLives(); // Decrementa outra vida
        paddle.decreaseLives(); // Decrementa mais uma vida
        assertEquals(0, paddle.getLives()); // Verifica se as vidas estão em 0
        paddle.increaseLives(); // Tenta aumentar vidas
        assertEquals(1, paddle.getLives()); // Verifica se a vida aumentou para 1
    }
}