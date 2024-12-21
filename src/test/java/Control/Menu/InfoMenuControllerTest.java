import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Arkanoid;
import project.com.Control.Menu.InfoMenuController;
import project.com.Control.Menu.OptionsController;
import project.com.Model.Menus.InfoMenu;
import project.com.Model.Menus.Option;
import project.com.State.MainMenuState;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Sprite.ImageReader;
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
        // Mocks
        menu = mock(InfoMenu.class);                                        // Mock do modelo InfoMenu
        optionsController = mock(OptionsController.class);                  // Mock do OptionsController
        arkanoid = mock(Arkanoid.class);                                    // Mock do Arkanoid
        ImageLoader imageLoader = mock(ImageLoader.class);                  // Mock do ImageLoader

        // Criar um mock de ImageReader
        ImageReader mockImageReader = mock(ImageReader.class);
        when(imageLoader.get(anyString())).thenReturn(mockImageReader);     // Comportamento do mock

        // Definir o mock de Arkanoid para retornar o ImageLoader
        when(arkanoid.getImageLoader()).thenReturn(imageLoader);

        // Atribuir o controlador
        controller = new InfoMenuController(menu, optionsController);       // Instância do controlador com mocks
    }

    @Test
    public void testSelectToMainMenu() throws IOException, URISyntaxException, FontFormatException {
        // Criar um mock para o retorno de getCurrentInfo()
        Option mockOption = mock(Option.class);
        when(mockOption.getType()).thenReturn(Option.Type.TO_MAIN_MENU);
        when(menu.getCurrentInfo()).thenReturn(mockOption);

        // Executar o método
        controller.step(arkanoid, GUI.ACTION.SELECT, 0);

        // Verificar se o estado foi alterado
        verify(arkanoid).setState(any(MainMenuState.class));
    }

    @Test
    public void testQuitAction() throws IOException, URISyntaxException, FontFormatException {
        controller.step(arkanoid, GUI.ACTION.QUIT, 0);

        // Verificar se o estado foi alterado para MainMenuState no caso de QUIT
        verify(arkanoid).setState(any(MainMenuState.class));
    }

    @Test
    public void testOtherActions() throws Exception {
        // Configurar mocks e preparar objetos necessários
        Arkanoid arkanoidMock = mock(Arkanoid.class);
        OptionsController optionsControllerMock = mock(OptionsController.class);
        InfoMenu infoMenu = new InfoMenu();
        InfoMenuController controller = new InfoMenuController(infoMenu, optionsControllerMock);

        // Simular a ação que deve levar ao método step de optionsController
        controller.step(arkanoidMock, GUI.ACTION.UP, 0L);                   // Ação que deve chamar optionsController.step

        // Verificar se o método foi chamado corretamente
        verify(optionsControllerMock).step(arkanoidMock, GUI.ACTION.UP, 0L);
    }

/*
    @Test
    public void testNullAction() throws IOException, URISyntaxException, FontFormatException {
        // Criar o mock de OptionsController
        OptionsController optionsControllerMock = mock(OptionsController.class);

        // Criar a instância de InfoMenuController com os dois parâmetros necessários
        InfoMenuController controller = new InfoMenuController(new InfoMenu(), optionsControllerMock);

        // Simular uma ação no controlador, por exemplo, uma ação de "SELECT"
        controller.step(mock(Arkanoid.class), GUI.ACTION.SELECT, 0L);

        // Verificar se o método step de OptionsController foi chamado, caso aplicável
        verify(optionsControllerMock).step(mock(Arkanoid.class), GUI.ACTION.SELECT, 0L);

    }

 */
}