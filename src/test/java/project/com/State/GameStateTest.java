package project.com.State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Control.Controller;
import project.com.Control.Game.GameController;
import project.com.Model.Elements.Ball;
import project.com.Model.Levels.Level;
import project.com.Viewer.Screen.GameViewer;
import project.com.Viewer.Screen.Viewer;
import project.com.Viewer.ViewerProvider;
import project.com.Viewer.Sprite.ImageLoader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameStateTest {

    private GameState gameState;
    private Level mockLevel;
    private ViewerProvider mockViewerProvider;


    @BeforeEach
    void setUp() throws IOException {
        mockLevel = mock(Level.class);
        ImageLoader mockImageLoader = mock(ImageLoader.class);
        mockViewerProvider = mock(ViewerProvider.class);

        // Mock the Ball and ensure it is properly initialized
        Ball mockBall = mock(Ball.class);
        when(mockLevel.getBall()).thenReturn(mockBall);

        gameState = new GameState(mockLevel, mockImageLoader);
    }


    @Test
    void testCreateViewer() {

        Viewer<Level> viewer = gameState.createViewer(mockViewerProvider);

        assertNotNull(viewer);
        assertTrue(viewer instanceof GameViewer);

        GameViewer gameViewer = (GameViewer) viewer;
        assertEquals(mockLevel, gameViewer.getModel());
    }

    @Test
    void testCreateControllerInteraction() {
        Controller<Level> controller = gameState.createController();

        assertNotNull(controller);
        assertTrue(controller instanceof GameController);

    }



}