package project.com.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.com.gui.LanternaScreenCreator;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LanternaScreenCreatorTest {
    private DefaultTerminalFactory factory;
    private TerminalSize terminalSize;
    private LanternaScreenCreator screenCreator;

    @BeforeEach
    void setUp() {
        factory = mock(DefaultTerminalFactory.class);
        terminalSize = mock(TerminalSize.class);
        when(terminalSize.getRows()).thenReturn(1000);
        when(terminalSize.getColumns()).thenReturn(1000);

        screenCreator = new LanternaScreenCreator(factory, terminalSize);
    }

    @Test
    public void constructor() {
        LanternaScreenCreator screenCreator = new LanternaScreenCreator(factory, terminalSize);
        int width = screenCreator.getWidth();
        assertNotEquals(0, width);
        int height = screenCreator.getHeight();
        assertNotEquals(0, height);

        verify(factory, atLeastOnce()).setInitialTerminalSize(terminalSize);
        verify(factory, atLeastOnce()).setForceAWTOverSwing(true);
        assertEquals(terminalSize.getColumns(), width);
        assertEquals(terminalSize.getRows(), height);
    }

    @Test
    void testGetFontSize() {
        Rectangle terminalBounds = new Rectangle(1600, 900);
        double maxFontWidth = terminalBounds.getWidth() / terminalSize.getColumns();
        double maxFontHeight = terminalBounds.getHeight() / terminalSize.getRows();
        int expectedFontSize = (int) Math.min(maxFontWidth, maxFontHeight);
        int actualFontSize = screenCreator.getFontSize(terminalBounds);
        assertEquals(expectedFontSize, actualFontSize);
    }

    @Test
    void testGetFontSize_SmallResolution() {
        Rectangle terminalBounds = new Rectangle(800, 600);
        double maxFontWidth = terminalBounds.getWidth() / terminalSize.getColumns();
        double maxFontHeight = terminalBounds.getHeight() / terminalSize.getRows();
        int expectedFontSize = (int) Math.min(maxFontWidth, maxFontHeight);
        int actualFontSize = screenCreator.getFontSize(terminalBounds);
        assertEquals(expectedFontSize, actualFontSize);
    }

    @Test
    void testGetFontSize_LargeResolution() {
        Rectangle terminalBounds = new Rectangle(3840, 2160);
        double maxFontWidth = terminalBounds.getWidth() / terminalSize.getColumns();
        double maxFontHeight = terminalBounds.getHeight() / terminalSize.getRows();
        int expectedFontSize = (int) Math.min(maxFontWidth, maxFontHeight);
        int actualFontSize = screenCreator.getFontSize(terminalBounds);
        assertEquals(expectedFontSize, actualFontSize);
    }

}
