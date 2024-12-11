package project.com.Model;

import java.io.PipedOutputStream;
import java.util.Vector;

public abstract class Movable extends Element{
    // Track all positions
    Position velocity;
    private Vector<Position> positions;
    Movable(Position position){
        super(position);
        this.positions = new Vector<>();
    };

    public void move(int deltaX, int deltaY){
        Position currentPosition = getPosition();
        setPosition(new Position(currentPosition.getX()+deltaX, currentPosition.getY()+deltaY));
    }

    public Position getVelocity() {
        return velocity;
    }

    public void setVelocity(Position velocity) {
        this.velocity = velocity;
    }

    public Vector<Position> getPositions(){
        return positions;
    }
}