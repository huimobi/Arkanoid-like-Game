package viewer.Info;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Menus.Option;
import project.com.Model.Position;
import project.com.Viewer.Info.InformationsViewer;
import project.com.Viewer.Text.TextViewer;
import project.com.gui.GUI;

import java.io.IOException;
import static org.mockito.Mockito.*;

public class InformationsViewerTest {

    private TextViewer textviewer;
    private GUI gui;
    private InformationsViewer informationsViewer;

    @BeforeEach
    void setUp() {
        textviewer = mock(TextViewer.class);
        gui = mock(GUI.class);
        this.informationsViewer= new InformationsViewer(textviewer);
        }
        @Test
        void testDrawExitOption() throws IOException {
        Option exitOption = new Option(new Position(0, 0),Option.Type.EXIT);

        // Call the method
        informationsViewer.draw(exitOption,gui);

        // Verify null infoText behavior
        verify(textviewer, times(1)).draw(null, exitOption.position(), gui);
    }

    @Test
    void testShowSelect() throws IOException {

        Option option = new Option( new Position(10, 10),Option.Type.LEFT);
        informationsViewer.draw(option,gui);
        String color = "blue";
        String infoText = " Moves the paddle to the left";


        informationsViewer.showSelect(option, color, gui);

        verify(textviewer, times(1)).setForeground(eq(gui), eq(color), eq(option.position()), eq(infoText));
    }

}
