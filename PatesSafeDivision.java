import java.util.InputMismatchException; // Import Scanner class
import java.util.Scanner; // Import InputMismatchException class


public class PatesSafeDivision {
    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);

        try { // Try block performs division
            System.out.print("Enter the first integer (numerator): "); // Numberator prompt

            int numerator = sc.nextInt(); // Logs numerator input

            System.out.print("Enter the second integer (denominator): "); // Denominator prompt

            int denominator = sc.nextInt(); // Logs denominator input

            int result = numerator / denominator; // Division operation

            System.out.println("\nResult: " + result); // Print the result
            }

        catch (ArithmeticException e) { // Catches division by zero
            System.out.println("Error: Division by zero is not allowed.");
            }

        catch (InputMismatchException e) { // Catchs non-integer inputs
            System.out.println("Error: Please enter valid integers.");
            }

        finally { // Finally block to execute regardless of exceptions
            System.out.println("End of Program\n");
            sc.close();
            }
    }
}