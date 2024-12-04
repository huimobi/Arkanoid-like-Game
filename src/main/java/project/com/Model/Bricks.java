package project.com.Model;

public class Bricks extends Static{

    public static final int BRICK_HEIGHT = 5;
    public static final int BRICK_WIDTH = 15;

    public Bricks(Position position) {
        super(position);
        setSize(BRICK_HEIGHT, BRICK_WIDTH);
    }
}
