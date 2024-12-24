package project.com.Model.Menus;

import org.junit.jupiter.api.Test;
import project.com.Arkanoid;
import project.com.Model.Position;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InfoMenuTest {

    @Test
    void testCreateOptions() {
        Arkanoid.WIDTH = 800;
        Arkanoid.HEIGHT = 600;

        InfoMenu infoMenu = new InfoMenu();

        ArrayList<Option> options = infoMenu.createOptions();

        assertEquals(5, options.size());

        assertEquals(new Position(((800 - 29 * 7) + 15) / 2, ((600 + 7) / 2) - 22), options.get(0).position());
        assertEquals(Option.Type.LEFT, options.get(0).type());

        assertEquals(new Position(((800 - 30 * 7) + 15) / 2, ((600 + 7) / 2) - 4), options.get(1).position());
        assertEquals(Option.Type.RIGHT, options.get(1).type());

        assertEquals(new Position(((800 - 26 * 7) + 15) / 2, ((600 + 7) / 2) + 14), options.get(2).position());
        assertEquals(Option.Type.ENTER, options.get(2).type());

        assertEquals(new Position(((800 - 32 * 7) + 15) / 2, ((600 + 7) / 2) + 32), options.get(3).position());
        assertEquals(Option.Type.ESC, options.get(3).type());

        assertEquals(new Position((800 - 4 * 7) / 2, ((600 + 7) / 2) + 50), options.get(4).position());
        assertEquals(Option.Type.TO_MAIN_MENU, options.get(4).type());
    }
}