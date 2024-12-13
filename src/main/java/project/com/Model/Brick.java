package project.com.Model;

import java.awt.*;

public class Brick extends Static {
    private final Rectangle hitBox;
    private final char character;
    private int durability;

    public Brick(Position position, char character) {
        super(position);
        this.character = character;
        this.hitBox = new Rectangle(position.getX(), position.getY(), 15, 5);
        this.durability = 1;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public char getCharacter() {
        return character;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getDurability(){
        return durability;
    }

    public void hit(){
        durability--;
    }
}