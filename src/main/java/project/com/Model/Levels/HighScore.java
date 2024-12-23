package project.com.Model.Levels;

import java.io.*;

public class HighScore {
    private static int highScore = 0;

    private static String saveDataPath;
    private static final String fileName = "HighScore.txt";

    public HighScore() {
        try {
            // Ensure the path is writable
            saveDataPath = new File(".").getCanonicalPath(); // Save in the current working directory
        } catch (Exception e) {
            saveDataPath = "";
        }
    }

    private static void createHighScore() {
        try {
            File file = new File(saveDataPath, fileName);
            if (file.createNewFile()) { // Ensure the file is created
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write("0"); // Write initial high score
                }
            }
        } catch (Exception ignored) {
        }
    }

    public static int loadHighScore() {
        try {
            File file = new File(saveDataPath, fileName);
            if (!file.isFile()) {
                createHighScore(); // Create file if it doesn't exist
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                highScore = Integer.parseInt(reader.readLine().trim());
            }
        } catch (Exception e) {
            highScore = 0; // Fallback in case of error
        }
        return highScore;
    }

    public static void setHighScore(int score) {
        try {
            File file = new File(saveDataPath, fileName);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(String.valueOf(score)); // Write the new high score
            }
        } catch (Exception ignored) {
        }
    }

    public static void setSaveDataPath(String saveDataPath) {
        HighScore.saveDataPath = saveDataPath;
    }

    public static String getSaveDataPath() {
        return saveDataPath;
    }
}
