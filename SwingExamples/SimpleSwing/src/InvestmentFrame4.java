import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 A frame that shows the growth of an investment with variable interest,
 using a bar chart.
 */
public class InvestmentFrame4 extends JFrame
{
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

    private static final int CHART_WIDTH = 300;
    private static final int CHART_HEIGHT = 300;

    private static final double DEFAULT_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;

    private JLabel rateLabel;
    private JTextField rateField;
    private JButton button;
    private ChartComponent chart;
    private double balance;


    public class ChartComponent extends JComponent
    {
        private ArrayList<Double> values;
        private double maxValue;

        public ChartComponent(double max)
        {
            values = new ArrayList<Double>();
            maxValue = max;
        }

        public void append(double value)
        {
            values.add(value);
            repaint();
        }

        public void paintComponent(Graphics g)
        {
            final int GAP = 5;
            final int BAR_HEIGHT = 10;

            int y = GAP;
            for (double value : values)
            {
                int barWidth = (int) (getWidth() * value / maxValue);
                g.fillRect(0, y, barWidth, BAR_HEIGHT);
                y = y + BAR_HEIGHT + GAP;
            }
        }
    }

    public InvestmentFrame4()
    {
        balance = INITIAL_BALANCE;
        chart = new ChartComponent(3 * INITIAL_BALANCE);
        chart.setPreferredSize(new Dimension(CHART_WIDTH, CHART_HEIGHT));
        chart.append(INITIAL_BALANCE);

        createTextField();
        createButton();
        createPanel();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createTextField()
    {
        rateLabel = new JLabel("Interest Rate: ");

        final int FIELD_WIDTH = 10;
        rateField = new JTextField(FIELD_WIDTH);
        rateField.setText("" + DEFAULT_RATE);
    }

    class AddInterestListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            double rate = Double.parseDouble(rateField.getText());
            double interest = balance * rate / 100;
            balance = balance + interest;
            chart.append(balance);
        }
    }

    private void createButton()
    {
        button = new JButton("Add Interest");

        ActionListener listener = new AddInterestListener();
        button.addActionListener(listener);
    }

    private void createPanel()
    {
        JPanel panel = new JPanel();
        panel.add(rateLabel);
        panel.add(rateField);
        panel.add(button);
        panel.add(chart);
        add(panel);
    }

    public static void main(String[] args) {
        InvestmentFrame4 frame = new InvestmentFrame4();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}