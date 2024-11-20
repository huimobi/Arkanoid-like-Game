import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.io.IOException;

public class ArkanoidGame {
    protected static final int WIDTH = 80;  // Width of the game screen
    private static final int HEIGHT = 25; // Height of the game screen
    private static Terminal terminal;
    private static TextGraphics graphics;
    private static Paddle paddle;
    private static Ball ball;
    private static Block[][] blocks;

    public static void main(String[] args) {
        try {
            // Initialize the terminal using the DefaultTerminalFactory
            terminal = new DefaultTerminalFactory().createTerminal();
            terminal.setCursorVisible(false);
            graphics = terminal.newTextGraphics();

            paddle = new Paddle(WIDTH / 2 - 3, HEIGHT - 2);
            ball = new Ball(WIDTH / 2, HEIGHT - 3);
            blocks = createBlocks();

            gameLoop();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (terminal != null) terminal.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Block[][] createBlocks() {
        Block[][] blocks = new Block[5][10]; // 5 rows, 10 columns
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                blocks[i][j] = new Block(6 + j * 7, 3 + i * 2);
            }
        }
        return blocks;
    }

    private static void gameLoop() {
        while (true) {
            try {
                try {
                    terminal.clearScreen(); // Handle potential IOException
                } catch (IOException e) {
                    e.printStackTrace(); // Handle error in clearing the screen
                    break; // Break the game loop if terminal cannot clear the screen
                }

                handleInput();
                updateGame();
                renderGame();
                try {
                    terminal.flush(); // Handle potential IOException
                } catch (IOException e) {
                    e.printStackTrace(); // Handle error in flushing the terminal
                    break; // Break the game loop if terminal cannot flush the screen
                }

                Thread.sleep(100); // Adjust speed here
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleInput() {
        try {
            // Get the input
            KeyStroke keyStroke = terminal.pollInput();

            // Only process input if there is something to read
            if (keyStroke != null) {
                if (keyStroke.getKeyType() == KeyType.ArrowLeft) {
                    paddle.moveLeft();
                } else if (keyStroke.getKeyType() == KeyType.ArrowRight) {
                    paddle.moveRight();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void updateGame() {
        ball.move();
        checkCollisions();
    }

    private static void checkCollisions() {
        // Ball collision with paddle
        if (ball.getY() == paddle.getY() - 1 && ball.getX() >= paddle.getX() && ball.getX() <= paddle.getX() + paddle.getWidth()) {
            ball.reverseYDirection();
        }

        // Ball collision with blocks
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                Block block = blocks[i][j];
                if (!block.isDestroyed() && ball.getX() >= block.getX() && ball.getX() <= block.getX() + block.getWidth()
                        && ball.getY() == block.getY()) {
                    block.destroy();
                    ball.reverseYDirection();
                }
            }
        }
    }

    private static void renderGame() {
        // Render the paddle
        paddle.render(graphics);

        // Render the ball
        ball.render(graphics);

        // Render the blocks
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                blocks[i][j].render(graphics);
            }
        }
    }
}
