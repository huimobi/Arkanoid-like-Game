package project.com.State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import project.com.Arkanoid;
import project.com.Control.Controller;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Screen.Viewer;
import project.com.Viewer.ViewerProvider;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StateTest {

    @Mock
    private GUI mockGui;

    @Mock
    private Arkanoid mockArkanoid;

    @Mock
    private Controller<Object> mockController;

    @Mock
    private Viewer<Object> mockViewer;

    @Mock
    private ImageLoader mockImageLoader;


    private State<Object> state;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        state = new State<>(new Object(), mockImageLoader) {

            @Override
            protected Viewer<Object> createViewer(ViewerProvider viewerProvider) {
                return mockViewer;
            }

            @Override
            protected Controller<Object> createController() {
                return mockController;
            }
        };
    }

    @Test
    void testGetModel() {
        assertNotNull(state.getModel());
    }

    @Test
    void testStep() throws IOException, URISyntaxException, FontFormatException {
        long frameTime = 16L;
        GUI.ACTION mockAction = GUI.ACTION.UP;
        when(mockGui.getNextAction()).thenReturn(mockAction);

        state.step(mockArkanoid, mockGui, frameTime);

        verify(mockGui, times(1)).getNextAction();
        verify(mockController, times(1)).step(mockArkanoid, mockAction, frameTime);
        verify(mockViewer, times(1)).draw(mockGui);
    }
}
