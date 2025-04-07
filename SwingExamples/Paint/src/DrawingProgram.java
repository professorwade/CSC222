import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingProgram {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Drawing Program");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Create a custom drawing panel
            DrawingPanel drawingPanel = new DrawingPanel();
            frame.add(drawingPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}

class DrawingPanel extends JPanel {
    private int oldX, oldY; // Previous mouse coordinates
    private Image canvasImage; // Off-screen image for drawing
    private Graphics2D canvasGraphics; // Graphics object for the off-screen image

    public DrawingPanel() {
        setBackground(Color.WHITE);

        // Mouse listeners for drawing
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int currentX = e.getX();
                int currentY = e.getY();

                if (canvasGraphics != null) {
                    canvasGraphics.drawLine(oldX, oldY, currentX, currentY); // Draw line on the canvas
                    repaint(); // Repaint the panel to display the updated image
                }

                oldX = currentX;
                oldY = currentY;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (canvasImage == null) {
            // Initialize the off-screen image and its Graphics2D object
            canvasImage = createImage(getWidth(), getHeight());
            canvasGraphics = (Graphics2D) canvasImage.getGraphics();
            canvasGraphics.setColor(Color.WHITE);
            canvasGraphics.fillRect(0, 0, getWidth(), getHeight()); // Fill with white background
            canvasGraphics.setColor(Color.BLACK); // Default drawing color
        }

        g.drawImage(canvasImage, 0, 0, null); // Draw the off-screen image onto the panel
    }
}
