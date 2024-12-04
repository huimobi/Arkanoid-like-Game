package project.com.Model;

public class Ball extends Movable{
    private static final int LENGTH=5;
    public Ball(Position position){
        super(position);
        super.setSize(LENGTH, LENGTH);
    }
}
