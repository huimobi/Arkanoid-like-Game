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
            case START_GAME, INFO, EXIT -> null;
            case LEFT -> " Moves the paddle to the left";
            case RIGHT -> " Moves the paddle to the right";
            case ENTER -> " Select the desired option";
            case ESC -> " Quit or return to the main menu";
            case TO_MAIN_MENU -> "Back";
        };
        this.infoText = infoText;
        text.draw(infoText, model.getPosition(), gui);
    }
    public void showSelect(Option model,String color,GUI gui) throws IOException {
        text.setForeground(gui,color,model.getPosition(),infoText);
    }
}
