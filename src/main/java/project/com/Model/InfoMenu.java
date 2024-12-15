package project.com.Model;

import project.com.Arkanoid;

import java.util.ArrayList;

public class InfoMenu extends Menu {

    @Override
    protected ArrayList<Option> createOptions() {
        ArrayList<Option> infos =new ArrayList<>();
        infos.add(new Option(new Position(((Arkanoid.WIDTH - 29 * 7) + 15) / 2, ((Arkanoid.HEIGHT + 7) / 2) - 22), Option.Type.LEFT));
        infos.add(new Option(new Position(((Arkanoid.WIDTH - 30 * 7) + 15) / 2, ((Arkanoid.HEIGHT + 7) / 2 ) - 4), Option.Type.RIGHT));
        infos.add(new Option(new Position(((Arkanoid.WIDTH - 26 * 7) + 15) / 2, ((Arkanoid.HEIGHT + 7) / 2 ) + 14), Option.Type.ENTER));
        infos.add(new Option(new Position(((Arkanoid.WIDTH - 32 * 7) + 15) / 2, ((Arkanoid.HEIGHT + 7) / 2) + 32), Option.Type.ESC));
        infos.add(new Option(new Position((Arkanoid.WIDTH - 4 * 7) / 2, ((Arkanoid.HEIGHT + 7) / 2) + 50), Option.Type.TO_MAIN_MENU));
        return infos;
    }

}
