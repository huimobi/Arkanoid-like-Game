package project.com.State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import project.com.Control.Controller;
import project.com.Control.Menu.InfoMenuController;
import project.com.Model.Menus.InfoMenu;
import project.com.Viewer.Screen.InfoViewer;
import project.com.Viewer.Screen.Viewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.ViewerProvider;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InfoMenuStateTest {

    @Mock
    private InfoMenu mockInfoMenu;

    @Mock
    private ImageLoader mockImageLoader;

    @Mock
    private ViewerProvider mockViewerProvider;

    private InfoMenuState InfoMenuState;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        InfoMenuState = new InfoMenuState(mockInfoMenu, mockImageLoader);
    }

    @Test
    void testCreateViewer() {
        Viewer<InfoMenu> viewer = InfoMenuState.createViewer(mockViewerProvider);

        assertNotNull(viewer);
        assertTrue(viewer instanceof InfoViewer);
    }

    @Test
    void testCreateController() {
        Controller<InfoMenu> controller = InfoMenuState.createController();

        assertNotNull(controller);
        assertTrue(controller instanceof InfoMenuController);

        InfoMenuController InfoMenuController = (InfoMenuController) controller;
        assertNotNull(InfoMenuController);
    }
}