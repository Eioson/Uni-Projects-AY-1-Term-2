import java.util.Scanner;
 
public class PatesChristmasTree{
    public static void main(String[] args){
        Scanner user = new Scanner(System.in); // Create a Scanner object to read input
        System.out.print("Enter the tree's height: "); // Prompt the user for the tree height
        int N = user.nextInt(); // Read the integer input
        user.nextLine(); // Consume the newline character
        drawTree(1,N); // Calls the recursive tree drawing method
        drawTrunk(N); // Calls the method to draw the trunk of the tree
        user.close();
    }
    public static void drawTree(int level, int maxLevel){
        if(level > maxLevel) return; // base case - Stops recursion when the current level exceeds max level
        for(int space = level; space < maxLevel; space ++){ // Print leading spaces
            System.out.print(" ");
        }
        for(int stars = 1; stars <= (2 * level - 1); stars++){ // Print stars for the current level
            System.out.print("*");
        }
        System.out.println(); // Move to the next line after printing stars
        drawTree(++level, maxLevel); // recursive call for the next level
    }
    public static void drawTrunk(int maxLevel){ // Method to draw the trunk of the tree
        for(int spaces = 1; spaces < maxLevel-1; spaces++){ // Print leading spaces for the trunk
            System.out.print(" ");
        }
        System.out.print("||"); // Prints the trunk itself
    }
}