import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InvestmentViewer3 extends Application
{
    private double balance;

    private static final double INITIAL_INTEREST_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;

    public void start(Stage stage1)
    {
        Pane root = createRootPane();
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.setTitle("InvestmentViewer3");
        stage1.show();
    }

    private Pane createRootPane()
    {
        balance = INITIAL_BALANCE;

        Label rateLabel = new Label("Interest rate:");
        TextField interestRateField = new TextField("" + INITIAL_INTEREST_RATE);

        Button addInterestButton = new Button("Add interest");
        String initialContents = String.format("$%.2f%n", balance);
        TextArea resultsArea = new TextArea(initialContents);
        final int ROW_COUNT = 10;
        final int COLUMN_COUNT = 20;
        resultsArea.setPrefRowCount(ROW_COUNT);
        resultsArea.setPrefColumnCount(COLUMN_COUNT);
        resultsArea.setEditable(false);

        Pane pane1 = new VBox(rateLabel, interestRateField,
                addInterestButton, resultsArea);

        addInterestButton.setOnAction(event ->
        {
            double rate = Double.parseDouble(interestRateField.getText());
            double interest = balance * rate / 100;
            balance = balance + interest;
            resultsArea.appendText(String.format("$%.2f%n", balance));
        });
        return pane1;
    }
}