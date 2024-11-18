import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Block {
    private int x, y;
    private boolean destroyed = false;
    private static final int width = 6;  // Fixed width for blocks

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void destroy() {
        destroyed = true;
    }

    public void render(TextGraphics graphics) {
        if (!destroyed) {
            for (int i = 0; i < width; i++) {
                graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
                graphics.setCharacter(x + i, y, ' ');

            }
        }
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
}
