package project.com.Control.Menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Arkanoid;
import project.com.Model.Menus.Menu;
import project.com.Model.Menus.Option;
import project.com.Model.Position;
import project.com.State.GameState;
import project.com.State.InfoMenuState;
import project.com.State.MainMenuState;
import project.com.gui.GUI;
import project.com.Viewer.Sprite.ImageLoader;                              // Importar a classe ImageLoader

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

public class OptionsControllerTest {

    private Menu menu;
    private OptionsController controller;
    private Arkanoid arkanoid;
    private ImageLoader imageLoader;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        arkanoid = mock(Arkanoid.class);
        imageLoader = mock(ImageLoader.class);

        when(arkanoid.getImageLoader()).thenReturn(imageLoader);

        controller = new OptionsController(menu);
    }

    @Test
    public void testConstructor() {
        assertNotNull(controller);
        assertEquals(menu, controller.getModel());
    }

    @Test
    public void testStepInfo() throws IOException {
        // Configurar a opção atual do menu como INFO
        Option infoOption = new Option(new Position(0, 1), Option.Type.INFO);
        when(menu.getCurrentOption()).thenReturn(infoOption);
        // Simular a ação SELECT
        controller.step(arkanoid, GUI.ACTION.SELECT, 0);
        // Verificar se o estado foi mudado para InfoMenuState
        verify(arkanoid).setState(any(InfoMenuState.class));
    }

    @Test
    public void testStepExit() throws IOException {
        // Configurar a opção atual do menu como EXIT
        Option exitOption = new Option(new Position(0, 2), Option.Type.EXIT);
        when(menu.getCurrentOption()).thenReturn(exitOption);
        // Simular a ação SELECT
        controller.step(arkanoid, GUI.ACTION.SELECT, 0);
        // Verificar se o estado foi definido como null
        verify(arkanoid).setState(null);
    }

    @Test
    public void testStepToMainMenu() throws IOException {
        // Configurar a opção atual do menu como TO_MAIN_MENU
        Option toMainMenuOption = new Option(new Position(0, 3), Option.Type.TO_MAIN_MENU);
        when(menu.getCurrentOption()).thenReturn(toMainMenuOption);
        // Simular a ação SELECT
        controller.step(arkanoid, GUI.ACTION.SELECT, 0);
        // Verificar se o estado foi mudado para MainMenuState
        verify(arkanoid).setState(any(MainMenuState.class));
    }

    @Test
    public void testStepNoAction() throws IOException {
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