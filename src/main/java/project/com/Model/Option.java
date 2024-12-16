package project.com.Model;

public record Option(Position position, project.com.Model.Option.Type type) {

    public Type getType() {
        return type;
    }

    public enum Type {START_GAME, INFO, EXIT, TO_MAIN_MENU, LEFT, RIGHT, ENTER, ESC}

}
