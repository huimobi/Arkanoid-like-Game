package project.com.Viewer.Game;

import project.com.Model.Levels.Level;
import project.com.Model.Position;
import project.com.Viewer.Elements.ElementViewer;
import project.com.Viewer.Text.TextViewer;
import project.com.gui.GUI;

import java.io.IOException;

public class ScoreViewer implements ElementViewer<Level> {
    private TextViewer textViewer;

    public ScoreViewer(TextViewer textViewer) {
        this.textViewer= textViewer;
    }

    @Override
    public void draw(Level model, GUI gui) throws IOException {
        String score= String.valueOf(model.getScore());
        textViewer.draw(score,new Position((gui.getWidth()-(score.length()*7)+180)/2,((gui.getHeight()-7)/4)+14),gui);
    }
}
