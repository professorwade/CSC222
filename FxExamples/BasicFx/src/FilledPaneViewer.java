import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FilledPaneViewer extends Application
{
    public void start(Stage stage1)
    {
        Button button1 = new Button("Click me!");
        Label label1 = new Label("Hello, World!");
        label1.relocate(0, 50);

        Pane root = new Pane(button1, label1);
        final int PANE_WIDTH = 300;
        final int PANE_HEIGHT = 400;
        root.setMinSize(PANE_WIDTH, PANE_HEIGHT);

        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.setTitle("A pane with two controls");
        stage1.show();
    }
}