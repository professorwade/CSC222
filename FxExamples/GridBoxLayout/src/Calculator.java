import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Calculator extends Application
{
    public void start(Stage stage1)
    {
        Pane root = createRootPane();
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.setTitle(" ");
        stage1.show();
    }

    public Pane createRootPane()
    {
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));

        TextField display = new TextField("");
        pane.add(display, 0, 0, 3, 1);

        String[] labels =
                { "7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "CE" };
        int r = 1;
        int c = 0;
        for (String label : labels)
        {
            Button b = new Button(label);
            b.setMaxWidth(Double.MAX_VALUE);
            pane.add(b, c, r);
            c++;
            if (c == 3) { c = 0; r++; }
        }
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33.33);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(33.33);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(33.33);
        pane.getColumnConstraints().addAll(col1, col2, col3);
        return pane;
    }
}