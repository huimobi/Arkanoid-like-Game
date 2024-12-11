package project.com.Viewer.MainMenu;

import project.com.Model.Option;
import project.com.Viewer.TextViewer;
import project.com.gui.GUI;

import javax.sound.midi.SysexMessage;
import java.io.IOException;

public class OptionViewer {
    private final TextViewer text;
    private String optionText;
    public OptionViewer(TextViewer text) {
        this.text= text;
    }

    public void draw(Option model, GUI gui) throws IOException { //need a option model class
        String optionText = switch (model.getType()) {
            case START_GAME -> "Start";
            case INFO -> "Info";
            case EXIT -> "Exit";
            case TO_MAIN_MENU -> "Back";
        };
        this.optionText=optionText;
        text.draw(optionText, model.getPosition(),gui);

    }

    public void showSelect(Option model,String color,GUI gui) throws IOException {
        text.setForeground(gui,color,model.getPosition(),optionText);
    }

    public void unSelect(Option model,GUI gui) throws IOException {
        text.setForegroundDefault(gui,model.getPosition(),optionText);
    }
}
