package project.com.viewer.Screen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Menus.MainMenu;
import project.com.Model.Position;
import project.com.Viewer.MainMenu.LogoViewer;
import project.com.Viewer.MainMenu.MainMenuBackgroundViewer;
import project.com.Viewer.Screen.MainMenuViewer;
import project.com.Viewer.Text.TextViewer;
import project.com.Viewer.ViewerProvider;
import project.com.gui.GUI;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class MainMenuViewerTest {
    private ViewerProvider viewerProvider;
    private GUI gui;
    private MainMenu mainMenu;
    private MainMenuBackgroundViewer backgroundViewer;
    private LogoViewer logoViewer;


    @BeforeEach
    public void setup() {
        this.mainMenu=mock(MainMenu.class);
        this.backgroundViewer = mock(MainMenuBackgroundViewer.class);
        this.viewerProvider=mock(project.com.Viewer.ViewerProvider.class);
        this.gui=mock(GUI.class);
        TextViewer textViewer = mock(TextViewer.class);
        this.logoViewer=mock(LogoViewer.class);

        when(viewerProvider.getTextViewer()).thenReturn(textViewer);
        when(viewerProvider.getMainMenuBackground()).thenReturn(backgroundViewer);
        when(viewerProvider.getLogoViewer()).thenReturn(logoViewer);
    }


    @Test
    public void testDraw() throws IOException {
        MainMenuViewer mainMenuViewer=new MainMenuViewer(mainMenu,viewerProvider);
        when(mainMenu.getOptions()).thenReturn(new ArrayList<>());

        mainMenuViewer.draw(gui);

        verify(gui,times(1)).clear();
        verify(backgroundViewer).draw(eq(gui));
        verify(logoViewer).draw(eq(gui),any(Position.class));
        verify(gui).refresh();
    }
}
