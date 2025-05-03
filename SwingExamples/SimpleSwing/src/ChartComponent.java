import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
   A component that draws a bar chart.
*/
public class ChartComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        g.fillRect(0, 10, 200, 10);
        g.fillRect(0, 30, 300, 10);
        g.fillRect(0, 50, 100, 10);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        frame.setSize(400, 200);
        frame.setTitle("A bar chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent component = new ChartComponent();
        frame.add(component);

        frame.setVisible(true);
    }
}
