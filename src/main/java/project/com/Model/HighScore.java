package project.com.Model;

import java.io.*;

public class HighScore {
    private static int highScore = 0;

    private static String saveDataPath;
    private static String fileName = "HighScore.txt";

    public HighScore() {
        try {
            saveDataPath = HighScore.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        private static void createHighScore() {
            try {
                File file = new File(saveDataPath, fileName);
                saveDataPath = file.getAbsolutePath();
                FileWriter output = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(output);
                writer.write(""+0);     //o argumento é uma string
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        public static int loadHighScore(){
            try{
                File f = new File(saveDataPath, fileName);
                saveDataPath = f.getAbsolutePath();
                if(!f.isFile()){
                    createHighScore();
                }
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                highScore = Integer.parseInt(reader.readLine());
                reader.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return highScore;
        }


    public static void setHighScore(int score){
            FileWriter output = null;

            try{
                File f = new File(saveDataPath, fileName);
                saveDataPath = f.getAbsolutePath();
                output = new FileWriter(f);
                BufferedWriter writer = new BufferedWriter(output);
                    writer.write(""+score);
                writer.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
}
