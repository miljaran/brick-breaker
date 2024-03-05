package brickBreaker;

import java.awt.*;

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

    // TODO: react if the ball is below the paddle
    public void move() {
        x += xSpeed;
        y += ySpeed;

        if (x <= 0 || x >= BrickBreakerGame.WIDTH - SIZE) {
            xSpeed = -xSpeed;
        }
        if (y <= 0 || y >= BrickBreakerGame.HEIGHT - SIZE) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, SIZE, SIZE); // TODO: change to fillOval
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, SIZE, SIZE);
    }

    // TODO: improve the logic
    public void reverseDirection() {
        xSpeed = -xSpeed;
        ySpeed = -ySpeed;
    }
}
