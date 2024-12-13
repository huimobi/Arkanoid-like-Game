package project.com.Model;

import java.awt.*;
import java.nio.file.Path;
import java.util.Vector;

public class Paddle extends Movable{
    private boolean powerUp;
    private final int WIDTH=28;
    private final int HEIGHT=6;
    private Rectangle hitbox;
    private int lives;

    public Paddle(Position position,Level level) {
        super(position,new Position(5,0),level);
        this.powerUp=false;
        hitbox= new Rectangle(getPosition().getX(), getPosition().getY(), WIDTH, HEIGHT);
        this.lives=3;
    }

    public void moveLeft() {
        super.setVelocity(new Position(-5,0));
        hitbox.setLocation(getPosition().getX(),getPosition().getY());
    }

    public void moveRight() {
        super.setVelocity(new Position(5,0));
        hitbox.setLocation(getPosition().getX(),getPosition().getY());
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setPowerUp(boolean powerUp) {
        this.powerUp = powerUp;
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

    public Boolean getPowerUp(){
        return powerUp;
    }
    public int getWIDTH(){
        return WIDTH;
    }
    public int getHEIGHT(){
        return HEIGHT;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

}