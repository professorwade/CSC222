import java.awt.*;

public abstract class Shape {
    // origin from which to draw shape
    protected int xorigin;
    protected int yorigin;
    protected Color canvasColor;

    public abstract void draw();
    public abstract void changeColor(Color c);
    public abstract void erase(Color canvasColor);



}
