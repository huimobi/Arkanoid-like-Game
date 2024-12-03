package project.com.Model;

import java.io.PipedOutputStream;
import java.util.Vector;

public abstract class Movable extends Element{
    private Vector<Position> positions;
    private Position position;
    Movable(Position position){
        super(position);
    };
}
