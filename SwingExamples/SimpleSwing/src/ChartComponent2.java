import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 A component that draws a demo chart.
 */
public class ChartComponent2 extends JComponent
{
    public void paintComponent(Graphics g)
    {
        // Draw the bars
        g.fillRect(0, 10, 200, 10);
        g.fillRect(0, 30, 300, 10);
        g.fillRect(0, 50, 100, 10);

        // Draw the arrow
        g.drawLine(350, 35, 305, 35);
        g.drawLine(305, 35, 310, 30);
        g.drawLine(305, 35, 310, 40);

        // Draw the highlight and the text
        g.setColor(Color.YELLOW);
        g.fillOval(350, 25, 35, 20);
        g.setColor(Color.BLACK);
        g.drawString("Best", 355, 40);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        frame.setSize(400, 200);
        frame.setTitle("A bar chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent component = new ChartComponent2();
        frame.add(component);

        frame.setVisible(true);
    }
}