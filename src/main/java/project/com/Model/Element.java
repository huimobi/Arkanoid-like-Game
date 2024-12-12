package project.com.Model;

public abstract class Element {
    private Position position;
    public Element(Position position){
        this.position=position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}