package project.com.Control.Game;

import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Model.Level;
import project.com.Model.PowerUp;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class PowerUpController extends Controller<Level> {
    public PowerUpController(Level level){
        super(level);
    }
    @Override
    public void step(Arkanoid arkanoid, GUI.ACTION action, long frameCount) throws IOException, URISyntaxException, FontFormatException {
        if(getModel().getPowerUps().isEmpty())return;

        ArrayList<PowerUp> removePowerUps= new ArrayList<>();
        for(PowerUp powerUp: getModel().getPowerUps()){
            Rectangle nextMove=new Rectangle(powerUp.getHitBox().x + powerUp.getVelocity().getX(), powerUp.getHitBox().y + powerUp.getVelocity().getY(), powerUp.getHitBox().width, powerUp.getHitBox().height);
            if(getModel().checkOutsideLevel(nextMove)){
                removePowerUps.add(powerUp);
            }
            if(nextMove.intersects(getModel().getPaddle().getHitBox())){
                getModel().setCurPowerUp(powerUp.getPowerUp());
                removePowerUps.add(powerUp);
            }else{
            powerUp.move();}
        }
        getModel().getPowerUps().removeAll(removePowerUps);
    }
}
