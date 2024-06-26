package unit12;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuotientWithExceptionImproved {
    public static int quotient(int number1, int number2) {
        if (number2 == 0)
            throw new ArithmeticException("Divisor cannot be zero");

        return number1 / number2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two integers

        boolean gotIt = false;

        while (!gotIt) {
            try {

                System.out.print("Enter two integers separated by spaces: ");
                int number1 = input.nextInt();
                int number2 = input.nextInt();

                int result = quotient(number1, number2);
                System.out.println(number1 + " / " + number2 + " is "
                        + result);
                gotIt = true;
            } catch (ArithmeticException ex) {
                System.out.println("Exception: an integer " +
                        "cannot be divided by zero");
            } catch (InputMismatchException ex) {
                System.out.println(ex);
                input.nextLine(); // skip over errant value
            }
        }

        System.out.println("Execution continues ...");
    }
}