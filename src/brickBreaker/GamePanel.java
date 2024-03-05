package brickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private final Paddle paddle;

    public GamePanel() {
        setPreferredSize(new Dimension(BrickBreakerGame.WIDTH, BrickBreakerGame.HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        paddle = new Paddle((BrickBreakerGame.WIDTH - Paddle.WIDTH) / 2, BrickBreakerGame.HEIGHT - 2 * Paddle.HEIGHT);

        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paddle.move();
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
