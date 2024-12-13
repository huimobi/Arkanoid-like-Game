package project.com.Model;

import java.io.PipedOutputStream;
import java.util.Vector;

public abstract class Movable extends Element{
    private Level level;
    private Position velocity;

    Movable(Position position,Position velocity,Level level){
        super(position);
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
}