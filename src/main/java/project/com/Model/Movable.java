package project.com.Model;

import java.io.PipedOutputStream;
import java.util.Vector;

public abstract class Movable extends Element{
    private Level level;
    private Position velocity;

    Movable(Position position,int width,int height,Position velocity,Level level){
        super(position,width,height);
        this.velocity=velocity;
        this.level=level;
    }

    public void move(){
        setPosition(new Position(getPosition().getX()+getVelocity().getX(), getPosition().getY()+getVelocity().getY()));
    }

    public Position getVelocity() {
        return velocity;
    }

    public void setVelocity(Position velocity) {
        this.velocity = velocity;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean isMovingUpLeft(){
        if(velocity.getX()<0 & velocity.getY()<0 &velocity.getY()!=velocity.getX()){
            return true;
        }
        return false;
    }

    public boolean isMovingDownLeft(){
        if(velocity.getX()<0 & velocity.getY()>0 &velocity.getY()!=velocity.getX()){
            return true;
        }
        return false;
    }

    public boolean isMovingUpRight(){
        if(velocity.getX()>0 & velocity.getY()<0 &velocity.getY()!=velocity.getX()){
            return true;
        }
        return false;
    }

    public boolean isMovingDownRight(){
        if(velocity.getX()>0 & velocity.getY()>0 &velocity.getY()!=velocity.getX()){
            return true;
        }
        return false;
    }
}