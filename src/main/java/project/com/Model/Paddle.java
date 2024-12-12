package project.com.Model;

import java.awt.*;
import java.nio.file.Path;
import java.util.Vector;

public class Paddle extends Movable{
    private final boolean powerUp;
    private final int HEIGHT=28;
    private final int WIDTH=6;
    private final Rectangle hitbox;
    private Position position;
    Paddle(Position position) {
        super(position);
        this.powerUp=false;
        this.position=position;
        hitbox= new Rectangle(getPosition().getX(), getPosition().getY(), HEIGHT, WIDTH);
    }

    public void moveLeft() {
        if (position.getX() > 5) {
            position.setX(position.getX() - 5);
        }
    }

    public void moveRight(int screenWidth) {
        if (position.getX() + WIDTH < screenWidth) {
            position.setX(position.getX() + 5);
        }
    }

    //Velocity is an incrementation of the position, so its type is Position
    public Position updatePosition(Position velocity) {
        return new Position(getPosition().getX() + velocity.getX(), getPosition().getY() + velocity.getY());
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

    public Boolean getpowerUp(){
        return powerUp;
    }
    public int getWIDTH(){
        return WIDTH;
    }
    public int getHEIGHT(){
        return HEIGHT;
    }

}