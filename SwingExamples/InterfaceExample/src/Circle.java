import java.awt.*;

public class Circle extends Shape {
        private int size;

        Circle(Canvas canvas, int x, int y, int size, Color c) {
            this.canvas = canvas;
            xorigin = x;
            yorigin = y;
            this.size = size;
            shapeColor = c;

            draw(c);
        }// Draw an oval

    @Override
    public void draw(Color c) {
        Graphics2D g = canvas.getContext();
        g.setColor(c);
        g.fillOval(xorigin, yorigin, size, size);
        canvas.repaint();
    }

    @Override
    public void changeColor(Color c) {

    }

    @Override
    public void erase() {

    }

}
