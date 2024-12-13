package project.com.Model;

import java.io.PipedOutputStream;
import java.util.Vector;

public abstract class Movable extends Element{

    private Position velocity;
    Movable(Position position,Position velocity){
        super(position);
        this.velocity=velocity;
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

}