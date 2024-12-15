package project.com.Viewer.Game;

import project.com.Arkanoid;
import project.com.Model.Level;
import project.com.Model.Position;
import project.com.Viewer.Elements.ElementViewer;
import project.com.Viewer.TextViewer;
import project.com.gui.GUI;

import java.io.IOException;

public class RoundViewer implements ElementViewer<Level> {
    private TextViewer textViewer;

    public RoundViewer(TextViewer textViewer) {
        this.textViewer= textViewer;
    }

    @Override
    public void draw(Level model, GUI gui) throws IOException {
        String roundNumber= String.valueOf(model.getLevelNumber());
        textViewer.draw(roundNumber,new Position(gui.getWidth()-7*roundNumber.length(),gui.getHeight()-7),gui);
    }
}
