package project.com.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.com.Model.Position;
import project.com.gui.GUI;
import project.com.gui.LanternaGUI;
import project.com.gui.ScreenCreator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LanternaGUITest {
    private Screen screenMock;
    private LanternaGUI lanternaGUI;
    private BufferedImage image;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        ScreenCreator screenCreatorMock = mock(ScreenCreator.class);
        screenMock = mock(Screen.class);
        when(screenCreatorMock.createScreen()).thenReturn(screenMock);
        when(screenCreatorMock.getWidth()).thenReturn(100);
        when(screenCreatorMock.getHeight()).thenReturn(50);
        lanternaGUI = new LanternaGUI(screenCreatorMock);

        image=new BufferedImage(2, 2, BufferedImage.TYPE_INT_ARGB);
        image.setRGB(0, 0, new Color(255, 0, 0).getRGB());
        image.setRGB(1, 0, new Color(0, 255, 0).getRGB());
        image.setRGB(0, 1, new Color(0, 0, 255).getRGB());
        image.setRGB(1, 1, new Color(0, 0, 0, 0).getRGB()); // transparent

    }


    @Test
    void testDrawPixel() {
        Position position = new Position(10, 10);
        TextColor color = new TextColor.RGB(255, 0, 0);
        TextGraphics textGraphicsMock = mock(TextGraphics.class);

        when(screenMock.newTextGraphics()).thenReturn(textGraphicsMock);

        lanternaGUI.drawPixel(position, color);

        verify(textGraphicsMock).setBackgroundColor(color);
        verify(textGraphicsMock).setCharacter(10, 10, ' ');
    }

    @Test
    void testDrawImage() {
        Position position = new Position(1, 1);    //when it is a transparent pixel should do nothing
        LanternaGUI guiSpy = Mockito.spy(lanternaGUI);
        doNothing().when(guiSpy).drawPixel(any(Position.class), any(TextColor.class));
        guiSpy.drawImage(image, position);
        verify(guiSpy, times(3)).drawPixel(any(Position.class), any(TextColor.class));
    }

    @Test
    void testChangedDrawImage() {
        Position position = new Position(1, 1);
        Position pixelPosition = new Position(0, 0);
        TextColor differentColor = new TextColor.RGB(255, 255, 255);
        ArrayList<Position> pixels = new ArrayList<>();
        pixels.add(pixelPosition);

        LanternaGUI guiSpy = Mockito.spy(lanternaGUI);
        doNothing().when(guiSpy).drawPixel(any(Position.class), any(TextColor.class));

        guiSpy.changedDrawImage(image, position, pixels, differentColor);

        verify(guiSpy, times(3)).drawPixel(any(Position.class), any(TextColor.class));
    }

    @Test
    void testGetNextAction() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowDown);
        when(screenMock.pollInput()).thenReturn(keyStroke);
        GUI.ACTION action = lanternaGUI.getNextAction();
        assertEquals(GUI.ACTION.DOWN, action);
    }

    @Test
    void testClear() {
        lanternaGUI.clear();
        verify(screenMock).clear();
    }

    @Test
    void testRefresh() throws IOException {
        lanternaGUI.refresh();
        verify(screenMock).refresh();
    }

    @Test
    void testClose() throws IOException {
        lanternaGUI.close();
        verify(screenMock).close();
    }
}
