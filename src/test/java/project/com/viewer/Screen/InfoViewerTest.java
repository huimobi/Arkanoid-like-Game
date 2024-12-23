package project.com.viewer.Screen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;
import project.com.Model.Menus.InfoMenu;

import project.com.Viewer.Info.*;
import project.com.Viewer.MainMenu.MainMenuBackgroundViewer;
import project.com.Viewer.Screen.GameViewer;
import project.com.Viewer.Screen.InfoViewer;
import project.com.Viewer.Text.TextViewer;
import project.com.Viewer.ViewerProvider;
import project.com.gui.GUI;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class InfoViewerTest {
    private ViewerProvider viewerProvider;
    private GUI gui;
    private InfoMenu infoMenu;
    private TextViewer textViewer;
    private InformationsViewer informationsViewer;
    private MainMenuBackgroundViewer backgroundViewer;
    private project.com.Viewer.Info.WordInfoViewer wordInfoViewer;
    private LeftViewer leftViewer;
    private RightViewer rightViewer;
    private EnterViewer enterViewer;
    private ESCViewer escViewer;

    @BeforeEach
    public void setup() {
        this.informationsViewer = mock(InformationsViewer.class);
        this.backgroundViewer = mock(MainMenuBackgroundViewer.class);
        this.wordInfoViewer = mock(WordInfoViewer.class);
        this.leftViewer = mock(LeftViewer.class);
        this.rightViewer = mock(RightViewer.class);
        this.enterViewer = mock(EnterViewer.class);
        this.escViewer = mock(ESCViewer.class);
        this.viewerProvider=mock(ViewerProvider.class);
        this.gui=mock(GUI.class);
        this.infoMenu= mock(InfoMenu.class);
        this.textViewer=mock(TextViewer.class);

        when(viewerProvider.getRightViewer()).thenReturn(rightViewer);
        when(viewerProvider.getLeftViewer()).thenReturn(leftViewer);
        when(viewerProvider.getWordInfoViewer()).thenReturn(wordInfoViewer);
        when(viewerProvider.getEscViewer()).thenReturn(escViewer);
        when(viewerProvider.getEnterViewer()).thenReturn(enterViewer);
        when(viewerProvider.getTextViewer()).thenReturn(textViewer);
        when(viewerProvider.getInfosViewer()).thenReturn(informationsViewer);
        when(viewerProvider.getMainMenuBackground()).thenReturn(backgroundViewer);
    }


    @Test
    public void testDraw() throws IOException {
        InfoViewer infoViewer=new InfoViewer(infoMenu,viewerProvider);
        when(infoMenu.getInfo()).thenReturn(new ArrayList<>());

        infoViewer.draw(gui);

        verify(gui,times(1)).clear();
        verify(backgroundViewer).draw(eq(gui));
        verify(rightViewer).draw(eq(gui),any(Position.class));
        verify(leftViewer).draw(eq(gui),any(Position.class));
        verify(enterViewer).draw(eq(gui),any(Position.class));
        verify(escViewer).draw(eq(gui),any(Position.class));
        verify(wordInfoViewer).draw(eq(gui),any(Position.class));
        verify(gui).refresh();
    }


}
