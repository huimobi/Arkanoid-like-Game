package project.com.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testConstructorAndGetters() {
        Position position = new Position(5, 10);
        assertEquals(5, position.getX());
        assertEquals(10, position.getY());
    }

    @Test
    void testSetters() {
        Position position = new Position(0, 0);
        position.setX(8);
        position.setY(15);
        assertEquals(8, position.getX());
        assertEquals(15, position.getY());
    }

    @Test
    void testEqualsSameObject() {
        Position position = new Position(3, 4);
        assertTrue(position.equals(position)); // Mesmo objeto
    }

    @Test
    void testEqualsDifferentObjectSameValues() {
        Position position1 = new Position(3, 4);
        Position position2 = new Position(3, 4);
        assertTrue(position1.equals(position2));
    }

    @Test
    void testEqualsDifferentObjectDifferentValues() {
        Position position1 = new Position(3, 4);
        Position position2 = new Position(5, 6);
        assertFalse(position1.equals(position2));
    }

    @Test
    void testEqualsWithNull() {
        Position position = new Position(3, 4);
        assertFalse(position.equals(null));
    }

    @Test
    void testEqualsWithDifferentClass() {
        Position position = new Position(3, 4);
        String other = "not a Position";
        assertFalse(position.equals(other));
    }

    @Test
    void testToString() {
        Position position = new Position(7, 8);
        assertEquals("(7, 8)", position.toString());
    }
}