package project.com.Viewer.MainMenu;

import project.com.Model.Info;
import project.com.Viewer.TextViewer;
import project.com.gui.GUI;

import java.io.IOException;

public class InfosViewer {
    private final TextViewer text;
    private String infoText;
    
    public InfosViewer(TextViewer text) {
        this.text = text;
    }
    public void draw(Info model, GUI gui) throws IOException {
        String infoText = switch (model.getType()) {
            case LEFT -> "Moves the paddle to the left";
            case RIGHT -> "Moves the paddle to the right";
            case ENTER -> "Select the desired options in the menu";
            case ESC -> "Quit or return to the main menu";
        };
        this.infoText = infoText;
        text.draw(infoText, model.getPosition(), gui);
    }
}
