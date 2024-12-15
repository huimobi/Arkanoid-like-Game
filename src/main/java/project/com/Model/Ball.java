package project.com.Model;

import java.awt.*;

public class Ball extends Movable {
    private boolean powerUp;

    public Ball(Position position) {
        super(position, 5, 5, new Position(2, -2));
        this.powerUp=true;
    }

    public void setPowerUpOn(){
        setVelocity(new Position(getVelocity().getX() /2, getVelocity().getY() /2));
        this.powerUp= true;
    }

    public void setPowerUpOff(){
        if(powerUp) setVelocity(new Position(getVelocity().getX() *2, getVelocity().getY() *2));
        this.powerUp=false;
    }
    public void reflectHorizontal() {
        setVelocity(new Position(-getVelocity().getX(), getVelocity().getY()));
    }

    public void reflectVertical() {
        setVelocity(new Position(getVelocity().getX(), -getVelocity().getY()));
    }

    public void setAngle45(){
        setVelocity(new Position(2,-2));
    }

    public void setAngle135(){
        setVelocity(new Position(-2,-2));
    }
    public void setAngle225(){
        setVelocity(new Position(-2,2));
    }
    public void setAngle315(){
        setVelocity(new Position(2,2));
    }

    public void setAngleBigger135(){
        setVelocity(new Position(-3,-2));
    }

    public void setAngleLess45(){
        setVelocity(new Position(3,-2));
    }


}
