import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CssCalculator extends Application
{
    public void start(Stage stage1)
    {
        Pane root = createRootPane();
        Scene scene1 = new Scene(root);
        scene1.getStylesheets().add("calc.css");
        stage1.setScene(scene1);
        stage1.setTitle(" ");
        stage1.show();
    }

    public Pane createRootPane()
    {
        GridPane pane = new GridPane();

        TextField display = new TextField("");
        pane.add(display, 0, 0, 3, 1);

        String[] labels = { "7", "8", "9", "4", "5", "6", "1", "2", "3",
                "0", ".", "CE" };
        int r = 1;
        int c = 0;
        for (String label : labels)
        {
            Button b = new Button(label);
            pane.add(b, c, r);
            c++;
            if (c == 3) { c = 0; r++; }
            b.setId("button" + label);
        }

        pane.setStyle("-fx-border-style: dotted;"
                + " -fx-border-width: 1px;"
                + " -fx-border-color: blue;");

        // This can't be done with CSS
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