import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SimpleTable {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sample data for the table
        String[] columnNames = {"Name", "Age", "City"};
        Object[][] data = {
                {"John Doe", 30, "New York"},
                {"Jane Smith", 25, "Los Angeles"},
                {"Peter Jones", 40, "Chicago"}
        };

        // Create a DefaultTableModel to hold the data
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create the JTable with the model
        JTable table = new JTable(model);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane);

        // Set frame size and visibility
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}