package project.com.Model.Menus;

import org.junit.jupiter.api.Test;
import project.com.Arkanoid;
import project.com.Model.Position;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuTest {

    @Test
    void testCreateOptions() {
        Arkanoid.WIDTH = 800;
        Arkanoid.HEIGHT = 600;

        MainMenu mainMenu = new MainMenu();

        ArrayList<Option> options = mainMenu.createOptions();

        assertEquals(3, options.size());

        assertEquals(new Position((800 - 5 * 7) / 2 + 1, (600 + 7) / 2), options.get(0).position());
        assertEquals(Option.Type.START_GAME, options.get(0).type());

        assertEquals(new Position((800 - 4 * 7) / 2, ((600 + 7) / 2) + 18), options.get(1).position());
        assertEquals(Option.Type.INFO, options.get(1).type());

        assertEquals(new Position((800 - 4 * 7) / 2, ((600 + 7) / 2) + 36), options.get(2).position());
        assertEquals(Option.Type.EXIT, options.get(2).type());
    }
}