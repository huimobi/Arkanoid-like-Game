package project.com.Model;


import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Level {
    private final Rectangle gameArea;
    private final int levelNumber;
    private ArrayList<Brick> bricks;
    private final Paddle paddle;
    private final boolean levelClear;
    private final Ball ball;
    private final Position ballDefaultPosition;
    private final Position ballDefaultVelocity;
    private long waitStartTime;
    private static final long SLEEP = 3000;
    private int score;

    //enum COLLISION {LEFT,RIGHT,UP,DOWN,NONE}

    public Level(Rectangle gameArea, int levelNumber,Paddle paddle,Ball ball,ArrayList<Brick>bricks,int score) {
        this.ballDefaultPosition=ball.getPosition();
        this.ballDefaultVelocity=ball.getVelocity();
        this.gameArea = gameArea;
        this.levelNumber = levelNumber;
        this.levelClear = false;
        this.paddle = paddle;
        this.ball= ball;
        this.bricks=bricks;
        this.waitStartTime= setWaitTime();
        this.score=score;
    }

    private long setWaitTime(){
        this.waitStartTime=System.currentTimeMillis();
        return waitStartTime;
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

    public Rectangle getGameArea() {
        return gameArea;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public int getScore() {
        return score;
    }

    public void setPaddle(Position position) {
        paddle.setPosition(position);
    }

    public boolean isInitialSleep() {
        return System.currentTimeMillis() - waitStartTime <= SLEEP;
    }

    public boolean isLevelClear() {
        if(bricks.isEmpty()) return true;
        for(Brick brick:bricks){
            if(brick.getCharacter()!='#') return false;
        }
        return true;
    }

    public boolean checkOutsideLevel(Rectangle element,Position velocity) {
        Rectangle nextMove= new Rectangle(element.x+velocity.getX(),element.y+velocity.getY(),element.width,element.height);
        return !gameArea.contains(nextMove);
    }

    public boolean collides(Rectangle element,Position velocity) {
    Rectangle check= new Rectangle(element.x+velocity.getX(),element.y+velocity.getY(),element.width,element.height);
    for (Brick brick : bricks) {
        if(check.intersects(brick.getHitBox())) {
            brick.hit();
            if(brick.getDurability()==0) bricks.remove(brick);
            score++;
            return true;
        }
    }

    if(paddle.getHitBox().intersects(check)) return true;
    return false;
}

public boolean colisionLeft(Rectangle target, Rectangle element, Position velocity){
    Rectangle nextMove= new Rectangle(element.x+velocity.getX(),element.y+velocity.getY(),element.width,element.height);
    Line2D.Double leftSide = new Line2D.Double(
            target.x,
            target.y,
            target.x,
            target.y + target.height
    );
    return nextMove.intersectsLine(leftSide);
}

    public boolean colisionRight(Rectangle target,Rectangle element, Position velocity){
        Rectangle nextMove= new Rectangle(element.x+velocity.getX(),element.y+velocity.getY(),element.width,element.height);
        Line2D.Double rightSide = new Line2D.Double(
                target.x+target.width,
                target.y,
                target.x+target.width,
                target.y + target.height
        );
        return nextMove.intersectsLine(rightSide);
    }

    public boolean colisionUP(Rectangle target,Rectangle element, Position velocity){
        Rectangle nextMove= new Rectangle(element.x+velocity.getX(),element.y+velocity.getY(),element.width,element.height);
        Line2D.Double rightSide = new Line2D.Double(
                target.x,
                target.y,
                target.x+target.width,
                target.y
        );
        return nextMove.intersectsLine(rightSide);
    }

    public boolean colisionDown(Rectangle target,Rectangle element, Position velocity){
        Rectangle nextMove= new Rectangle(element.x+velocity.getX(),element.y+velocity.getY(),element.width,element.height);
        Line2D.Double rightSide = new Line2D.Double(
                target.x,
                target.y+target.height,
                target.x+target.width,
                target.y + target.height
        );
        return nextMove.intersectsLine(rightSide);
    }

    public void updateLives(){
        paddle.decreaseLives();
        ball.setPosition(ballDefaultPosition);
        ball.setVelocity(ballDefaultVelocity);
        setWaitTime();
    }
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
