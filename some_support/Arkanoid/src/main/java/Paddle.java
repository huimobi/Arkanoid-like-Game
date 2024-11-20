import com.googlecode.lanterna.graphics.TextGraphics;

public class Paddle {
    private int x, y;
    private int width = 7;

    public Paddle(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void moveLeft() {
        if (x > 0) x-=4;
    }

    public void moveRight() {
        if (x + width < ArkanoidGame.WIDTH) x+=4;
    }

    public void render(TextGraphics graphics) {
        for (int i = 0; i < width; i++) {
            graphics.setCharacter(x + i, y, '=');
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
}
