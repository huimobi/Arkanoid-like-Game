import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Arkanoid;
import project.com.Control.Menu.MainMenuController;
import project.com.Control.Menu.OptionsController;
import project.com.Model.MainMenu;
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
        menu = mock(MainMenu.class);                                            // Mock do menu principal
        optionsController = mock(OptionsController.class);                      // Mock do OptionsController
        arkanoid = mock(Arkanoid.class);                                        // Mock do Arkanoid
        controller = new MainMenuController(menu, optionsController);           // Instância do controlador
    }

    @Test
    public void testConstructor() {
        assertNotNull(controller);
        assertEquals(menu, controller.getModel());
    }

    @Test
    public void testActionUp() throws IOException, URISyntaxException, FontFormatException {
        controller.step(arkanoid, GUI.ACTION.UP, 0);
        verify(menu).moveUp();                                                  // Verifica se o método moveUp foi chamado
        verifyNoInteractions(optionsController);                                // Verifica que não houve interação com o OptionsController
    }

    @Test
    public void testActionDown() throws IOException, URISyntaxException, FontFormatException {
        controller.step(arkanoid, GUI.ACTION.DOWN, 0);
        verify(menu).moveDown();                                                // Verifica se o método moveDown foi chamado
        verifyNoInteractions(optionsController);                                // Verifica que não houve interação com o OptionsController
    }

    @Test
    public void testActionQuit() throws IOException, URISyntaxException, FontFormatException {
        controller.step(arkanoid, GUI.ACTION.QUIT, 0);
        verify(arkanoid).setState(null);                                        // Verifica se o estado do jogo foi setado para null
    }

    @Test
    public void testActionDefault() throws IOException, URISyntaxException, FontFormatException {
        GUI.ACTION action = GUI.ACTION.SELECT;
        controller.step(arkanoid, action, 0);
        verify(optionsController).step(arkanoid, action, 0);                    // Verifica se a ação foi delegada para o OptionsController
    }

    @Test
    public void testNoAction() throws IOException, URISyntaxException, FontFormatException {
        controller.step(arkanoid, null, 0);
        verifyNoInteractions(menu, optionsController, arkanoid);                // Verifica que nenhum método foi chamado
    }
}