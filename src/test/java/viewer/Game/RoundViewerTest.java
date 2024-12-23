package viewer.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Levels.Level;
import project.com.Model.Position;
import project.com.Viewer.Game.HighScoreViewer;
import project.com.Viewer.Game.RoundViewer;
import project.com.Viewer.Text.TextViewer;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class RoundViewerTest {
    private GUI gui;
    private TextViewer textViewer;
    private Level level;

    @BeforeEach
    public void setup() {
        this.textViewer = mock(TextViewer.class);
        this.gui = mock(GUI.class);
        this.level= mock(Level.class);
    }

    @Test
    public void draw() throws IOException {
        when(level.getLevelNumber()).thenReturn(2);

        RoundViewer roundViewer = new RoundViewer(textViewer);

        roundViewer.draw(level, gui);
        verify(textViewer, times(1)).draw(eq(String.valueOf(2)), any(Position.class), eq(gui));
    }
}
