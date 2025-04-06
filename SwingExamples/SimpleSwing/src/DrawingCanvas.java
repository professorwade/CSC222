import javax.swing.*;
import java.awt.*;

public class DrawingCanvas extends JPanel {

    // Constructor for setting up the canvas
    public DrawingCanvas() {
        setPreferredSize(new Dimension(400, 400)); // Set preferred size of the canvas
        setBackground(Color.WHITE); // Set background color
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method to ensure proper rendering

        // Cast Graphics to Graphics2D for more advanced functionality
        Graphics2D g2d = (Graphics2D) g;

        // Set stroke and color properties
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLUE);

        // Draw a line
        g2d.drawLine(50, 50, 200, 50);

        // Draw a rectangle
        g2d.setColor(Color.RED);
        g2d.drawRect(100, 100, 150, 100);

        // Draw an oval
        g2d.setColor(Color.GREEN);
        g2d.fillOval(200, 200, 100, 50);

        // Draw a polygon
        g2d.setColor(Color.ORANGE);
        int[] xPoints = {300, 350, 325};
        int[] yPoints = {300, 300, 250};
        g2d.drawPolygon(xPoints, yPoints, xPoints.length);
    }

    public static void main(String[] args) {
        // Create the frame and set its properties
        JFrame frame = new JFrame("Drawing Canvas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the custom canvas to the frame
        DrawingCanvas canvas = new DrawingCanvas();
        frame.add(canvas);

        // Pack and display the frame
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the window on screen
        frame.setVisible(true);
    }
}
