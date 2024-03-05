package brickBreaker;

import java.awt.*;

public class Paddle {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 20;

    private final int x;
    private final int y;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
