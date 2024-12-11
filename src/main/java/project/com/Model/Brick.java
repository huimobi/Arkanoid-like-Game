package project.com.Model;

import java.awt.*;

public class Brick extends Static{
    private final Rectangle hitbox;
    private final char character;

    public Brick(Position position, char character) {
        super(position);
        this.character=character;
        this.hitbox= new Rectangle(position.getX(),position.getY(),15,5);
    }

    public Rectangle getHitbox(){
        return hitbox;
    }
    @Override
    public void setSize(int width, int height) {
        hitbox.setSize(new Dimension(width,height));
    }

    public char getCharacter() {
        return character;
    }
}
