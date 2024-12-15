package project.com.Model;

import project.com.Arkanoid;

import java.util.ArrayList;

public class InfoMenu extends Menu {

    @Override
    protected ArrayList<Option> createOptions() {
        ArrayList<Option> infos =new ArrayList<>();
        infos.add(new Option(new Position(((Arkanoid.WIDTH - 29 * 7) + 15) / 2, ((Arkanoid.HEIGHT + 7) / 2) - 18), Option.Type.LEFT));
        infos.add(new Option(new Position(((Arkanoid.WIDTH - 30 * 7) + 15) / 2, (Arkanoid.HEIGHT + 7) / 2 ), Option.Type.RIGHT));
        infos.add(new Option(new Position(((Arkanoid.WIDTH - 26 * 7) + 15) / 2, ((Arkanoid.HEIGHT + 7) / 2 ) + 18), Option.Type.ENTER));
        infos.add(new Option(new Position(((Arkanoid.WIDTH - 32 * 7) + 15) / 2, ((Arkanoid.HEIGHT + 7) / 2) + 36), Option.Type.ESC));

        return infos;
    }

}
