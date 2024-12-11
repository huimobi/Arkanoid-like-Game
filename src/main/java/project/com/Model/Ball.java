package project.com.Model;

public class Ball extends Movable{
    private int LENGTH=5;
    Ball(Position position){
        super(position);
        super.setSize(LENGTH, LENGTH);
    }
}
