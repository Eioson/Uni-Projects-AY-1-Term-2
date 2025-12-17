import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PatesFileDelete {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // Try-with-resources to ensure scanner is closed
            System.out.print("\nEnter the file name"
            + "\n> "); // Prompt user for file name
            String fileName = scanner.nextLine(); // Read user input for file name
            File file = new File(fileName); // Create a File object

            // Use try-with-resources for both FileReader and BufferedReader
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) { // Try to read the file
                System.out.println("\nFile contents:");
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            catch (FileNotFoundException e) { // If file not found
                System.out.println("Error: File not found: " + file.getAbsolutePath());
                return; // Exit if the file doesn't exist
            } 
            catch (IOException e) { // If an IO error occurs
                System.out.println("Error reading file: " + e.getMessage());
                return; // Exit if the file cannot be read
            }

            System.out.print("\nDo you want to delete this file? (yes/no)"
            + "\n> "); // Delete confirmation prompt
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("yes")) { // If user chooses to delete the file
                if (file.delete()) {
                    System.out.println("\nFile deleted successfully.\n");
                } 
                
                else {                                        // If deletion fails
                    System.out.println("Error: Failed to delete the file.\n");
                }
            } else { // If user chooses not to delete the file
                System.out.println("File was not deleted.\n");
            }
        }
    }
}