package viewer.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import project.com.Model.Levels.Level;
import project.com.Viewer.Elements.*;
import project.com.Viewer.Game.GameBackgroundViewer;
import project.com.Viewer.Game.HighScoreViewer;
import project.com.Viewer.Game.RoundViewer;
import project.com.Viewer.Game.ScoreViewer;
import project.com.Viewer.Screen.GameViewer;
import project.com.Viewer.Text.TextViewer;
import project.com.Viewer.ViewerProvider;
import project.com.gui.GUI;

import java.io.IOException;
import java.util.ArrayList;


import static org.mockito.Mockito.*;

public class GameViewerTest {
    private PaddleViewer paddleViewer;
    private BallViewer ballViewer;
    private LivesViewer livesViewer;
    private GameBackgroundViewer gameBackgroundViewer;
    private RoundViewer roundViewer;
    private ScoreViewer scoreViewer;
    private HighScoreViewer highScoreViewer;
    private ViewerProvider viewerProvider;
    private GUI gui;
    private Level level;

    @BeforeEach
    public void setup() {
        this.paddleViewer = mock(PaddleViewer.class);
        BrickViewer brickViewer = mock(BrickViewer.class);
        this.ballViewer = mock(BallViewer.class);
        this.livesViewer =mock(LivesViewer.class);
        this.gameBackgroundViewer =mock(GameBackgroundViewer.class);
        this.roundViewer= mock(RoundViewer.class);
        this.scoreViewer =mock(ScoreViewer.class);
        this.highScoreViewer =mock(HighScoreViewer.class);
        PowerUpViewer powerUpViewer = mock(PowerUpViewer.class);
        this.viewerProvider=mock(ViewerProvider.class);
        this.gui=mock(GUI.class);
        this.level= mock(Level.class);
        TextViewer textViewer = mock(TextViewer.class);

        when(viewerProvider.getBallViewer()).thenReturn(ballViewer);
        when(viewerProvider.getPaddleViewer()).thenReturn(paddleViewer);
        when(viewerProvider.getBrickViewer()).thenReturn(brickViewer);
        when(viewerProvider.getLivesViewer()).thenReturn(livesViewer);
        when(viewerProvider.getGameBackground()).thenReturn(gameBackgroundViewer);
        when(viewerProvider.getRoundViewer()).thenReturn(roundViewer);
        when(viewerProvider.getScoreViewer()).thenReturn(scoreViewer);
        when(viewerProvider.getHighScoreViewer()).thenReturn(highScoreViewer);
        when(viewerProvider.getPowerUpViewer()).thenReturn(powerUpViewer);
        when(viewerProvider.getTextViewer()).thenReturn(textViewer);
    }


    @Test
    public void testDraw() throws IOException {

        GameViewer gameViewer=new GameViewer(level,viewerProvider);

        when(level.getBricks()).thenReturn(new ArrayList<>());
        when(level.getPowerUps()).thenReturn(new ArrayList<>());

        gameViewer.draw(gui);

        verify(gui,times(1)).clear();
        verify(gameBackgroundViewer).draw(gui);
        verify(paddleViewer).draw(level.getPaddle(), gui);
        verify(ballViewer).draw(level.getBall(), gui);
        verify(livesViewer).draw(level.getPaddle(), gui);
        verify(roundViewer).draw(level, gui);
        verify(scoreViewer).draw(level, gui);
        verify(highScoreViewer).draw(level, gui);
        verify(gui).refresh();
    }

}
