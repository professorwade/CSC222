import java.awt.*;

public abstract class Shape implements Moveable {
    // origin from which to draw shape
    protected int size;
    protected int xorigin;
    protected int yorigin;
    protected Color shapeColor;
    protected Canvas canvas;

    public abstract void draw(Color c);
    public abstract void changeColor(Color c);
    public abstract void erase();

    @Override
    public boolean moveLeft(int step, int xmin) {
        if (xorigin - step < xmin)
            return false;
        draw(canvas.canvasColor); // functionally erase
        xorigin -= step;
        draw(shapeColor);
        return true;
    }

    @Override
    public boolean moveRight(int step, int xmax) {
        if (xorigin + step >  xmax)
            return false;
        draw(canvas.canvasColor); // functionally erase
        xorigin += step;
        draw(shapeColor);
        return true;
    }
}
