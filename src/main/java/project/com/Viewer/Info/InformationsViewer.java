package project.com.Viewer.Info;

import project.com.Model.Option;
import project.com.Viewer.TextViewer;
import project.com.gui.GUI;

import java.io.IOException;

public class InformationsViewer {
    private final TextViewer text;
    private String infoText;
    
    public InformationsViewer(TextViewer text) {
        this.text = text;
    }
    public void draw(Option model, GUI gui) throws IOException {
        String infoText = switch (model.getType()) {
            case START_GAME, INFO, EXIT, TO_MAIN_MENU -> null;
            case LEFT -> " Moves the paddle to the left";
            case RIGHT -> " Moves the paddle to the right";
            case ENTER -> " Select the desired option";
            case ESC -> " Quit or return to the main menu";
        };
        this.infoText = infoText;
        text.draw(infoText, model.getPosition(), gui);
    }
}
