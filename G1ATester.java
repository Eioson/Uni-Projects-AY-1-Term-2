import java.util.Scanner;

class Tester{
    String username;
    int level;

    // Method that takes a Scanner to update 'this' specific instance
    public void setupPlayer(Scanner sc) {
        System.out.print("Enter Player Name: ");
        // 'this.username' refers to the field at the top of the class
        this.username = sc.nextLine();

        System.out.print("Enter Starting Level: ");
        this.level = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline
    }

    public void printStats() {
        System.out.println("--- Player Stats ---");
        System.out.println("Name: " + this.username);
        System.out.println("Level: " + this.level);
    }
}

public class G1ATester extends Tester{
    public static void main(String[] args) {
        // 1. Initialize the Scanner
        Scanner input = new Scanner(System.in);

        // 2. Create the object
        G1ATester p1 = new G1ATester();

        // 3. Use the object's method to fill its own data
        p1.setupPlayer(input);

        // 4. Output the results
        p1.printStats();

        // 5. Close the resource
        input.close();
    }
}
