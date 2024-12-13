package project.com.Model;


import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class Level {
    private Rectangle gameArea;
    private int levelNumber;
    private ArrayList<Brick> bricks;
    private Paddle paddle;
    private boolean levelClear;
    private Ball ball;
    private boolean initialSleep;

    public Level(Rectangle gameArea, int levelNumber,Paddle paddle,Ball ball,ArrayList<Brick>bricks) {
        this.gameArea = gameArea;
        this.levelNumber = levelNumber;
        this.levelClear = false;
        this.paddle = paddle;
        this.ball= ball;
        this.bricks=bricks;
        this.initialSleep=true;
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

    public boolean isInitialSleep() {
        return initialSleep;
    }

    public boolean checkOutsideLevel(Rectangle element,Position velocity) {
        Rectangle check= new Rectangle(element.x+velocity.getX(),element.y+velocity.getY(),element.width,element.height);
        return !gameArea.contains(check);
    }

    public boolean isLevelClear() {
        return levelClear;
    }

/*public boolean collidesLeft(Position velocity, Rectangle element) {
    Position left = new Position(element.x + velocity.getX(), element.y + velocity.getY());

    if (checkOutsideLevel(left)) return true;
    for (Brick brick : bricks) {
        if (element.x <= (brick.getHitBox().x + brick.getHitBox().width)) {
            return true;
        }
    }
    return false;
}*/

/*public boolean collidesRight(Position velocity, Rectangle element) {
        // Ball boundaries
        double ballLeft = ball.getHitbox().getX();
        double ballRight = ball.getHitbox().getX() + ball.getHitbox().getWidth();
        double ballTop = ball.getHitbox().getY();
        double ballBottom = ball.getHitbox().getY() + ball.getHitbox().getHeight();

        // Brick boundaries
        double brickLeft = brick.getgetX();
        double brickRight = brick.getX() + brick.getWidth();
        double brickTop = brick.getY();
        double brickBottom = brick.getY() + brick.getHeight();

        // Check for collision
        if (ballRight >= brickLeft && ballLeft <= brickRight &&
                ballBottom >= brickTop && ballTop <= brickBottom) {

            // Calculate overlap in both directions
            double overlapX = Math.min(ballRight - brickLeft, brickRight - ballLeft);
            double overlapY = Math.min(ballBottom - brickTop, brickBottom - ballTop);

            // Determine collision side
            if (overlapX < overlapY) {
                return (ball.getHitbox().getX() < brick.getX()) ? "LEFT" : "RIGHT";
            } else {
                return (ball.getHitbox().getY() < brick.getY()) ? "TOP" : "BOTTOM";
            }
        }
}*/

/*public boolean collidesUp(Position position) {
    double x = position.x(), y = position.y();
    return checkCollision(x, x + size.x() - 1, y, y + 1, tiles);
}*/

/*public boolean collidesDown(Vector position, Vector size) {
    double x = position.x(), y = position.y();
    return checkCollision(x, x + size.x() - 1, y + size.y() - 2, y + size.y() - 1, tiles);*/

}
