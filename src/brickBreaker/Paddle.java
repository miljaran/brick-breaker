package brickBreaker;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 20;
    private static final int SPEED = 5;

    private int x;
    private final int y;

    private boolean leftPressed, rightPressed;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // TODO: add limits to the sides
    public void move() {
        if (leftPressed) {
            x -= SPEED;
        } else if (rightPressed) {
            x += SPEED;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
