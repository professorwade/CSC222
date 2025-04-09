import java.util.Arrays;

public class Tester
{
    public static void main(String[] args)
    {
        String[] values1 = { "Fred", "Wilma", "Barney" };
        Comparables.swapMinAndMax(values1);
        System.out.println(Arrays.toString(values1));
        System.out.println("Expected: [Fred, Barney, Wilma]");

        Integer[] values2 = { 1, 4, 9, 16, 25 };
        Comparables.swapMinAndMax(values2);
        System.out.println(Arrays.toString(values2));
        System.out.println("Expected: [25, 4, 9, 16, 1]");

        Integer[] values3 = { 1 };
        Comparables.swapMinAndMax(values3);
        System.out.println(Arrays.toString(values3));
        System.out.println("Expected: [1]");

    }
}