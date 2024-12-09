package project.com.Model;


public class Lives extends Element {
    private int lives;
    public Lives(Position position) {
        super(position);
        this.lives=3;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
