package project.com.Model;

import project.com.Arkanoid;

import java.util.ArrayList;

public class Info {
    public enum Type {LEFT, RIGHT, ENTER, ESC}

    private final Type type;

    private final Position position;

    public Info(Position position, Type type) {
        this.type = type;
        this.position = position;
        this.infos = createInfos();
    }

    public Type getType() {return type;}

    public Position getPosition() {return position;}

    private final ArrayList<Info> infos;

    public ArrayList<Info> getInfo() {return infos;}

    private ArrayList<Info> createInfos() {
        ArrayList<Info> infos=new ArrayList<>();
        infos.add(new Info(new Position((Arkanoid.WIDTH - 28 * 7) / 2, (Arkanoid.HEIGHT + 7) / 2), Info.Type.LEFT));
        infos.add(new Info(new Position((Arkanoid.WIDTH - 29 * 7) / 2, ((Arkanoid.HEIGHT + 7) / 2 )+18), Info.Type.RIGHT));
        infos.add(new Info(new Position((Arkanoid.WIDTH - 38 * 7) / 2, ((Arkanoid.HEIGHT + 7) / 2 )+36), Info.Type.ENTER));
        infos.add(new Info(new Position(((Arkanoid.WIDTH - 31 * 7) + 15) / 2, ((Arkanoid.HEIGHT + 7) / 2)+54), Info.Type.ESC));
        return infos;
    }


}
