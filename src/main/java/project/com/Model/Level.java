package project.com.Model;

import java.awt.*;

public class Level{
    private final int width;
    private final int height;
    private int levelNumber;
    private Brick[][] bricks;
    private boolean levelClear;

public Level(int width, int height, int levelNumber) {
    this.width = width;
    this.height = height;
    this.levelNumber = levelNumber;
    this.bricks = new Brick[height][width];
    this.levelClear =false;
}

public int getWidth() {
    return width;
}

public int getHeight() {
    return height;
}


/*private boolean checkOutsideLevel(Rectangle) {

}*/

private boolean checkCollision(Rectangle Element[][] ) {
    /*for (int brickY: List.of((int)y1 / Tile.SIZE, (int)y2 / Tile.SIZE)) {
        for (int brickX: List.of((int)x1 / Tile.SIZE, (int)x2 / Tile.SIZE)) {
            if (bricks[brickY][brickX] != null)
                return true;
        }
    }*/
    return false;
}

public boolean isLevelClear() {return levelClear;}

/*public boolean collidesLeft(Vector position, Vector size) {
    double x = position.x(), y = position.y();
    return checkCollision(x, x + 1, y, y + size.y() - 1, tiles);
}*/

/*public boolean collidesRight(Vector position, Vector size) {
    double x = position.x(), y = position.y();
    return checkCollision(x + size.x() - 1, x + size.x() - 1, y, y + size.y() - 1, tiles);
}*/

/*public boolean collidesUp(Position position) {
    double x = position.x(), y = position.y();
    return checkCollision(x, x + size.x() - 1, y, y + 1, tiles);
}*/

/*public boolean collidesDown(Vector position, Vector size) {
    double x = position.x(), y = position.y();
    return checkCollision(x, x + size.x() - 1, y + size.y() - 2, y + size.y() - 1, tiles);
}*/
}
