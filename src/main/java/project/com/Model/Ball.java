package project.com.Model;

import java.awt.*;

public class Ball extends Movable{
    private int LENGTH=5;
    private Rectangle hitbox;

    public Ball(Position position) {
        super(position);

    }

    public Rectangle getHitbox(){
        return hitbox;
    }

    public void reflectHorizontal(){
        move(-getPosition().getX(),0);
    }
    public void reflectVertical(){
        move(0,-getPosition().getY());
    }

    public void checkCollision(Paddle paddle) {
    }

    public int getLENGTH() {
        return LENGTH;
    }

    //falta implementar
    public Position updatePosition() {
    }
}