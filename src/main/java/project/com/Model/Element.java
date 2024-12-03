package project.com.Model;

public abstract class Element {
    private Position position;
    private int x;
    private int y;
    private Position size;

    public Element(Position position){
        this.position=position;
    }

    public void setSize(int x, int y) {
        this.x=x;
        this.y=y;
        this.size= new Position(x, y);    }

    public Position getSize() {
        return size;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
