package Unit11;

public class RectangleFromSimpleGeometricObject extends SimpleGeometricObject{
    private double width;
    private double height;

    public RectangleFromSimpleGeometricObject() {
    }

    public RectangleFromSimpleGeometricObject(
            double width, double height) {
        this.width = width;
        this.height = height;
    }

    public RectangleFromSimpleGeometricObject(
            double width, double height, String color, boolean filled) {
        //super("red", true);
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RectangleFromSimpleGeometricObject) {
            RectangleFromSimpleGeometricObject rect = (RectangleFromSimpleGeometricObject)obj;
            if (this.width == rect.width &&
                    this.height == rect.height && getColor() == rect.getColor() &&
                    isFilled() == rect.isFilled())
                return true;
            else
                return false;
        }
        else
            return false;
    } // anything wrong here? any simplification?

    /** Return width */
    public double getWidth() {
        return width;
    }

    /** Set a new width */
    public void setWidth(double width) {
        this.width = width;
    }

    /** Return height */
    public double getHeight() {
        return height;
    }

    /** Set a new height */
    public void setHeight(double height) {
        this.height = height;
    }

    /** Return area */
    public double getArea() {
        return width * height;
    }

    /** Return perimeter */
    public double getPerimeter() {
        return 2 * (width + height);
    }

    public String toString() {
        return super.toString() + " I am a rectangle!";
    }
}
