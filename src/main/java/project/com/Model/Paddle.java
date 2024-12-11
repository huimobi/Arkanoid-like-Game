package project.com.Model;

import java.awt.*;
import java.nio.file.Path;

public class Paddle extends Movable{
    private final boolean powerUp;
    private final int HEIGHT=28;
    private final int WIDTH=6;
    private final Rectangle hitbox;
    Paddle(Position position) {
        super(position);
        this.powerUp=false;
        hitbox= new Rectangle(getPosition().getX(), getPosition().getY(), HEIGHT, WIDTH);
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