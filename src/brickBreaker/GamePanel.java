package brickBreaker;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final Paddle paddle;

    public GamePanel() {
        setPreferredSize(new Dimension(BrickBreakerGame.WIDTH, BrickBreakerGame.HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);

        paddle = new Paddle((BrickBreakerGame.WIDTH - Paddle.WIDTH) / 2, BrickBreakerGame.HEIGHT - 2 * Paddle.HEIGHT);
    }

        @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
    }
}
