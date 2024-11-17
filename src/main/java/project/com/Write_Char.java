package project.com;

import com.googlecode.lanterna.TextColor;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

public class Write_Char {
    private static final Dictionary<Character, String[]> dict= new Hashtable<>();
    static{
        /*
        LEGENDA:
            W- foreground
            B- black(contornado)
            #- fundo

            ATE AGORA SO FIZ O '0', FALTA POR COR PARA CADA PIXEL E DESENHAR NO SCREEN
        */

        dict.put('0', new String[]{
                "#BBBBB#",
                "BBWWWBB",
                "BWBBBWB",
                "BWB#BWB",
                "BWBBBWB",
                "BBWWWBB",
                "#BBBBB#",
        });
    }

    //
    public Write_Char(char c, Position p){
        String[] character_draw=dict.get(c);
        if(character_draw !=null){
            for (String line : character_draw){

                for(Character i: line.toCharArray()){
                    if(i.equals('B'))
                }

            }
        }

    }



}
