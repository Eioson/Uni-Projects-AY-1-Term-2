import java.util.Scanner;
public class PatesAgeChecker{
    
    public static void checkAge(int age) { // Method to check age
        if (age < 18) {
            throw new IllegalArgumentException("\nAge must be 18 or older.\n");
            /* Throws the exception if age is less than 18
               IllegalArgumentException is an unchecked exception, so no need to declare it in me'thod signature
               Unchecked exceptions are checked at runtime, not compile-time   */
            }

        System.out.println("Access Granted.\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nWhat is your age?"
        + "\n> " ); // Age prompt
        int age = sc.nextInt(); // Reads age input

        try { // Tries to check the age
            checkAge(age);
        } 
        
        catch (IllegalArgumentException e) { // Catches IllegalArgumentException from checkAge method
            System.out.println(e.getMessage());
        }

        finally { // Finally block closes scanner
            sc.close();
        }
    }
}