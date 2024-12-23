package project.com.State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import project.com.Control.Controller;
import project.com.Control.Menu.MainMenuController;
import project.com.Model.Menus.MainMenu;
import project.com.Viewer.Screen.MainMenuViewer;
import project.com.Viewer.Screen.Viewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.ViewerProvider;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuStateTest {

    @Mock
    private MainMenu mockMainMenu;

    @Mock
    private ImageLoader mockImageLoader;

    @Mock
    private ViewerProvider mockViewerProvider;

    private MainMenuState MainMenuState;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        MainMenuState = new MainMenuState(mockMainMenu, mockImageLoader);
    }

    @Test
    void testCreateViewer() {
        Viewer<MainMenu> viewer = MainMenuState.createViewer(mockViewerProvider);

        assertNotNull(viewer);
        assertTrue(viewer instanceof MainMenuViewer);
    }

    @Test
    void testCreateController() {
        Controller<MainMenu> controller = MainMenuState.createController();

        assertNotNull(controller);
        assertTrue(controller instanceof MainMenuController);

        MainMenuController MainMenuController = (MainMenuController) controller;
        assertNotNull(MainMenuController);
    }
}