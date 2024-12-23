package project.com.Model.Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.com.Model.Position;

import static org.junit.jupiter.api.Assertions.*;

class MovableTest {

    static class TestMovable extends Movable {
        public TestMovable(Position position, int width, int height, Position velocity) {
            super(position, width, height, velocity);
        }
    }

    private Movable movable;
    private Position mockVelocity;

    @BeforeEach
    void setUp() {
        Position mockPosition = Mockito.mock(Position.class);
        mockVelocity = Mockito.mock(Position.class);

        Mockito.when(mockPosition.getX()).thenReturn(10);
        Mockito.when(mockPosition.getY()).thenReturn(20);
        Mockito.when(mockVelocity.getX()).thenReturn(5);
        Mockito.when(mockVelocity.getY()).thenReturn(-3);

        movable = new TestMovable(mockPosition, 100, 200, mockVelocity);
    }

    @Test
    void testConstructor_initializesCorrectly() {
        assertEquals(10, movable.getPosition().getX());
        assertEquals(20, movable.getPosition().getY());
        assertEquals(5, movable.getVelocity().getX());
        assertEquals(-3, movable.getVelocity().getY());
    }

    @Test
    void testMove_updatesPositionBasedOnVelocity() {
        movable.move();

        assertEquals(15, movable.getPosition().getX());
        assertEquals(17, movable.getPosition().getY());
    }

    @Test
    void testSetVelocity_updatesVelocity() {
        Position newVelocity = Mockito.mock(Position.class);
        Mockito.when(newVelocity.getX()).thenReturn(-2);
        Mockito.when(newVelocity.getY()).thenReturn(4);

        movable.setVelocity(newVelocity);

        assertEquals(-2, movable.getVelocity().getX());
        assertEquals(4, movable.getVelocity().getY());
    }

    @Test
    void testIsMovingUpLeft_returnsTrueWhenMovingUpLeft() {
        Mockito.when(mockVelocity.getX()).thenReturn(-1);
        Mockito.when(mockVelocity.getY()).thenReturn(-1);

        assertTrue(movable.isMovingUpLeft());
    }

    @Test
    void testIsMovingUpLeft_returnsFalseWhenNotMovingUpLeft() {
        Mockito.when(mockVelocity.getX()).thenReturn(1);
        Mockito.when(mockVelocity.getY()).thenReturn(-1);

        assertFalse(movable.isMovingUpLeft());
    }

    @Test
    void testIsMovingDownLeft_returnsTrueWhenMovingDownLeft() {
        Mockito.when(mockVelocity.getX()).thenReturn(-1);
        Mockito.when(mockVelocity.getY()).thenReturn(1);

        assertTrue(movable.isMovingDownLeft());
    }

    @Test
    void testIsMovingDownRight_returnsTrueWhenMovingDownRight() {
        Mockito.when(mockVelocity.getX()).thenReturn(1);
        Mockito.when(mockVelocity.getY()).thenReturn(1);

        assertTrue(movable.isMovingDownRight());
    }
}
