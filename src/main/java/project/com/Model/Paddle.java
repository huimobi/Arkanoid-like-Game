package project.com.Model;

import java.awt.*;
import java.awt.geom.Line2D;
import java.nio.file.Path;
import java.util.Vector;

public class Paddle extends Movable{
    private boolean powerUp;
    private int lives;
    private final Dimension defaultSize;
    private final int maxLives;

    public Paddle(Position position,Level level) {
        super(position,28,6,new Position(0,0),level);
        this.defaultSize=getHitBox().getSize();
        this.powerUp=false;
        this.lives=3;
        this.maxLives= lives;
    }

    public void moveLeft() {
        super.setVelocity(new Position(-10,0));
    }

    public void moveRight() {
        super.setVelocity(new Position(10,0));
    }


    public void setPowerUpOn() {
        this.powerUp = true;
        this.setWidth(42);
    }

    public void setPowerUpOff(){
        this.setSize(defaultSize);
        this.powerUp=false;
    }

    public Rectangle farLeft(){
        return new Rectangle(getPosition().getX(), getPosition().getY(),(getWidth()/4), getHeight());
    }

    public Rectangle middleLeft(){
            return new Rectangle(getPosition().getX() +(getWidth()/4), getPosition().getY(), (getWidth()/4), getHeight());
    }

    public Rectangle middleRight(){
        return new Rectangle(getPosition().getX() +2*(getWidth()/4), getPosition().getY(), (getWidth()/4), getHeight());
    }


    public Rectangle farRight(){
        return new Rectangle(getPosition().getX() +3*(getWidth()/4), getPosition().getY(), (getWidth()/4), getHeight());
    }


    public Boolean getPowerUp(){
        return powerUp;
    }

    public void decreaseLives() {
        lives--;
    }

    public void increaseLives(){
        if(lives<maxLives)lives++;
    }

    public int getLives(){
        return lives;
    }

}