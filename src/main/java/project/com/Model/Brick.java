package project.com.Model;

import java.awt.*;

public class Brick extends Element {
    private final char character;
    private int durability;
    private int score;

    public Brick(Position position, char character) {
        super(position,15,8);
        this.character = character;
        this.durability = setDurability();
        this.score = setScore();
    }

    public Rectangle getHitBox() {
        return super.getHitBox();
    }

    public char getCharacter() {
        return character;
    }

    public int setDurability() {
        switch (character) {
            case ('#'):
                this.durability = 5;
                break;
            case ('Y'):
                this.durability = 2;
                break;
            case ('B'), ('G'), ('P'):
                this.durability = 1;
                break;
        }
        return durability;
    }

    public int getDurability(){
        return durability;
    }

    public void hit(){
        durability--;
    }
    private int setScore(){
        switch (character){
            case ('Y'):
                this.score = 50;
                break;
            case ('B'):
                this.score = 30;
                break;
            case ('G'):
                this.score = 20;
                break;
            case ('P'):
                this.score = 10;
                break;
        }
        return score;
        }

        public int getScore(){
            return score;
        }
    }