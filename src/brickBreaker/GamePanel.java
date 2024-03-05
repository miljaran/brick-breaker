package brickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private final Paddle paddle;
    private final Ball ball;
    private Brick[][] bricks;

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
        int padding = (BrickBreakerGame.WIDTH - numColumns * (Brick.WIDTH + brickGap) + brickGap) / 2;

        bricks = new Brick[numRows][numColumns];
        int brickX = padding;
        int brickY = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                bricks[row][col] = new Brick(brickX, brickY);
                brickX += (brickWidth + brickGap);
            }
            brickY += (brickHeight + brickGap);
            brickX = padding;
        }
    }

    private void handlePaddleCollisions() {
        Rectangle ballRect = ball.getBounds();
        Rectangle paddleRect = paddle.getBounds();
        if (ballRect.intersects(paddleRect)) {
            ball.reverseDirection();
        }
    }

    private void handleBrickCollisions() {
        Rectangle ballRect = ball.getBounds();
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                Brick brick = bricks[i][j];
                if (brick != null) {
                    Rectangle brickRect = brick.getBounds();
                    if (ballRect.intersects(brickRect)) {
                        ball.reverseDirection();
                        bricks[i][j] = null;
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
        for (Brick[] row : bricks) {
            for (Brick brick : row) {
                if (brick != null) {
                    brick.draw(g);
                }
            }
        }
    }

    // TODO: end the game when there are no tiles left or the ball is below the paddle
    @Override
    public void actionPerformed(ActionEvent e) {
        paddle.move();
        ball.move();
        handlePaddleCollisions();
        handleBrickCollisions();
        repaint();
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
