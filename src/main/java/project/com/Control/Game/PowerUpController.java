package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.Levels.Level;
import project.com.Model.Elements.PowerUp;
import project.com.gui.GUI;

import java.awt.*;
import java.util.ArrayList;

public class PowerUpController extends Controller<Level> {
    public PowerUpController(Level level){
        super(level);
    }

    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action, long frameCount) {
        if (getModel().getPowerUps().isEmpty()) return;

        ArrayList<PowerUp> removePowerUps = new ArrayList<>();
        for (PowerUp powerUp : getModel().getPowerUps()) {
            if (powerUp == null || powerUp.getHitBox() == null || powerUp.getVelocity() == null) {
                continue;
            }

            Rectangle nextMove = new Rectangle(
                    powerUp.getHitBox().x + powerUp.getVelocity().getX(),
                    powerUp.getHitBox().y + powerUp.getVelocity().getY(),
                    powerUp.getHitBox().width, powerUp.getHitBox().height
            );

            if (getModel().getPaddle() == null || getModel().getPaddle().getHitBox() == null) {
                throw new IllegalStateException("Paddle or its hitbox is not initialized");
            }

            if (getModel().checkOutsideLevel(nextMove)) {
                removePowerUps.add(powerUp);
                continue;
            }

            if (nextMove.intersects(getModel().getPaddle().getHitBox())) {
                getModel().setPowerUpsOff();

                if (powerUp.getPowerUp() != null) {
                    getModel().setCurPowerUp(powerUp.getPowerUp());
                    switch (powerUp.getPowerUp()) {
                        case extraPaddle -> getModel().getPaddle().increaseLives();
                        case PaddleSizeUp -> getModel().getPaddle().setPowerUpOn();
                        case slowBall -> getModel().getBall().setPowerUpOn();
                    }
                }

                removePowerUps.add(powerUp);
            } else {
                powerUp.move();
            }
        }
        getModel().getPowerUps().removeAll(removePowerUps);
    }
}
