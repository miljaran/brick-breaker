package brickBreaker;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        setPreferredSize(new Dimension(BrickBreakerGame.WIDTH, BrickBreakerGame.HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
    }
}
