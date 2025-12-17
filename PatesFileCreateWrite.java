import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PatesFileCreateWrite {

    public static File checkFile(String fileName) { // Method to check if a file exists and return a File object
        File file = new File(fileName); // Creates a File object with the given name
        if (file.exists()) {
            throw new IllegalArgumentException("File " + fileName +" already exists.\n"
                    + "It is at " + file.getAbsolutePath() + "\n");
            // Throws the exception if the file already exists.
        }
        return file; // Return the file object if it does not exist
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) { // Initializes the Scanner

            System.out.print("\nWhat is your file name?"
                    + "\n> "); // Prompts user for file name

            String fileName = sc.nextLine(); // Reads user input for file name

            File file = checkFile(fileName); // Check if file exists and get the File object.

            // If the method above doesn't throw an exception, we can proceed.
            file.createNewFile(); // Create the file
            System.out.println("\nFile created: " + file.getName()); // Prints confirmation of file creation

            try (FileWriter writer = new FileWriter(file)) { // Initializes a FileWriter to write to the file
                System.out.print("\nWhat would you like to write into the file?"
                + "\n> ");
                
                String content = sc.nextLine(); // Reads user input for content to write
                
                writer.write(content); // Writes the user input into the file
                
                System.out.println("Successfully wrote to the file.\n"); // Prints confirmation of successful write

                System.out.println("File created: " + file.getName()); // Prints confirmation of file creation
                System.out.println("\nFile location: " + file.getAbsolutePath()); // Prints the absolute path of the file
                System.out.println("\n");
            } // try-with-resources automatically closes the FileWriter

        } 
        catch (IOException e) { // Catches IOExceptions that may occur during file operations
            System.out.println("An error occurred while processing the file.\n"); // Informs user of an error
        } 
        catch (IllegalArgumentException e) { // Catches exception from checkFile
            System.out.print(e.getMessage()); // Prints the custom error message
        }
        catch (Exception e) { // Catches any other errors that may occur
            System.out.println("An error occurred.\n"); // Informs user of an error
        }
    }
}
