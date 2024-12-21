package project.com.Model.Elements;

import project.com.Model.Position;

import java.awt.*;

public abstract class Element {
    private final Rectangle hitBox;
    public Element(Position position, int width, int height){
        this.hitBox=new Rectangle(position.getX(),position.getY(),width,height);
    }

    public void setPosition(Position position) {
        this.hitBox.setLocation(position.getX(),position.getY());
    }

    public Position getPosition() {
        return new Position(hitBox.x,hitBox.y);
    }

    public int getWidth(){
        return hitBox.width;
    }
    public int getHeight(){
        return hitBox.height;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void setWidth(int width){
        hitBox.setSize(width,hitBox.height);
    }

    public void setSize(Dimension size){
        hitBox.setSize(size);
    }
}