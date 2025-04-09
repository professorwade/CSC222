public class SegmentTester
{
    public static void main(String[] args)
    {
        Segment[] segments =
                {
                        new Segment(1, 5), // measure 4
                        new Segment(5, 1), // measure 4
                        new Segment(1, 1), // measure 0
                        new Segment(1, 3) // measure 2
                };
        System.out.println(average(segments));
        System.out.println("Expected: 2.5");
    }

    /**
     Computes the average of the measures of the given objects.
     @param objects an array of Measurable objects
     @return the average of the measures
     */
    public static double average(Measurable[] objects)
    {
        if (objects.length == 0) { return 0; }
        double sum = 0;
        for (Measurable obj : objects)
        {
            sum = sum + obj.getMeasure();
        }
        return sum / objects.length;
    }
}
