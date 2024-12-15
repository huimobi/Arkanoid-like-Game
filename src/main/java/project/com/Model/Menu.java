package project.com.Model;

import java.util.ArrayList;

public abstract class Menu {
    private final ArrayList<Option> options;
    private int currentOption = 0;

    private final ArrayList<Option> infos;

    public Menu() {
        this.options= createOptions();
        this.infos = createOptions();
    }

    protected abstract ArrayList<Option> createOptions();

    public ArrayList<Option> getOptions() {
        return options;
    }

    public ArrayList<Option> getInfo() {
        return infos;
    }

    public int getNumberEntries() {
        return this.options.size();
    }

    public void moveDown() {
        currentOption++;
        currentOption = currentOption % getNumberEntries();
    }

    public void moveUp() {
        currentOption += getNumberEntries() - 1;
        currentOption = currentOption % getNumberEntries();
    }

    public Option getCurrentOption() {
        return options.get(currentOption);
    }
}
