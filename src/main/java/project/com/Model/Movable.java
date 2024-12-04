package project.com.Model;

import java.util.Vector;

public abstract class Movable extends Element{
    private Vector<Position> positions;
    Movable(Position position){
        super(position);
        this.positions=new Vector<>();
    };
    public void addPosition(Position position){
        this.positions.add(position);
    }
    public Vector<Position> getPositions(){
        return positions;
    }
}
