package project.com.Model.Elements;

import project.com.Model.Position;

import java.util.Random;

public class PowerUp extends Movable{
    public enum Bonus{None,PaddleSizeUp,slowBall,extraPaddle,breakAll}

    public PowerUp(Position position) {
        super(position,13,6,new Position(0,1));
    }

    public Bonus getPowerUp() {
        Random random = new Random();
        Bonus[] bonuses = Bonus.values();
        return bonuses[random.nextInt(bonuses.length)];
    }

}
