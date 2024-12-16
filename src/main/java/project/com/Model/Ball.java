package project.com.Model;

public class Ball extends Movable {
    private boolean powerUp;

    public Ball(Position position) {
        super(position, 5, 5, new Position(2, -2));
        this.powerUp=false;
    }

    public void setPowerUpOn(){
        this.powerUp= true;
        setVelocity(new Position(getVelocity().getX() /2, getVelocity().getY() /2));
    }

    public void setPowerUpOff(){
        this.powerUp=false;
        if(isMovingDownLeft()) setAngle225();
        else if(isMovingDownRight()) setAngle315();
        else if(isMovingUpLeft()) setAngle135();
        else setAngle45();
    }

    public void reflectHorizontal() {
        setVelocity(new Position(-getVelocity().getX(), getVelocity().getY()));
    }

    public void reflectVertical() {
        setVelocity(new Position(getVelocity().getX(), -getVelocity().getY()));
    }

    public void setAngle45(){
        setVelocity(new Position(2,-2));
    }

    public void setAngle135(){
        setVelocity(new Position(-2,-2));
    }
    public void setAngle225(){
        setVelocity(new Position(-2,2));
    }
    public void setAngle315(){
        setVelocity(new Position(2,2));
    }

    public void setAngleBigger135(){
        setVelocity(new Position(-3,-2));
    }

    public void setAngleLess45(){
        setVelocity(new Position(3,-2));
    }

    public boolean isPowerUp() {
        return powerUp;
    }
}
