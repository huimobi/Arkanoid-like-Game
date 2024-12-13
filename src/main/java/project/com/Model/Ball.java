package project.com.Model;

import java.awt.*;

public class Ball extends Movable {
    public Ball(Position position, Level level) {
        super(position, 5, 5, new Position(2, -4), level);
    }

    public void reflectHorizontal() {
        setVelocity(new Position(-getVelocity().getX(), getVelocity().getY()));
    }

    public void reflectVertical() {
        setVelocity(new Position(getVelocity().getX(), -getVelocity().getY()));
    }
}
