import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChartViewer1 extends Application
{
    public void start(Stage stage1)
    {
        Pane root = createRootPane();
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.setTitle("ChartViewer1");
        stage1.show();
    }

    private Pane createRootPane()
    {
        Rectangle rect1 = new Rectangle(0, 10, 50, 10);
        Rectangle rect2 = new Rectangle(0, 30, 300, 10);
        Rectangle rect3 = new Rectangle(0, 50, 100, 10);

        Pane root = new Pane();
        root.getChildren().addAll(rect1, rect2, rect3);
        final int PANE_WIDTH = 400;
        final int PANE_HEIGHT = 200;
        root.setMinSize(PANE_WIDTH, PANE_HEIGHT);

        return root;
    }
}