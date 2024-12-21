package project.com.Model.Menus;

import project.com.Model.Position;

public record Option(Position position, Option.Type type) {

    public Type getType() {
        return type;
    }

    public enum Type {START_GAME, INFO, EXIT, TO_MAIN_MENU, LEFT, RIGHT, ENTER, ESC}

}
