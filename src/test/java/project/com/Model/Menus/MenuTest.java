package project.com.Model.Menus;

import org.junit.jupiter.api.Test;
import project.com.Model.Position;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void testGetOptions() {
        Menu menu = new Menu() {
            @Override
            protected ArrayList<Option> createOptions() {
                ArrayList<Option> options = new ArrayList<>();
                options.add(new Option(new Position(10, 20), Option.Type.START_GAME));
                options.add(new Option(new Position(30, 40), Option.Type.INFO));
                options.add(new Option(new Position(50, 60), Option.Type.EXIT));
                return options;
            }
        };

        ArrayList<Option> options = menu.getOptions();

        assertEquals(3, options.size());
        assertEquals(new Position(10, 20), options.get(0).position());
        assertEquals(Option.Type.START_GAME, options.get(0).type());
        assertEquals(new Position(30, 40), options.get(1).position());
        assertEquals(Option.Type.INFO, options.get(1).type());
        assertEquals(new Position(50, 60), options.get(2).position());
        assertEquals(Option.Type.EXIT, options.get(2).type());
    }

    @Test
    void testMoveDown() {
        Menu menu = new Menu() {
            @Override
            protected ArrayList<Option> createOptions() {
                ArrayList<Option> options = new ArrayList<>();
                options.add(new Option(new Position(10, 20), Option.Type.START_GAME));
                options.add(new Option(new Position(30, 40), Option.Type.INFO));
                options.add(new Option(new Position(50, 60), Option.Type.EXIT));
                return options;
            }
        };

        assertEquals(Option.Type.START_GAME, menu.getCurrentOption().type());

        menu.moveDown();
        assertEquals(Option.Type.INFO, menu.getCurrentOption().type());

        menu.moveDown();
        assertEquals(Option.Type.EXIT, menu.getCurrentOption().type());

        menu.moveDown();
        assertEquals(Option.Type.START_GAME, menu.getCurrentOption().type());
    }

    @Test
    void testMoveUp() {
        Menu menu = new Menu() {
            @Override
            protected ArrayList<Option> createOptions() {
                ArrayList<Option> options = new ArrayList<>();
                options.add(new Option(new Position(10, 20), Option.Type.START_GAME));
                options.add(new Option(new Position(30, 40), Option.Type.INFO));
                options.add(new Option(new Position(50, 60), Option.Type.EXIT));
                return options;
            }
        };

        assertEquals(Option.Type.START_GAME, menu.getCurrentOption().type());

        menu.moveUp();
        assertEquals(Option.Type.EXIT, menu.getCurrentOption().type());

        menu.moveUp();
        assertEquals(Option.Type.INFO, menu.getCurrentOption().type());
    }

    @Test
    void testGetNumberEntries() {
        Menu menu = new Menu() {
            @Override
            protected ArrayList<Option> createOptions() {
                ArrayList<Option> options = new ArrayList<>();
                options.add(new Option(new Position(10, 20), Option.Type.START_GAME));
                options.add(new Option(new Position(30, 40), Option.Type.INFO));
                options.add(new Option(new Position(50, 60), Option.Type.EXIT));
                return options;
            }
        };

        assertEquals(3, menu.getNumberEntries());
    }

    @Test
    void testGetCurrentOption() {
        Menu menu = new Menu() {
            @Override
            protected ArrayList<Option> createOptions() {
                ArrayList<Option> options = new ArrayList<>();
                options.add(new Option(new Position(10, 20), Option.Type.START_GAME));
                options.add(new Option(new Position(30, 40), Option.Type.INFO));
                options.add(new Option(new Position(50, 60), Option.Type.EXIT));
                return options;
            }
        };

        assertEquals(Option.Type.START_GAME, menu.getCurrentOption().type());

        menu.moveDown();
        assertEquals(Option.Type.INFO, menu.getCurrentOption().type());
    }
}