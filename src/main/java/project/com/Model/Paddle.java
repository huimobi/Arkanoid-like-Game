package project.com.Model;

public class Paddle extends Movable{
    private boolean powerUp;
    Paddle(Position position) {
        super(position);
        this.powerUp=false;
    }
    public Boolean getpowerUp(){
        return powerUp;
    }
}
