package src;
import java.util.Arrays;

public class MeasurableTester
{
    public static void main(String[] args)
    {
        Measurable[] countries = new Measurable[3];
        countries[0] = new Country("Uruguay", 176220);
        countries[1] = new Country("Thailand", 514000);
        countries[2] = new Country("Belgium", 30510);
        Measurables.swapMinAndMax(countries);
        System.out.println(Arrays.toString(countries));
        System.out.println("Expected: [Uruguay, Belgium, Thailand]");
        System.out.println();

        Measurable[] objects = {
                new BankAccount(1000),
                new BankAccount(3000),
                new BankAccount(2000),
        };
        Measurables.swapMinAndMax(objects);
        System.out.println(Arrays.toString(objects));
        System.out.println("Expected: [BankAccount[balance=3000.0], "
                + "BankAccount[balance=1000.0], BankAccount[balance=2000.0]]");
        System.out.println();

        Measurable[] objects2 = { new Country("Uruguay", 176220) };
        Measurables.swapMinAndMax(objects2);
        System.out.println(Arrays.toString(objects2));
        System.out.println("Expected: [Uruguay]");
    }
}
