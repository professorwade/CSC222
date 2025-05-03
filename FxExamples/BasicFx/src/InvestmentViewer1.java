import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InvestmentViewer1 extends Application
{
    private Button addInterestButton;
    private Label resultLabel;
    private double balance;

    private static final double INTEREST_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;

    public void start(Stage stage1)
    {
        Pane root = createRootPane();
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.setTitle("InvestmentViewer1");
        stage1.show();
    }

    private Pane createRootPane()
    {
        balance = INITIAL_BALANCE;

        addInterestButton = new Button("Add interest");
        resultLabel = new Label(String.format("$%.2f", balance));
        resultLabel.relocate(0, 50);

        Pane root = new Pane(addInterestButton, resultLabel);
        final int PANE_WIDTH = 300;
        final int PANE_HEIGHT = 400;
        root.setMinSize(PANE_WIDTH, PANE_HEIGHT);

        addInterestButton.setOnAction(event ->
        {
            double interest = balance * INTEREST_RATE / 100;
            balance = balance + interest;
            resultLabel.setText(String.format("$%.2f", balance));
        });
        return root;
    }
}

