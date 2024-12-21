package project.com.Model.Levels;

import project.com.Model.Elements.Ball;
import project.com.Model.Elements.Brick;
import project.com.Model.Elements.Paddle;
import project.com.Model.Position;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import static java.lang.Character.isSpaceChar;
import static java.nio.charset.StandardCharsets.UTF_8;


public class LevelCreator {
    private final List<String> lines;
    private final int levelNumber;
    private final Rectangle gameArea;


    public LevelCreator(int levelNumber) throws IOException {
        URL resource = getClass().getClassLoader().getResource("Levels/level"+ levelNumber+".txt");

        assert resource != null;
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(resource.getFile()), UTF_8);
        this.lines = readLines(bufferedReader);  //set all file lines in lines
        this.levelNumber=levelNumber;
        this.gameArea= new Rectangle(7,7,166,144);
    }

    //initial object position
    public Level createLevel(Paddle paddle, int score, int highScore) {
        Ball ball= new Ball(new Position(paddle.getPosition().getX() + 5*(paddle.getWidth()/8), paddle.getPosition().getY() - 5));
        Level level= new Level(gameArea,levelNumber,paddle,ball,createBricks(),score, highScore);   //highScore has to be revised
        level.setPaddle(new Position((gameArea.width-28)/2, 130));
        return level;
    }


//parses level txt
    private List<String> readLines(BufferedReader bufferedReader) throws IOException {
            List<String> lines = new ArrayList<>();
            for (String line; (line = bufferedReader.readLine()) != null; )
                lines.add(line);
            return lines;
    }


//matches the coordinates with the char position
    private ArrayList<Brick> createBricks() {
            ArrayList<Brick> bricks = new ArrayList<>();
            for (int y = 0; y < lines.size(); y++) {
                String line = lines.get(y);
                for (int x = 0; x < line.length(); x++) {
                    if(!isSpaceChar(line.charAt(x))) {
                        bricks.add(new Brick(new Position(gameArea.x+(x*15),gameArea.y+(y*8)),line.charAt(x))); //15 and 8 are the width and height of the brick
                    }
                }
            }
            return bricks;
    }
}

