package project.com.Model;


import java.awt.*;
import java.util.ArrayList;

public class Level {
    private Rectangle gameArea;
    private int levelNumber;
    private ArrayList<Brick> bricks;
    private Paddle paddle;
    private boolean levelClear;
    private Ball ball;
    private boolean initialSleep;
    private long waitStartTime;
    private static final long WAIT_TIME = 3000;

    public Level(Rectangle gameArea, int levelNumber,Paddle paddle,ArrayList<Brick>bricks) {
        this.gameArea = gameArea;
        this.levelNumber = levelNumber;
        this.levelClear = false;
        this.paddle = paddle;
        this.ball = new Ball(new Position(paddle.getPosition().getX()+12,paddle.getPosition().getY()-5));
        this.bricks=bricks;
        this.initialSleep=true;
        this.waitStartTime=System.currentTimeMillis();
    }

    public int getWidth() {
        return gameArea.width;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getHeight() {
        return gameArea.height;
    }
    public Position getPosition(){
        return new Position(gameArea.x,gameArea.y);
    }

    public Ball getBall() {
        return ball;
    }


    public Paddle getPaddle() {
        return paddle;
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public void setPaddle(Position position) {
        paddle.setPosition(position);
    }

    public boolean isInitialSleep() { if (System.currentTimeMillis() - waitStartTime <= WAIT_TIME){
        return true;
    }
        return false; }


    /*private boolean checkOutsideLevel(Rectangle) {

}*/

    private boolean checkCollision(Rectangle Element[][]) {
    /*for (int brickY: List.of((int)y1 / Tile.SIZE, (int)y2 / Tile.SIZE)) {
        for (int brickX: List.of((int)x1 / Tile.SIZE, (int)x2 / Tile.SIZE)) {
            if (bricks[brickY][brickX] != null)
                return true;
        }
    }*/
        return false;
    }

    public boolean isLevelClear() {
        return levelClear;
    }
}
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
