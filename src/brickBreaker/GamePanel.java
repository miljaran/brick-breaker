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

    @Override
    public void actionPerformed(ActionEvent e) {
        paddle.move();
        ball.move();
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
