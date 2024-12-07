package project.com;

import com.googlecode.lanterna.input.KeyStroke;
import project.com.Model.Position;
import project.com.Viewer.PNGReader;
import project.com.Viewer.WriteText;
import project.com.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class MainMenu extends Menu {

    private WriteText cur_selection; //PLAY is the option by default
    private boolean in_menu=true; //checks if the game is in the Menu (MAYBE THIS CAN BE IMPLEMENTED IN ARKANOID CLASS (?))
    private final ArrayList<WriteText> options=new ArrayList<>();
    private final GUI gui;

    public MainMenu(GUI gui) throws IOException, NullPointerException {
        this.gui=gui;
        options.add(new WriteText(gui,"Play"));
        options.add(new WriteText(gui,"Settings"));
        options.add(new WriteText(gui,"Info"));
        options.add(new WriteText(gui,"exit"));
        this.cur_selection=options.getFirst(); //first option as default
        draw();
        while (in_menu) {
            KeyStroke key = gui.readInput();
            processKey(key);
        }
    }

    //draws the Main Menu
    private void draw() throws IOException {
        gui.clear();
        PNGReader background_image= new PNGReader("Menu/background.png");
        background_image.draw(this.gui,new Position(0,0));


        //print "play"
        Position p_position= new Position((gui.getWidth()-4*7)/2,(gui.getHeight()+7)/2);
        for(WriteText option: options){
            option.drawText(this.gui,new Position((gui.getWidth()-option.getLength()*7)/2, p_position.getY()));
            p_position.setY(p_position.getY()+18);

        }

        //Arkanoid LOGO
        PNGReader arkanoid=new PNGReader("Menu/arkanoid.png");
        arkanoid.draw(this.gui,new Position(70,36));

        options.getFirst().setForegroundColor(gui,"#ff7129"); //shows first option selected as default
        this.gui.refresh();
    }



    private void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp -> previous_option();
            case ArrowDown -> next_option();
            case Enter -> {select() ;in_menu=false;}
            case EOF -> {gui.close(); in_menu=false;}
            }

    }

    //previous_option
    void previous_option() throws IOException {
        int index=options.indexOf(cur_selection);
        if(index==0) return;//checks if the cur_option is the first in the menu

        options.get(index).setForegroundDefault(gui);
        gui.refresh();
        options.get(index-1).setForegroundColor(gui,"#ff7129");
        cur_selection=options.get(index-1);
        gui.refresh();

    }

    //next_option
    void next_option() throws IOException {
        int index=options.indexOf(cur_selection);
        if(index==options.size()-1) return; // checks if the cur_option is the last in the menu

        options.get(index).setForegroundDefault(gui);
        gui.refresh();
        options.get(index+1).setForegroundColor(gui,"#ff7129");
        cur_selection=options.get(index+1);
        gui.refresh();

    }

    //select option
    private void select() throws IOException {
        switch (cur_selection.getString()){
            case "PLAY"-> {
                new DrawLevel(gui);}//Game();
            case "SETTINGS"-> System.out.print("SETTINGS"); // Settings();
            case "INFO" -> System.out.print("INFO"); //Info();
            case "EXIT"-> gui.close();
        }
    }
}
