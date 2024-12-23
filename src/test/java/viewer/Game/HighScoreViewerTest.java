package viewer.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Levels.Level;
import project.com.Model.Position;
import project.com.Viewer.Game.HighScoreViewer;
import project.com.Viewer.Text.TextViewer;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class HighScoreViewerTest {
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
        when(level.getHighestScore()).thenReturn(10000);

        HighScoreViewer highScoreViewer = new HighScoreViewer(textViewer);

        highScoreViewer.draw(level, gui);
        verify(textViewer, times(1)).draw(eq(String.valueOf(10000)), any(Position.class), eq(gui));
    }
}
