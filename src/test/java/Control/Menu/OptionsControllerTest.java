import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Arkanoid;
import project.com.Control.Menu.OptionsController;
import project.com.Model.Menu;
import project.com.Model.Option;
import project.com.Model.Position;
import project.com.State.GameState;
import project.com.State.InfoMenuState;
import project.com.State.MainMenuState;
import project.com.gui.GUI;
import project.com.Viewer.ImageLoader;                              // Importar a classe ImageLoader

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

public class OptionsControllerTest {

    private Menu menu;
    private OptionsController controller;
    private Arkanoid arkanoid;
    private ImageLoader imageLoader;                                // Declaração da variável imageLoader

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);                                    // Mock do menu para facilitar os testes
        arkanoid = mock(Arkanoid.class);                            // Mock do jogo para verificar interações
        imageLoader = mock(ImageLoader.class);                      // Mock da ImageLoader

        // Configura o mock do Arkanoid para retornar o ImageLoader mockado
        when(arkanoid.getImageLoader()).thenReturn(imageLoader);

        controller = new OptionsController(menu);
    }

    @Test
    public void testConstructor() {
        assertNotNull(controller);
        assertEquals(menu, controller.getModel());
    }

    @Test
    public void testStepStartGame() throws IOException, URISyntaxException, FontFormatException {
        Option startGameOption = new Option(new Position(0, 0), Option.Type.START_GAME);
        when(menu.getCurrentOption()).thenReturn(startGameOption);

        controller.step(arkanoid, GUI.ACTION.SELECT, 0);

        verify(arkanoid).setState(any(GameState.class));
    }

    @Test
    public void testStepInfo() throws IOException, URISyntaxException, FontFormatException {
        // Configurar a opção atual do menu como INFO
        Option infoOption = new Option(new Position(0, 1), Option.Type.INFO);
        when(menu.getCurrentOption()).thenReturn(infoOption);
        // Simular a ação SELECT
        controller.step(arkanoid, GUI.ACTION.SELECT, 0);
        // Verificar se o estado foi mudado para InfoMenuState
        verify(arkanoid).setState(any(InfoMenuState.class));
    }

    @Test
    public void testStepExit() throws IOException, URISyntaxException, FontFormatException {
        // Configurar a opção atual do menu como EXIT
        Option exitOption = new Option(new Position(0, 2), Option.Type.EXIT);
        when(menu.getCurrentOption()).thenReturn(exitOption);
        // Simular a ação SELECT
        controller.step(arkanoid, GUI.ACTION.SELECT, 0);
        // Verificar se o estado foi definido como null
        verify(arkanoid).setState(null);
    }

    @Test
    public void testStepToMainMenu() throws IOException, URISyntaxException, FontFormatException {
        // Configurar a opção atual do menu como TO_MAIN_MENU
        Option toMainMenuOption = new Option(new Position(0, 3), Option.Type.TO_MAIN_MENU);
        when(menu.getCurrentOption()).thenReturn(toMainMenuOption);
        // Simular a ação SELECT
        controller.step(arkanoid, GUI.ACTION.SELECT, 0);
        // Verificar se o estado foi mudado para MainMenuState
        verify(arkanoid).setState(any(MainMenuState.class));
    }

    @Test
    public void testStepNoAction() throws IOException, URISyntaxException, FontFormatException {
        // Configurar uma opção válida de "Start Game" com a posição (0, 0)
        Option startGameOption = new Option(new Position(0, 0), Option.Type.START_GAME);
        when(menu.getCurrentOption()).thenReturn(startGameOption);
        // Simular uma ação diferente de SELECT
        controller.step(arkanoid, GUI.ACTION.NONE, 0);
        // Verificar que o estado não foi alterado
        verify(arkanoid, never()).setState(any());
    }

    @Test
    public void testNullMenuThrowsException() {
        assertThrows(NullPointerException.class, () -> new OptionsController(null));
    }
}