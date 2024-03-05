package brickBreaker;

import java.awt.*;

public class Brick {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;

    private final int x, y;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
