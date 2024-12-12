package project.com.Model;

public class Paddle extends Movable{
    private boolean powerUp;
    public Paddle(Position position) {
        super(position);
        this.powerUp=false;
    }
    public Boolean getpowerUp(){
        return powerUp;
    }
}
