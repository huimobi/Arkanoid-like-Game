package project.com.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isLetterOrDigit;
import static java.lang.Character.isSpaceChar;
import static java.nio.charset.StandardCharsets.UTF_8;


public class LevelCreator {
    private final List<String> lines;


    public LevelCreator(int levelNumber) throws IOException {
            URL resource = getClass().getClassLoader().getResource("levels/level" + levelNumber + ".txt");

            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(resource.getFile()), UTF_8);
            this.lines = readLines(bufferedReader);
    }

    private List<String> readLines(BufferedReader bufferedReader) throws IOException {
            List<String> lines = new ArrayList<>();
            for (String line; (line = bufferedReader.readLine()) != null; )
                lines.add(line);
            return lines;
    }

    private int getWidth() {
            int width = 0;
            for (String line : lines)
                width = Math.max(width, line.length());
            return width;
    }

    private int getHeight() {
            return lines.size();
    }

    private Brick[][] createBricks() {
            Brick[][] bricks = new Brick[lines.size()][lines.get(0).length()];

            for (int y = 0; y < lines.size() - 4; y++) {
                String line = lines.get(y);
                Brick[] lineBricks= new Brick[11];
                for (int x = 0; x < line.length(); x++) {
                    if (!isSpaceChar(line.charAt(x)))
                        lineBricks[x] = new Brick(new Position(x,y), line.charAt(x));
                    else {
                        lineBricks[x] = null;
                    }
                }
                lineBricks[10] = null;
                bricks[y] = lineBricks;
            }
            return bricks;
    }

}
