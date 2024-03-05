package brickBreaker;

import javax.swing.*;

public class BrickBreakerGame extends JFrame {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    public BrickBreakerGame() {
        setTitle("Brick Breaker");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BrickBreakerGame::new);
    }
}
