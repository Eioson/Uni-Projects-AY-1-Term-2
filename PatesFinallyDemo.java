import java.util.Scanner; // Import Scanner class

public class PatesFinallyDemo {
    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in); // Create a Scanner object to read input

        System.out.print("Enter any number: "); // Prompt the user for input
        
        String userInput = sc.nextLine(); // Read the input as a string

        try { // Try block to attempt conversion
            int number = Integer.parseInt(userInput); // Convert string to integer
            System.out.println("You entered: " + number+ "\n"); // Print the valid number
            }

        catch (Exception e) { // Catches any exception that occurs during conversion
            System.out.println("Invalid number input\n"); // Prints error message
            }

        finally { // Finally block that always executes
            System.out.println("Thank you for using this program.\n"); // Print thank you message
            sc.close(); // Close the scanner resource
        }
    }
}