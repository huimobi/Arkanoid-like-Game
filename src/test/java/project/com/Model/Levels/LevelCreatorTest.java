package project.com.Model.Levels;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import project.com.Model.Elements.Paddle;
import project.com.Model.Position;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LevelCreatorTest {

    @Mock
    private Paddle mockPaddle;

    private LevelCreator levelCreator;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);

        String mockFileContent = "B B B\nY Y Y";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(mockFileContent));

        levelCreator = spy(new LevelCreator(1));
        doReturn(readMockLines(bufferedReader)).when(levelCreator).readLines(any());

        // Mock paddle behavior
        when(mockPaddle.getPosition()).thenReturn(new Position(50, 100));
        when(mockPaddle.getWidth()).thenReturn(40);
    }

    @Test
    void testCreateLevel() {
        int score = 0;
        int highScore = 1000;

        Level level = levelCreator.createLevel(mockPaddle, score, highScore);

        assertNotNull(level);
        assertEquals(1, level.getLevelNumber());
        assertNotNull(level.getPaddle());
        assertNotNull(level.getBall());
        assertEquals(score, level.getScore());
        assertEquals(highScore, level.getHighestScore());
        assertNotNull(level.getBricks());
        assertFalse(level.getBricks().isEmpty());
    }


    @Test
    void testReadLines() throws IOException {
        String mockFileContent = "123\n456";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(mockFileContent));

        List<String> lines = levelCreator.readLines(bufferedReader);

        assertEquals(2, lines.size());
        assertEquals("B B B", lines.get(0));
        assertEquals("Y Y Y", lines.get(1));
    }

    // Helper to create mock lines
    private List<String> readMockLines(BufferedReader bufferedReader) throws IOException {
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }
}