package project.com.Model;

import java.awt.*;
import java.nio.file.Path;
import java.util.Vector;

public class Paddle extends Movable{
    private boolean powerUp;
    private int lives;

    public Paddle(Position position,Level level) {
        super(position,28,6,new Position(0,0),level);
        this.powerUp=false;
        this.lives=3;
    }

    public void moveLeft() {
        super.setVelocity(new Position(-5,0));
    }

    public void moveRight() {
        super.setVelocity(new Position(5,0));
    }


    public void setPowerUp(boolean powerUp) {
        this.powerUp = powerUp;
    }


    public Boolean getPowerUp(){
        return powerUp;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

}