import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChartViewer2 extends Application
{
    public void start(Stage stage1)
    {
        Pane root = createRootPane();
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.setTitle("ChartViewer2");
        stage1.show();
    }

    private Pane createRootPane()
    {
        Pane root = new Pane();
        final int PANE_WIDTH = 400;
        final int PANE_HEIGHT = 300;
        root.setMinSize(PANE_WIDTH, PANE_HEIGHT);

        // Add bars

        root.getChildren().add(new Rectangle(0, 10, 50, 10));
        root.getChildren().add(new Rectangle(0, 30, 300, 10));
        root.getChildren().add(new Rectangle(0, 50, 100, 10));

        // Add arrow

        root.getChildren().add(new Line(350, 35, 305, 35));
        root.getChildren().add(new Line(305, 35, 310, 30));
        root.getChildren().add(new Line(305, 35, 310, 40));

        Ellipse highlight = new Ellipse(370, 35, 20, 10);
        highlight.setFill(Color.YELLOW);
        Label text = new Label("Best");
        text.relocate(355, 30);
        ImageView laurel = new ImageView("laurel.png");
        laurel.relocate(340, 50);
        laurel.setPreserveRatio(true);
        laurel.setFitHeight(50);
        laurel.setFitWidth(50);

        root.getChildren().addAll(highlight, text, laurel);

        return root;
    }
}