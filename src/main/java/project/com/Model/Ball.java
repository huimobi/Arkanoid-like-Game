package project.com.Model;

import java.awt.*;

public class Ball extends Movable{
    private int LENGTH=5;
    private Rectangle hitbox;

    public Ball(Position position,Level level) {
        super(position,new Position(2,-4),level);
        this.hitbox=new Rectangle(position.getX(),position.getY(),LENGTH,LENGTH);
    }

    public Rectangle getHitbox(){
        return hitbox;
    }

    public void reflectHorizontal(){
        setVelocity(new Position(-getVelocity().getX(),getVelocity().getY()));
    }
    public void reflectVertical(){
        setVelocity(new Position(getVelocity().getX(),-getVelocity().getY()));
    }

    public int getLENGTH() {
        return LENGTH;
    }
}