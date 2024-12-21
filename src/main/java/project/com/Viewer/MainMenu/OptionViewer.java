package project.com.Viewer.MainMenu;

import project.com.Model.Menus.Option;
import project.com.Viewer.Text.TextViewer;
import project.com.gui.GUI;

import java.io.IOException;

public class OptionViewer {
    private final TextViewer text;
    private String optionText;
    public OptionViewer(TextViewer text) {
        this.text= text;
    }

    public void draw(Option model, GUI gui) throws IOException {
        String optionText = switch (model.type()) {
            case START_GAME -> "Start";
            case INFO -> "Info";
            case EXIT -> "Exit";
            case TO_MAIN_MENU -> "Back";
            case LEFT, RIGHT, ENTER, ESC -> null;
        };
        this.optionText=optionText;
        text.draw(optionText, model.position(),gui);

    }

    public void showSelect(Option model,String color,GUI gui) throws IOException {
        text.setForeground(gui,color,model.position(),optionText);
    }
}
