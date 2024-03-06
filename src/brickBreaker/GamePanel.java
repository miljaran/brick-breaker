package brickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private final Paddle paddle;
    private final Ball ball;
    private Brick[] bricks;

    public GamePanel() {
        setPreferredSize(new Dimension(BrickBreakerGame.WIDTH, BrickBreakerGame.HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        paddle = new Paddle((BrickBreakerGame.WIDTH - Paddle.WIDTH) / 2, BrickBreakerGame.HEIGHT - 2 * Paddle.HEIGHT);
        ball = new Ball(BrickBreakerGame.WIDTH / 2, BrickBreakerGame.HEIGHT / 2);
        initializeBricks();

        Timer timer = new Timer(10, this);
        timer.start();
    }

    private void initializeBricks() {
        int brickWidth = Brick.WIDTH;
        int brickHeight = Brick.HEIGHT;
        int brickGap = 3;
        int numColumns = BrickBreakerGame.WIDTH / (Brick.WIDTH + brickGap);
        int numRows = 5;
        int numTotal = numColumns * numRows;
        int padding = (BrickBreakerGame.WIDTH - numColumns * (Brick.WIDTH + brickGap) + brickGap) / 2;

        bricks = new Brick[numTotal];
        int brickX = padding;
        int brickY = 0;
        for (int num = 0; num < numTotal; num++) {
            bricks[num] = new Brick(brickX, brickY);
            if ((num + 1) % numColumns == 0) {
                brickY += (brickHeight + brickGap);
                brickX = padding;
            } else {
                brickX += (brickWidth + brickGap);
            }
        }
    }

    private void handlePaddleCollisions() {
        Rectangle ballRect = ball.getBounds();
        Rectangle paddleRect = paddle.getBounds();
        if (ballRect.intersects(paddleRect)) {
            ball.changeDirection();
        }
    }

    private void handleBrickCollisions() {
        boolean collision = false;
        Rectangle ballRect = ball.getBounds();
        for (int i = 0; i < bricks.length; i++) {
            Brick brick = bricks[i];
            if (brick != null) {
                Rectangle brickRect = brick.getBounds();
                if (ballRect.intersects(brickRect)) {
                    bricks[i] = null;
                    if (!collision) {
                        ball.reverseDirection();
                        collision = true;
                    }
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
        ball.draw(g);
        for (Brick brick : bricks) {
            if (brick != null) {
                brick.draw(g);
            }
        }
    }

    // TODO: end the game when there are no tiles left and improve the losing event
    @Override
    public void actionPerformed(ActionEvent e) {
        paddle.move();
        if (ball.move()) {
            handlePaddleCollisions();
            handleBrickCollisions();
            repaint();
        } else {
            System.out.println("You lost.");
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        paddle.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        paddle.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
