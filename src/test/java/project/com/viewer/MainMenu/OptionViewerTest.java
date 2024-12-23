package project.com.viewer.MainMenu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Menus.Option;
import project.com.Model.Position;
import project.com.Viewer.MainMenu.OptionViewer;
import project.com.Viewer.Text.TextViewer;
import project.com.gui.GUI;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class OptionViewerTest {
    private TextViewer textviewer;
    private GUI gui;
    private OptionViewer optionViewer;

    @BeforeEach
    void setUp() {
        textviewer = mock(TextViewer.class);
        gui = mock(GUI.class);
        this.optionViewer= new OptionViewer(textviewer);
    }
    @Test
    void testDrawExitOption() throws IOException {
        Option exitOption = new Option(new Position(0, 0),Option.Type.EXIT);

        // Call the method
        optionViewer.draw(exitOption,gui);

        // Verify null infoText behavior
        verify(textviewer, times(1)).draw("Exit", exitOption.position(), gui);
    }

    @Test
    void testShowSelect() throws IOException {

        Option option = new Option( new Position(10, 10),Option.Type.INFO);
        optionViewer.draw(option,gui);
        String color = "blue";
        String infoText = "Info";

        optionViewer.showSelect(option, color, gui);
        verify(textviewer, times(1)).setForeground(eq(gui), eq(color), eq(option.position()), eq(infoText));
    }
}
