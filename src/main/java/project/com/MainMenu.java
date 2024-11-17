package project.com;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static project.com.Arkanoid.screen;


class MainMenu {

    private String cur_selection="PLAY"; //PLAY is the option by default
    private final ArrayList<String> options= new ArrayList<String>(Arrays.asList("PLAY", "SETTINGS", "INFO", "EXIT")); //all possible options
    private boolean in_menu=true; //checks if the game is in the Menu (MAYBE THIS CAN BE IMPLEMENTED IN ARKANOID CLASS (?))


    public MainMenu() throws IOException, NullPointerException {
        screen.clear();
        draw(screen);
        while (in_menu) {
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }

    //draws the Main Menu
    private void draw(Screen screen) throws IOException {
        screen.clear();
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT); //letters foreground
        textGraphics.setBackgroundColor(TextColor.ANSI.BLUE); //letters background

        String play_string = "PLAY";

        textGraphics.putString((Arkanoid.width - play_string.length()) / 2, Arkanoid.height / 2, play_string);
        screen.refresh();
    }



    private void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp -> previous_option();
            case ArrowDown -> next_option();
            case Enter -> {select();} //in_menu=false;
            case EOF -> {screen.close(); in_menu=false;}
            }

    }

    //previous_option
    void previous_option(){
        int index=options.indexOf(cur_selection);
        if(index==0) return; //checks if the cur_option is the first in the menu
        else {cur_selection=options.get(index-1);}
    }

    //next_option
    void next_option(){
        int index=options.indexOf(cur_selection);
        if(index==options.size()-1) return; // checks if the cur_option is the last in the menu
        else cur_selection=options.get(index+1);
    }

    //select option
    private void select(){
        switch (cur_selection){
            case "PLAY" -> System.out.print("PLAY"); //Game();
            case "SETTINGS" -> System.out.print("SETTINGS"); // Settings();
            case "INFO" -> System.out.print("INFO"); //Info();
            case "EXIT" -> System.out.print("EXIT"); //screen.close();
        }
    }
}
