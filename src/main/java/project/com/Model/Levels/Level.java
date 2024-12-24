package project.com.Model.Levels;


import project.com.Model.Elements.Ball;
import project.com.Model.Elements.Brick;
import project.com.Model.Elements.Paddle;
import project.com.Model.Elements.PowerUp;
import project.com.Model.Position;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

public class Level {
    private final Rectangle gameArea;
    private final int levelNumber;
    private final ArrayList<Brick> bricks;
    private final Paddle paddle;
    private final Ball ball;
    private final Position ballDefaultVelocity;
    private long waitStartTime;
    private static final long SLEEP = 3000;
    private int score;
    private final int highestScore;
    private final ArrayList<PowerUp> powerUps;
    private PowerUp.Bonus curPowerUp;


    public Level(Rectangle gameArea, int levelNumber, Paddle paddle, Ball ball, ArrayList<Brick> bricks, int score, int highestScore) {
        this.ballDefaultVelocity = ball.getVelocity();
        this.gameArea = gameArea;
        this.levelNumber = levelNumber;
        this.paddle = paddle;
        this.ball = ball;
        this.bricks = bricks;
        this.waitStartTime = setWaitTime();
        this.score = score;
        this.highestScore= highestScore;
        this.powerUps=new ArrayList<>();
        this.curPowerUp= PowerUp.Bonus.None;
    }

    private long setWaitTime() {
        this.waitStartTime = System.currentTimeMillis();
        return waitStartTime;
    }

    public void setCurPowerUp(PowerUp.Bonus curPowerUp) {
        this.curPowerUp = curPowerUp;
    }

    public int getWidth() {
        return gameArea.width;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public ArrayList<PowerUp> getPowerUps() {
        return powerUps;
    }

    public int getHeight() {
        return gameArea.height;
    }

    public Position getPosition() {
        return new Position(gameArea.x, gameArea.y);
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

    public int getHighestScore(){
        return highestScore;
    }

    public void setPaddle(Position position) {
        paddle.setPosition(position);
    }

    public boolean isInitialSleep() {
        return System.currentTimeMillis() - waitStartTime <= SLEEP;
    }

    public boolean isLevelClear() {
        if (bricks.isEmpty()) return true;
        for (Brick brick : bricks) {
            if (brick.getCharacter() != '#') return false;
        }
        return true;
    }

    public boolean checkOutsideLevel(Rectangle nextMove) {
        return !gameArea.contains(nextMove);
    }

    public COLLISIONS collides(Rectangle nextMove) {

        if(checkOutsideLevel(nextMove)){
            return areaGameCollision(nextMove);
        }

        //checks collision Paddle
        if (nextMove.intersects(paddle.getHitBox())) {
            return paddleCollision(nextMove);
        }

        for (Brick brick : bricks) {
            if (nextMove.intersects(brick.getHitBox())) {
                COLLISIONS collision = typeBrickCollision(brick.getHitBox(), nextMove);
                hit(brick);
                if(curPowerUp.equals(PowerUp.Bonus.breakAll) && brick.getCharacter()!='#') return COLLISIONS.NONE;  //migh be problematic
                return collision;
            }
        }
        return COLLISIONS.NONE;
    }


    COLLISIONS areaGameCollision(Rectangle nextMove){
        if (collisionLeft(gameArea, nextMove)){
            return COLLISIONS.LEFT;
        }
        if (collisionRight(gameArea,nextMove)){
            return COLLISIONS.RIGHT;
        }
        if (collisionUP(gameArea,nextMove)) {
            return COLLISIONS.UP;
        }
        return COLLISIONS.NONE;
    }


    COLLISIONS typeBrickCollision(Rectangle brick, Rectangle nextMove){
            Rectangle collision = brick.intersection(nextMove);
            if (collision.width > collision.height) {
                if (collisionDown(brick, nextMove)) {
                    return COLLISIONS.DOWN;
                }
                if (collisionUP(brick, nextMove)) {
                    return COLLISIONS.UP;
                }
            } else if (collision.width < collision.height) {
                if (collisionLeft(brick, nextMove)) {
                    return COLLISIONS.LEFT;
                }
                if (collisionRight(brick, nextMove)) {
                    return COLLISIONS.RIGHT;
                }
            } else { //it's a corner collision
                if (collisionDown(brick, nextMove) & collisionLeft(brick, nextMove)) {
                    return COLLISIONS.BOTTOMLEFT;
                }
                if (collisionDown(brick, nextMove) & collisionRight(brick, nextMove)) {
                    return COLLISIONS.BOTTOMRIGHT;
                }
                if (collisionUP(brick, nextMove) & collisionRight(brick, nextMove)) {
                    return COLLISIONS.TOPRIGHT;
                }
                if (collisionUP(brick, nextMove) & collisionLeft(brick, nextMove)) {
                    return COLLISIONS.TOPLEFT;
                }
            }
            return COLLISIONS.NONE;
        }

    COLLISIONS paddleCollision(Rectangle nextMove){
        if(nextMove.intersects(paddle.farLeft())) return COLLISIONS.PADDLELEFT;
        if(nextMove.intersects(paddle.farRight())) return COLLISIONS.PADDLERIGHT;
        if(nextMove.intersects(paddle.middleLeft())) return COLLISIONS.PADDLEMIDDLELEFT;
        if(nextMove.intersects(paddle.middleRight())) return COLLISIONS.PADDLEMIDDLERIGHT;
        return COLLISIONS.NONE;
    }

    //left side
    public boolean collisionLeft(Rectangle target, Rectangle nextMove) {
        Line2D.Double leftSide = new Line2D.Double(
                target.x,
                target.y,
                target.x,
                target.y + target.height
        );
        return nextMove.intersectsLine(leftSide);
    }

    //right side
    public boolean collisionRight(Rectangle target, Rectangle nextMove) {
        Line2D.Double rightSide = new Line2D.Double(
                target.x + target.width,
                target.y,
                target.x + target.width,
                target.y + target.height
        );
        return nextMove.intersectsLine(rightSide);
    }

    //top side
    public boolean collisionUP(Rectangle target, Rectangle nextMove) {
        Line2D.Double upSide = new Line2D.Double(
                target.x,
                target.y,
                target.x + target.width,
                target.y
        );
        return nextMove.intersectsLine(upSide);
    }

    //ground side
    public boolean collisionDown(Rectangle target, Rectangle nextMove) {
        Line2D.Double downSide = new Line2D.Double(
                target.x,
                target.y + target.height,
                target.x + target.width,
                target.y + target.height
        );
        return nextMove.intersectsLine(downSide);
    }


    public void updateLives() {
        setPowerUpsOff();
        paddle.decreaseLives();
        powerUps.clear();
        ball.setVelocity(ballDefaultVelocity);
        setWaitTime();
    }

    public void hit(Brick brick) {
        brick.hit();
        if (brick.getDurability() == 0) {
            Random random = new Random();
            if (random.nextInt(100) + 1 <= 15) {
                powerUps.add(new PowerUp(brick.getPosition()));
            }
            bricks.remove(brick);
            //different hits for different bricks
            score+=brick.getScore();
        }
    }

    public void setPowerUpsOff() {
        paddle.setPowerUpOff();
        ball.setPowerUpOff();
        curPowerUp= PowerUp.Bonus.None;
    }

}
