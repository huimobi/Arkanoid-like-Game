package project.com.Model;

public class Wall extends Static{
    private static final int HEIGHT=7;
    private static final int WIDTH=15;

    public Wall(Position position) {
        super(position);
        super.setSize(WIDTH, HEIGHT);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
    }

}
