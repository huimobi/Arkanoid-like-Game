package project.com.Model;

public class Option{
    public enum Type { START_GAME, INFO, EXIT, TO_MAIN_MENU, LEFT, RIGHT, ENTER, ESC}
    private final Type type;
    private final Position position;

    public Option(Position position, Type type) {
        this.position = position;
        this.type = type;
    }

    public Position getPosition() {
        return position;
    }

    public Type getType() {
        return type;
    }

}
