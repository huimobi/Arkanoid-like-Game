package project.com.Model;

import project.com.Arkanoid;

import java.util.ArrayList;


public class MainMenu extends Menu {
    protected ArrayList<Option> createOptions() {
        ArrayList<Option> options=new ArrayList<>();
        options.add(new Option(new Position((Arkanoid.WIDTH- 5 * 7) / 2+1, (Arkanoid.HEIGHT + 7) / 2), Option.Type.START_GAME));
        options.add( new Option(new Position((Arkanoid.WIDTH- 4 * 7) / 2, ((Arkanoid.HEIGHT + 7) / 2 )+18), Option.Type.INFO));
        options.add(new Option(new Position((Arkanoid.WIDTH- 4 * 7) / 2, ((Arkanoid.HEIGHT + 7) / 2 )+36), Option.Type.EXIT));
        return options;
}
}
