import com.googlecode.lanterna.graphics.TextGraphics;

    public class Ball {
        private int x, y;
        private int xSpeed = 1, ySpeed = -1;

        public Ball(int startX, int startY) {
            this.x = startX;
            this.y = startY;
        }

        public void move() {
            x += xSpeed;
            y += ySpeed;

            // Boundary check
            if (x <= 0 || x >= ArkanoidGame.WIDTH - 1) xSpeed = -xSpeed;
            if (y <= 0) ySpeed = -ySpeed;
        }

        public void reverseYDirection() {
            ySpeed = -ySpeed;
        }

        public void render(TextGraphics graphics) {
            graphics.setCharacter(x, y, 'O');
        }

        public int getX() { return x; }
        public int getY() { return y; }
    }