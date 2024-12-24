package project.com.Control.Menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Arkanoid;
import project.com.Control.Menu.MainMenuController;
import project.com.Control.Menu.OptionsController;
import project.com.Model.Menus.MainMenu;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class MainMenuControllerTest {

    private MainMenuController controller;
    private MainMenu menu;
    private OptionsController optionsController;
    private Arkanoid arkanoid;

    @BeforeEach
    public void setUp() {
        menu = mock(MainMenu.class);
        optionsController = mock(OptionsController.class);
        arkanoid = mock(Arkanoid.class);
        controller = new MainMenuController(menu, optionsController);
    }

    @Test
    public void testConstructor() {
        assertNotNull(controller);
        assertEquals(menu, controller.getModel());
    }

    @Test
    public void testActionUp() throws IOException, URISyntaxException, FontFormatException {
        controller.step(arkanoid, GUI.ACTION.UP, 0);
        verify(menu).moveUp();
        verifyNoInteractions(optionsController);
    }

    @Test
    public void testActionDown() throws IOException, URISyntaxException, FontFormatException {
        controller.step(arkanoid, GUI.ACTION.DOWN, 0);
        verify(menu).moveDown();
        verifyNoInteractions(optionsController);
    }

    @Test
    public void testActionQuit() throws IOException, URISyntaxException, FontFormatException {
        controller.step(arkanoid, GUI.ACTION.QUIT, 0);
        verify(arkanoid).setState(null);
    }

    @Test
    public void testActionDefault() throws IOException, URISyntaxException, FontFormatException {
        GUI.ACTION action = GUI.ACTION.SELECT;
        controller.step(arkanoid, action, 0);
        verify(optionsController).step(arkanoid, action, 0);
    }

    @Test
    public void testNoAction() throws IOException, URISyntaxException, FontFormatException {
        controller.step(arkanoid, null, 0);
        verifyNoInteractions(menu, optionsController, arkanoid);
    }
}