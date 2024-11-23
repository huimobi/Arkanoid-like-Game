package project.com;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static project.com.Arkanoid.*;


class MainMenu {

    private WriteText cur_selection; //PLAY is the option by default
    private boolean in_menu=true; //checks if the game is in the Menu (MAYBE THIS CAN BE IMPLEMENTED IN ARKANOID CLASS (?))
    private final ArrayList<WriteText> options=new ArrayList<>();

    public MainMenu() throws IOException, NullPointerException {
        options.add(new WriteText("Play"));
        options.add(new WriteText("Settings"));
        options.add(new WriteText("Info"));
        options.add(new WriteText("exit"));
        this.cur_selection=options.getFirst(); //first option as default
        draw(screen);
        while (in_menu) {
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }

    //draws the Main Menu
    private void draw(Screen screen) throws IOException {
        screen.clear();
        PNG_draw background_image= new PNG_draw("Menu/background.png");
        background_image.drawImage(new Position(0,0));


        //print "play"
        Position p_position= new Position((width-4*7)/2,(height+7)/2);
        for(WriteText option: options){
            option.drawText(new Position((width-option.getLenght()*7)/2, p_position.getY()));
            p_position.setY(p_position.getY()+18);

        }

        options.getFirst().setForegroundColor("#ff7129"); //shows first option selected as default
        screen.refresh();
    }



    private void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp -> previous_option();
            case ArrowDown -> next_option();
            case Enter -> {select() ;in_menu=false;}
            case EOF -> {screen.close(); in_menu=false;}
            }

    }

    //previous_option
    void previous_option() throws IOException {
        int index=options.indexOf(cur_selection);
        if(index==0) return;//checks if the cur_option is the first in the menu

        options.get(index).setForegroundDefault();
        screen.refresh();
        options.get(index-1).setForegroundColor("#ff7129");
        cur_selection=options.get(index-1);
        screen.refresh();

    }

    //next_option
    void next_option() throws IOException {
        int index=options.indexOf(cur_selection);
        if(index==options.size()-1) return; // checks if the cur_option is the last in the menu

        options.get(index).setForegroundDefault();
        screen.refresh();
        options.get(index+1).setForegroundColor("#ff7129");
        cur_selection=options.get(index+1);
        screen.refresh();

    }

    //select option
    private void select() throws IOException {
        switch (cur_selection.getString()){
            case "PLAY"-> {draw_Level level = new draw_Level(); level.draw_level(screen);}//Game();
            case "SETTINGS"-> System.out.print("SETTINGS"); // Settings();
            case "INFO" -> System.out.print("INFO"); //Info();
            case "EXIT"-> screen.close();
        }
    }
}
