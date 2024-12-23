package project.com.Model.Levels;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class HighScoreTest {

    private Path tempDirectory;
    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        tempDirectory = Files.createTempDirectory("highscore_test");
        tempFile = tempDirectory.resolve("HighScore.txt");

        HighScore.setSaveDataPath( tempDirectory.toString());
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
        Files.deleteIfExists(tempDirectory);
    }


    @Test
    void testLoadHighScore_createsFileIfNotExists() {
        assertFalse(Files.exists(tempFile));
        int highScore = HighScore.loadHighScore();
        assertEquals(0, highScore);
        assertTrue(Files.exists(tempFile));
    }

    @Test
    void testLoadHighScore_readsExistingHighScore() throws IOException {
        // Write a high score to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile.toFile()))) {
            writer.write("123");
        }

        int highScore = HighScore.loadHighScore();
        assertEquals(123, highScore);
    }

    @Test
    void testLoadHighScore_handlesInvalidFileContent() throws IOException {
        // Write invalid content to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile.toFile()))) {
            writer.write("invalid");
        }

        int highScore = HighScore.loadHighScore();
        assertEquals(0, highScore);
    }

    @Test
    void testSetHighScore_updatesFile() throws IOException {
        HighScore.setHighScore(456);

        assertTrue(Files.exists(tempFile)); // Ensure file exists
        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile.toFile()))) {
            String content = reader.readLine();
            assertEquals("456", content); // Check file content
        }
    }

    @Test
    void testSetHighScore_overwritesExistingHighScore() throws IOException {
        // Write an initial high score to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile.toFile()))) {
            writer.write("789");
        }

        HighScore.setHighScore(321);

        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile.toFile()))) {
            String content = reader.readLine();
            assertEquals("321", content); // Check file content
        }
    }
}
