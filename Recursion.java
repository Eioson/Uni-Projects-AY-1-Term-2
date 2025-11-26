public class Recursion {
    
    public static void main(String[] args) {
        walk(5);
    }

    private static void walk(int steps) {
    if (steps < 1) { // base case - Stops recursion when no steps are left
        return; // Exit the method
    }
    
    System.out.println("You took a step");
    
    walk(steps-1); // recursive call with one less step
    }
}

