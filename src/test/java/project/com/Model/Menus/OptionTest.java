package project.com.Model.Menus;

import org.junit.jupiter.api.Test;
import project.com.Model.Position;

import static org.junit.jupiter.api.Assertions.*;

class OptionTest {

    @Test
    void testOptionConstructorAndAccessors() {
        Position position = new Position(10, 20);
        Option.Type type = Option.Type.START_GAME;

        Option option = new Option(position, type);

        assertEquals(position, option.position());
        assertEquals(type, option.getType());
    }

    @Test
    void testOptionEquality() {
        Position position1 = new Position(10, 20);
        Position position2 = new Position(30, 40);
        Option.Type type1 = Option.Type.START_GAME;
        Option.Type type2 = Option.Type.EXIT;

        Option option1 = new Option(position1, type1);
        Option option2 = new Option(position1, type1);
        Option option3 = new Option(position2, type2);

        assertEquals(option1, option2);

        assertNotEquals(option1, option3);
    }

    @Test
    void testOptionHashCode() {
        Position position = new Position(10, 20);
        Option.Type type = Option.Type.START_GAME;

        Option option1 = new Option(position, type);
        Option option2 = new Option(position, type);

        assertEquals(option1.hashCode(), option2.hashCode());
    }

    @Test
    void testOptionToString() {
        Position position = new Position(10, 20);
        Option.Type type = Option.Type.START_GAME;

        Option option = new Option(position, type);

        String expected = "Option[position=(10, 20), type=START_GAME]";
        assertEquals(expected, option.toString());
    }
}