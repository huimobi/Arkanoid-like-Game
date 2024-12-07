package project.com.Model;

public class Bricks extends Static{

    public static final int BRICK_HEIGHT = 5;
    public static final int BRICK_WIDTH = 15;
    private final char character;
    public Bricks(Position position,char character) {
        super(position);
        this.character=character;
        setSize(BRICK_HEIGHT, BRICK_WIDTH);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
    }

    public char getCharacter() {
        return character;
    }
}
