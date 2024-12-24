import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Arkanoid;
import project.com.Control.Menu.InfoMenuController;
import project.com.Control.Menu.OptionsController;
import project.com.Model.*;
import project.com.State.MainMenuState;
import project.com.Viewer.ImageLoader;
import project.com.Viewer.ImageReader;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class InfoMenuControllerTest {

    private InfoMenu menu;
    private OptionsController optionsController;
    private InfoMenuController controller;
    private Arkanoid arkanoid;

    @BeforeEach
    public void setUp() throws IOException {
        menu = mock(InfoMenu.class);
        optionsController = mock(OptionsController.class);
        arkanoid = mock(Arkanoid.class);
        ImageLoader imageLoader = mock(ImageLoader.class);

        ImageReader mockImageReader = mock(ImageReader.class);
        when(imageLoader.get(anyString())).thenReturn(mockImageReader);
        when(arkanoid.getImageLoader()).thenReturn(imageLoader);

        controller = new InfoMenuController(menu, optionsController);
    }

    @Test
    public void testQuitAction() throws IOException, URISyntaxException, FontFormatException {
        controller.step(arkanoid, GUI.ACTION.QUIT, 0);

        verify(arkanoid).setState(any(MainMenuState.class));
    }

    @Test
    public void testOtherActions() throws Exception {
        Arkanoid arkanoidMock = mock(Arkanoid.class);
        OptionsController optionsControllerMock = mock(OptionsController.class);
        InfoMenu infoMenu = new InfoMenu();
        InfoMenuController controller = new InfoMenuController(infoMenu, optionsControllerMock);

        controller.step(arkanoidMock, GUI.ACTION.UP, 0L);

        verify(optionsControllerMock).step(arkanoidMock, GUI.ACTION.UP, 0L);
    }
}