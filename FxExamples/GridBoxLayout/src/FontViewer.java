import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FontViewer extends Application
{
    private Label sample;
    private CheckBox italicCheckbox;
    private CheckBox boldCheckbox;
    private RadioButton smallButton;
    private RadioButton mediumButton;
    private RadioButton largeButton;
    private ChoiceBox<String> fontChoice;

    public void start(Stage primaryStage)
    {
        Pane root = createRootPane();
        Scene scene1 = new Scene(root);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("FontViewer");
        primaryStage.show();
    }

    private Pane createRootPane()
    {
        sample = new Label("Big Java");
        italicCheckbox = new CheckBox("Italic");
        italicCheckbox.setOnAction(event -> updateSample());

        boldCheckbox = new CheckBox("Bold");
        boldCheckbox.setOnAction(event -> updateSample());

        ToggleGroup group = new ToggleGroup();
        smallButton = new RadioButton("Small");
        smallButton.setToggleGroup(group);
        smallButton.setOnAction(event -> updateSample());
        mediumButton = new RadioButton("Medium");
        mediumButton.setToggleGroup(group);
        mediumButton.setOnAction(event -> updateSample());
        largeButton = new RadioButton("Large");
        largeButton.setToggleGroup(group);
        largeButton.setOnAction(event -> updateSample());
        largeButton.setSelected(true);
        fontChoice = new ChoiceBox<>();
        fontChoice.getItems().addAll("Serif", "SansSerif", "Monospaced");
        fontChoice.getSelectionModel().select("Serif");
        fontChoice.setOnAction(event -> updateSample());

        GridPane pane = new GridPane();

        pane.add(sample, 0, 0, 3, 1);
        pane.add(italicCheckbox, 0, 1);
        pane.add(boldCheckbox, 1, 1);
        pane.add(smallButton, 0, 2);
        pane.add(mediumButton, 1, 2);
        pane.add(largeButton, 2, 2);
        pane.add(fontChoice, 2, 1);

        pane.setHgap(10);
        pane.setVgap(10);

        pane.setPadding(new Insets(10, 10, 10, 10));
        sample.setMinHeight(100);

        updateSample();
        return pane;
    }

    private void updateSample()
    {
        String facename = fontChoice.getSelectionModel().getSelectedItem();
        FontPosture posture;
        if (italicCheckbox.isSelected())
        {
            posture = FontPosture.ITALIC;
        }
        else
        {
            posture = FontPosture.REGULAR;
        }
        FontWeight weight;
        if (boldCheckbox.isSelected())
        {
            weight = FontWeight.BOLD;
        }
        else
        {
            weight = FontWeight.NORMAL;
        }
        // Get font size

        int size = 0;
        final int SMALL_SIZE = 24;
        final int MEDIUM_SIZE = 36;
        final int LARGE_SIZE = 48;

        if (smallButton.isSelected()) { size = SMALL_SIZE; }
        else if (mediumButton.isSelected()) { size = MEDIUM_SIZE; }
        else if (largeButton.isSelected()) { size = LARGE_SIZE; }

        // Set font of label

        sample.setFont(Font.font(facename, weight, posture, size));
    }
}