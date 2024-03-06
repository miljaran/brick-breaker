package brickBreaker;

import java.awt.*;
import java.util.Random;

public class Ball {
    public static final int SIZE = 20;

    private int x, y;
    private int xSpeed, ySpeed;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.xSpeed = 2;
        this.ySpeed = -2;
    }

    public boolean move() {
        x += xSpeed;
        y += ySpeed;

        if (y <= BrickBreakerGame.HEIGHT) {
            if (x <= 0 || x >= BrickBreakerGame.WIDTH - SIZE) xSpeed = -xSpeed;
            if (y == 0) ySpeed = -ySpeed;
            return true;
        }
        return false;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, SIZE, SIZE);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, SIZE, SIZE);
    }

    public void reverseDirection() {
        xSpeed = -xSpeed;
        ySpeed = -ySpeed;
    }

    public void changeDirection() {
        Random random = new Random();
        xSpeed = random.nextInt(7) - 3;
        ySpeed = -ySpeed;
    }
}
