package project.com.Model;

import java.awt.*;

public class Brick extends Static {
    private final Rectangle hitbox;
    private final char character;
    private int durability;

    public Brick(Position position, char character) {
        super(position);
        this.character = character;
        this.hitbox = new Rectangle(position.getX(), position.getY(), 15, 5);
        this.durability = durability;
    }

    public Rectangle getHitbox() {
        return hitbox;
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
        if (durability>0){
            durability--;
        }
    }

    public boolean checkCollision(Rectangle ballHitbox){
        if(hitbox.intersects(ballHitbox)){
            hit();
            return true;
        }
        return false;
    }
}