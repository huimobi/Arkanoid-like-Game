package project.com.Model;

import java.awt.*;

public class Brick extends Element {
    private final char character;
    private int durability;

    public Brick(Position position, char character) {
        super(position,15,5);
        this.character = character;
        this.durability = 1;
    }

    public Rectangle getHitBox() {
        return super.getHitBox();
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
        if(character!='#') durability--;
    }
}