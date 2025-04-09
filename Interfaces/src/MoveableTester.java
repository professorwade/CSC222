import java.util.Arrays;

public class MoveableTester
{
    public static void main(String[] args)
    {
        Segment[] segments =
                {
                        new Segment(1, 5),
                        new Segment(5, 1),
                        new Segment(1, 1),
                        new Segment(1, 3)
                };
        move(segments, 10);
        System.out.println(Arrays.toString(segments));
        System.out.println(
                "Expected: [11.0->15.0, 15.0->11.0, 11.0->11.0, 11.0->13.0]");
    }

    /**
     Moves all objects by a given amount.
     @param objects an array of Moveable objects
     @param the amount by which to move them.
     */
    public static void move(Moveable[] objects, double amount)
    {
        for (Moveable obj : objects)
        {
            obj.move(amount);
        }
    }
}