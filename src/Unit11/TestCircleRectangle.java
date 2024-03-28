package Unit11;

import java.util.ArrayList;

public class TestCircleRectangle {
    public static void main(String[] args) {
        ArrayList<SimpleGeometricObject> objects = new ArrayList<>();


        CircleFromSimpleGeometricObject circle =
                new CircleFromSimpleGeometricObject(1);
        objects.add(circle); // add to container

        System.out.println("A circle " + circle.toString());
        System.out.println("The color is " + circle.getColor());
        System.out.println("The radius is " + circle.getRadius());
        System.out.println("The area is " + circle.getArea());
        System.out.println("The diameter is " + circle.getDiameter());

        RectangleFromSimpleGeometricObject rectangle =
                new RectangleFromSimpleGeometricObject(2, 4);

        objects.add(rectangle); // add to container

        System.out.println("\nA rectangle " + rectangle.toString());
        System.out.println("The area is " + rectangle.getArea());
        System.out.println("The perimeter is " +
                rectangle.getPerimeter());

        System.out.println("Test toStrings");
        for (SimpleGeometricObject so : objects) {
            System.out.println(so.toString());
        }

        System.out.println("Test Dynamic Cast");
        for (SimpleGeometricObject so : objects) {
            if (so instanceof CircleFromSimpleGeometricObject) {
                CircleFromSimpleGeometricObject c = (CircleFromSimpleGeometricObject) so;
                System.out.println("The area of the circle is: " + c.getArea());
            }
            else if (so instanceof RectangleFromSimpleGeometricObject) {
                RectangleFromSimpleGeometricObject r = (RectangleFromSimpleGeometricObject) so;
                System.out.println("The area of the rectangle is: " + r.getArea());
            }
        }

    }
}