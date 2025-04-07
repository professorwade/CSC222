import javax.swing.*;
import java.awt.*;

public class CircleAnimation {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Circle Animation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Create and add the animation panel
            AnimationPanel animationPanel = new AnimationPanel();
            frame.add(animationPanel);

            frame.setVisible(true);
        });
    }
}

class AnimationPanel extends JPanel {
    private int x = 0; // X-coordinate of the circle
    private int y = 200; // Y-coordinate of the circle
    private int diameter = 50; // Circle diameter
    private int xVelocity = 2; // Speed of movement along the X-axis

    public AnimationPanel() {
        // Set up a timer for animation
        Timer timer = new Timer(5, e -> {
            x += xVelocity; // Update the X position

            // Reverse direction if the circle hits the edges
            if (x + diameter > getWidth() || x < 0) {
                xVelocity = -xVelocity;
            }

            repaint(); // Request a repaint to update the display
        });

        timer.start(); // Start the timer
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the circle
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diameter, diameter);
    }
}
