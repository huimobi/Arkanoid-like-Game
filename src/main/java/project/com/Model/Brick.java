package project.com.Model;

import java.awt.*;

public class Brick extends Element {
    private final char character;
    private int durability;

    public Brick(Position position, char character) {
        super(position,15,8);
        this.character = character;
        this.durability = setDurability();
    }

    public Rectangle getHitBox() {
        return super.getHitBox();
    }

    public char getCharacter() {
        return character;
    }

    public int setDurability() {
        switch (character) {
            case ('Y'):
                this.durability = 3;
                break;
            case ('B'):
                this.durability = 2;
                break;
            case ('G'):
                this.durability = 2;
                break;
            case ('P'):
                this.durability = 1;
                break;
        }
        return durability;
    }

    public int getDurability(){
        return durability;
    }

    public void hit(){
        if(character!='#') durability--;
    }
}