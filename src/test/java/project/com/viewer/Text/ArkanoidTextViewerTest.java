package project.com.viewer.Text;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.Model.Position;
import project.com.Viewer.Text.ArkanoidTextViewer;
import project.com.Viewer.Text.TextViewer;
import project.com.gui.GUI;

import java.io.IOException;


import static org.mockito.Mockito.*;

public class ArkanoidTextViewerTest {

    private TextViewer textViewer;
    private GUI gui;

    @BeforeEach
    public void setUp() {
        textViewer = new ArkanoidTextViewer();
        gui = mock(GUI.class);

    }

    @Test
    public void testDrawSingleCharacterNotInitialized() throws IOException {
        char character = 'A';
        Position position = new Position(10, 20);
        String color = "#FF0000";

        textViewer.draw(character, position, color, gui);

        verify(gui, times(1)).changedDrawImage(any(), eq(position),any(),eq(new TextColor.RGB(255,0,0)));
    }

    @Test
    public void testDrawSingleCharacterSamePositionTwice() throws IOException {
        char character = 'B';
        Position position = new Position(10, 20);
        String color1 = "#FF0000";
        String color2 = "#00FF00";

        // Act
        textViewer.draw(character, position, color1, gui);
        textViewer.draw(character, position, color2, gui);

        // Assert
        verify(gui, times(1)).changedDrawImage(any(), eq(position),any(),eq(new TextColor.RGB(255,0,0)));
        verify(gui,times(1)).changedDrawImage(any(),eq(position),any(),eq(new TextColor.RGB(0,255,0)));
    }

    @Test
    public void testDrawSingleCharacterDifferentPosition() throws IOException {
        char character = 'B';
        Position position1 = new Position(10, 20);
        Position position2 = new Position(20,10);
        String color = "#FF0000";

        textViewer.draw(character, position1, color, gui);
        textViewer.draw(character, position2, color, gui);

        verify(gui, times(1)).changedDrawImage(any(), eq(position1),any(),eq(new TextColor.RGB(255,0,0)));
        verify(gui,times(1)).changedDrawImage(any(),eq(position2),any(),eq(new TextColor.RGB(255,0,0)));
    }

    @Test
    public void testDrawString() throws IOException {
        String text = "ABC";
        Position position = new Position(0, 0);
        String color = "#00FF00";

        textViewer.draw(text, position, color, gui);

        verify(gui, times(3)).changedDrawImage(any(), any(Position.class),any(),eq(new TextColor.RGB(0,255,0)));
    }

    @Test
    public void testDrawStringWithDefaultColor() throws IOException {
        String text = "DEF";
        Position position = new Position(0, 0);

        textViewer.draw(text, position, gui);

        verify(gui, times(3)).changedDrawImage(any(),any(),any(),eq(TextColor.ANSI.WHITE_BRIGHT));

    }
    @Test
    public void testSetForegroundWithSpace() throws IOException {
        String text = "ABC DEF";
        Position position = new Position(0, 0);
        String color ="#000000";

        textViewer.setForeground(gui,color,position,text);

        verify(gui, times(6)).changedDrawImage(any(),any(),any(),eq(new TextColor.RGB(0,0,0)));
    }
}

