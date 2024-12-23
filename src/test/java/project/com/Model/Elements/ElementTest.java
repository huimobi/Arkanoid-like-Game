package project.com.Model.Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.com.Model.Position;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    static class TestElement extends Element {
        public TestElement(Position position, int width, int height) {
            super(position, width, height);
        }
    }

    private Element element;
    private Position mockPosition;

    @BeforeEach
    void setUp() {
        mockPosition = Mockito.mock(Position.class);
        Mockito.when(mockPosition.getX()).thenReturn(10);
        Mockito.when(mockPosition.getY()).thenReturn(20);

        element = new TestElement(mockPosition, 100, 200);
    }

    @Test
    void testConstructor_initializesHitBoxCorrectly() {
        assertEquals(10, element.getPosition().getX());
        assertEquals(20, element.getPosition().getY());
        assertEquals(100, element.getWidth());
        assertEquals(200, element.getHeight());
    }

    @Test
    void testSetPosition_updatesHitBoxLocation() {
        Mockito.when(mockPosition.getX()).thenReturn(30);
        Mockito.when(mockPosition.getY()).thenReturn(40);

        element.setPosition(mockPosition);

        assertEquals(30, element.getPosition().getX());
        assertEquals(40, element.getPosition().getY());
    }

    @Test
    void testSetWidth_updatesHitBoxWidth() {
        element.setWidth(150);
        assertEquals(150, element.getWidth());
        assertEquals(200, element.getHeight());
    }

    @Test
    void testSetSize_updatesHitBoxSize() {
        Dimension newSize = new Dimension(300, 400);
        element.setSize(newSize);

        assertEquals(300, element.getWidth());
        assertEquals(400, element.getHeight());
    }

    @Test
    void testGetHitBox_returnsCorrectHitBox() {
        Rectangle hitBox = element.getHitBox();

        assertEquals(10, hitBox.x);
        assertEquals(20, hitBox.y);
        assertEquals(100, hitBox.width);
        assertEquals(200, hitBox.height);
    }
}