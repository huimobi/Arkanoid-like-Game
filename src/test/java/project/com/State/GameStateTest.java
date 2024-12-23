package project.com.State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import project.com.Control.Controller;
import project.com.Control.Game.GameController;
import project.com.Model.Levels.Level;
import project.com.Viewer.Screen.GameViewer;
import project.com.Viewer.Screen.Viewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.ViewerProvider;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

    @Mock
    private Level mockLevel;

    @Mock
    private ImageLoader mockImageLoader;

    @Mock
    private ViewerProvider mockViewerProvider;

    private GameState gameState;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        gameState = new GameState(mockLevel, mockImageLoader);
    }

    @Test
    void testCreateViewer() {
        Viewer<Level> viewer = gameState.createViewer(mockViewerProvider);

        assertNotNull(viewer);
        assertTrue(viewer instanceof GameViewer);
    }

    @Test
    void testCreateController() {
        Controller<Level> controller = gameState.createController();

        assertNotNull(controller);
        assertTrue(controller instanceof GameController);

        GameController gameController = (GameController) controller;
        assertNotNull(gameController);
    }
}