package project.com.Model.Elements;

import project.com.Model.Position;

public abstract class Movable extends Element{
    private Position velocity;

    public Movable(Position position,int width,int height,Position velocity){
        super(position,width,height);
        this.velocity=velocity;
    }

    public void move(){
        setPosition(new Position(getPosition().getX()+getVelocity().getX(), getPosition().getY()+getVelocity().getY()));
    }

    public Position getVelocity() {
        return velocity;
    }

    public void setVelocity(Position velocity) {
        this.velocity = velocity;
    }


    public boolean isMovingUpLeft(){
        return velocity.getX() < 0 & velocity.getY() < 0;
    }

    public boolean isMovingDownLeft(){
        return velocity.getX() < 0 & velocity.getY() > 0;
    }

    public boolean isMovingDownRight(){
        return velocity.getX() > 0 & velocity.getY() > 0 ;
    }
}