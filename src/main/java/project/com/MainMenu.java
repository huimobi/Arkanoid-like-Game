package project.com;

import com.googlecode.lanterna.input.KeyStroke;
import project.com.Model.Option;
import project.com.Model.Position;
import project.com.Viewer.PNGReader;
import project.com.Viewer.WriteChar;

import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainMenu{
    /*private WriteText cur_selection; //PLAY is the option by default
    private boolean in_menu = true;
    private final ArrayList<WriteText> options = new ArrayList<>();
    private final GUI gui;

    public MainMenu(GUI gui) throws IOException, NullPointerException {
        this.gui = gui;
        options.add(new WriteText("Play"));
        options.add(new WriteText("Settings"));
        options.add(new WriteText("Info"));
        options.add(new WriteText("exit"));
        this.cur_selection = options.getFirst(); //first option as default
        draw();
        run();
    }

    private void run() throws IOException {
        while (in_menu) {
            KeyStroke key = gui.readInput();
            processKey(key);
        }
    }

    //draws the Main Menu
    private void draw() throws IOException {
        gui.clear();
        PNGReader background_image = new PNGReader("Menu/background");
        background_image.draw(this.gui, new Position(0, 0));


        //print "play"
        Position p_position = new Position((gui.getWidth() - 4 * 7) / 2, (gui.getHeight() + 7) / 2);
        for (WriteText option : options) {
            option.drawText(this.gui, new Position((gui.getWidth() - option.getLength() * 7) / 2, p_position.getY()));
            p_position.setY(p_position.getY() + 18);

        }

        //Arkanoid LOGO
        PNGReader arkanoid = new PNGReader("Menu/arkanoid");
        arkanoid.draw(this.gui, new Position(70, 36));

        options.getFirst().setForegroundColor(gui, "#ff7129"); //shows first option selected as default
        this.gui.refresh();
    }


    private void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp -> previous_option();
            case ArrowDown -> next_option();
            case Enter -> {
                select();
                in_menu = false;
            }
            case EOF -> {
                gui.close();
                in_menu = false;
            }
        }

    }

    //previous_option
    void previous_option() throws IOException {
        int index = options.indexOf(cur_selection);
        if (index == 0) return;//checks if the cur_option is the first in the menu

        options.get(index).setForegroundDefault(gui);
        gui.refresh();
        options.get(index - 1).setForegroundColor(gui, "#ff7129");
        cur_selection = options.get(index - 1);
        gui.refresh();

    }

    //next_option
    void next_option() throws IOException {
        int index = options.indexOf(cur_selection);
        if (index == options.size() - 1) return; // checks if the cur_option is the last in the menu

        options.get(index).setForegroundDefault(gui);
        gui.refresh();
        options.get(index + 1).setForegroundColor(gui, "#ff7129");
        cur_selection = options.get(index + 1);
        gui.refresh();

    }

    //select option
    private void select() throws IOException {
        switch (cur_selection.getString()) {
            case "PLAY" -> {
                new DrawLevel(gui);
            }//Game();
            case "SETTINGS" -> System.out.print("SETTINGS"); // Settings();
            case "INFO" -> System.out.print("INFO"); //Info();
            case "EXIT" -> gui.close();
        }
    }*/
    private final ArrayList<Option> options;
    private int currentOption = 0;

    public MainMenu() {
       this.options= createOptions();
    }


    public ArrayList<Option> getOptions() {
        return options;
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

    private ArrayList<Option> createOptions() {
        ArrayList<Option> options=new ArrayList<>();
        options.add(new Option(new Position((Arkanoid.WIDTH- 5 * 7) / 2+1, (Arkanoid.HEIGHT + 7) / 2), Option.Type.START_GAME));
        options.add( new Option(new Position((Arkanoid.WIDTH- 4 * 7) / 2, ((Arkanoid.HEIGHT + 7) / 2 )+18), Option.Type.INFO));
        options.add(new Option(new Position((Arkanoid.WIDTH- 4 * 7) / 2, ((Arkanoid.HEIGHT + 7) / 2 )+36), Option.Type.EXIT));
        return options;
}
}
