package project.com.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import project.com.Viewer.Elements.*;
import project.com.Viewer.Game.*;
import project.com.Viewer.Info.*;
import project.com.Viewer.MainMenu.*;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Text.TextViewer;
import project.com.Viewer.ViewerProvider;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ViewerProviderTest {

    @Mock
    private ImageLoader mockImageLoader;

    private ViewerProvider viewerProvider;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        viewerProvider = new ViewerProvider(mockImageLoader);
    }

    @Test
    void testBrickViewer() {
        assertNotNull(viewerProvider.getBrickViewer());
        assertTrue(viewerProvider.getBrickViewer() instanceof BrickViewer);
    }

    @Test
    void testPaddleViewer() {
        assertNotNull(viewerProvider.getPaddleViewer());
        assertTrue(viewerProvider.getPaddleViewer() instanceof PaddleViewer);
    }

    @Test
    void testBallViewer() {
        assertNotNull(viewerProvider.getBallViewer());
        assertTrue(viewerProvider.getBallViewer() instanceof BallViewer);
    }

    @Test
    void testGameBackgroundViewer() {
        assertNotNull(viewerProvider.getGameBackground());
        assertTrue(viewerProvider.getGameBackground() instanceof GameBackgroundViewer);
    }

    @Test
    void testMainMenuBackgroundViewer() {
        assertNotNull(viewerProvider.getMainMenuBackground());
        assertTrue(viewerProvider.getMainMenuBackground() instanceof MainMenuBackgroundViewer);
    }

    @Test
    void testTextViewer() {
        assertNotNull(viewerProvider.getTextViewer());
        assertTrue(viewerProvider.getTextViewer() instanceof TextViewer);
    }

    @Test
    void testOptionViewer() {
        assertNotNull(viewerProvider.getOptionsViewer());
        assertTrue(viewerProvider.getOptionsViewer() instanceof OptionViewer);
    }

    @Test
    void testLogoViewer() {
        assertNotNull(viewerProvider.getLogoViewer());
        assertTrue(viewerProvider.getLogoViewer() instanceof LogoViewer);
    }

    @Test
    void testRoundViewer() {
        assertNotNull(viewerProvider.getRoundViewer());
        assertTrue(viewerProvider.getRoundViewer() instanceof RoundViewer);
    }

    @Test
    void testInformationsViewer() {
        assertNotNull(viewerProvider.getInfosViewer());
        assertTrue(viewerProvider.getInfosViewer() instanceof InformationsViewer);
    }

    @Test
    void testWordInfoViewer() {
        assertNotNull(viewerProvider.getWordInfoViewer());
        assertTrue(viewerProvider.getWordInfoViewer() instanceof WordInfoViewer);
    }

    @Test
    void testLeftViewer() {
        assertNotNull(viewerProvider.getLeftViewer());
        assertTrue(viewerProvider.getLeftViewer() instanceof LeftViewer);
    }

    @Test
    void testRightViewer() {
        assertNotNull(viewerProvider.getRightViewer());
        assertTrue(viewerProvider.getRightViewer() instanceof RightViewer);
    }

    @Test
    void testESCViewer() {
        assertNotNull(viewerProvider.getEscViewer());
        assertTrue(viewerProvider.getEscViewer() instanceof ESCViewer);
    }

    @Test
    void testEnterViewer() {
        assertNotNull(viewerProvider.getEnterViewer());
        assertTrue(viewerProvider.getEnterViewer() instanceof EnterViewer);
    }

    @Test
    void testLivesViewer() {
        assertNotNull(viewerProvider.getLivesViewer());
        assertTrue(viewerProvider.getLivesViewer() instanceof LivesViewer);
    }

    @Test
    void testScoreViewer() {
        assertNotNull(viewerProvider.getScoreViewer());
        assertTrue(viewerProvider.getScoreViewer() instanceof ScoreViewer);
    }

    @Test
    void testHighScoreViewer() {
        assertNotNull(viewerProvider.getHighScoreViewer());
        assertTrue(viewerProvider.getHighScoreViewer() instanceof HighScoreViewer);
    }

    @Test
    void testPowerUpViewer() {
        assertNotNull(viewerProvider.getPowerUpViewer());
        assertTrue(viewerProvider.getPowerUpViewer() instanceof PowerUpViewer);
    }
}
