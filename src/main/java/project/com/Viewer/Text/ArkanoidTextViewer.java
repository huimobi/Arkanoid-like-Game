package project.com.Viewer.Text;

import project.com.Model.Position;
import project.com.gui.GUI;

import java.io.IOException;
import java.util.*;

public class ArkanoidTextViewer implements TextViewer{
    private final Map<WriteChar, ArrayList<Position>> textMap;
    private final Map<Character,WriteChar> charMap;

    public ArkanoidTextViewer(){
        this.charMap=new HashMap<>();
        this.textMap= new HashMap<>();
    }

    @Override
    public void draw(char character, Position position, String foregroundColor, GUI gui) throws IOException {
        character=Character.toUpperCase(character);
        WriteChar c= new WriteChar(character);

        if (charMap.containsKey(character)) {   //if a char was used
                if(textMap.get(charMap.get(character)).contains(position)){ //if the position is equivalent to a char already created
                    setForeground(gui,foregroundColor,position,charMap.get(character)); //change foreground color
                    return;

                } else{  //adds position to the map
                    textMap.get(charMap.get(character)).add(position);
                }
        }
        else{  //if writeChar wasn't initialized gets initialized
            charMap.put(character,c);
            textMap.put(c, new ArrayList<>(Collections.singletonList(position)));
        }
        setForeground(gui,foregroundColor,position,c);
    }

    @Override
    public void draw(String string, Position position, String foregroundColor, GUI gui) throws IOException {
        for(int i=0;i<string.length();i++){
            if (string.charAt(i)==' '){continue;}
            draw(string.charAt(i),new Position(position.getX()+i*WriteChar.CHARWIDTH, position.getY()),foregroundColor,gui);
        }
    }

    public void draw(String string, Position position,GUI gui) throws IOException {
        draw(string,position,"WHITE_BRIGHT",gui);
    }


    private void setForeground(GUI gui,String color,Position startPosition, WriteChar character){
        if(color.equals("WHITE_BRIGHT")){
            character.setForegroundDefault(gui,startPosition);}
        else{
            character.setForeground(gui,color,startPosition);
        }
    }

    public void setForeground(GUI gui,String color,Position startPosition,String text) throws IOException {
        draw(text,startPosition,color,gui);
    }
    }
