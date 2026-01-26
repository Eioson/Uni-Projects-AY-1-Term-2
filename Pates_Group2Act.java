import java.util.*;

class BankAccount {
    String ownerName;
    double accountNumber;
    double balance;

    // Registration method
    public void register(Scanner sc){
        System.out.print("\nEnter Owner Name: ");
        this.ownerName = sc.nextLine();
        System.out.print("Enter Account Number: ");
        this.accountNumber = sc.nextDouble();
        System.out.print("Enter Initial Balance: ");
        this.balance = sc.nextDouble();
        sc.nextLine();

        // Confirmation message and summary
        System.out.print("\nAccount Registered Successfully!\n"
        + "------ Summary ------\n"
        + "Owner Name: " + this.ownerName + "\n"
        + "Account Number: " + this.accountNumber + "\n"
        + "Balance: " + this.balance + "\n");
    }

    // Deposit method
    public void deposit(double amount){
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New Balance: " + this.balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount){
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrew: " + amount);
            System.out.println("New Balance: " + this.balance);
        } else if (amount > this.balance) {
            System.out.println("Insufficient funds for this withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Displays the balance
    public void displayBalance(){
        System.out.println("\n------ Account Details ------");
        System.out.println("\nOwner Name: " + this.ownerName);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Balance: " + this.balance + "\n");
    }
}


public class Pates_Group2Act {
    
    // A helper method to find an account
    private static BankAccount findAccount(Map<Double, BankAccount> accounts, Scanner sc) {
        System.out.print("\nEnter Account Number: ");
        double accNum = sc.nextDouble();
        sc.nextLine(); // consume newline
        return accounts.get(accNum);
    }

    public static void main(String[] args) {
        // Use a Map to store accounts, with the account number as the key.
        Map<Double, BankAccount> accounts = new HashMap<>();

        // Use a single scanner with try-with-resources to manage its lifecycle.
        try (Scanner sc = new Scanner(System.in)) {
            // Infinite loop for continuous transactions
            while (true) {
                // Main Menu
                System.out.print("\n\nWelcome to GRNEM Bank"
                + "\nWhat would you like to do?"
                + "\n1) Deposit"
                + "\n2) Withdraw"
                + "\n3) Check Balance"
                + "\n4) Register New Account"
                + "\n5) Exit"
                + "\n> ");

                int choice = 0;
                try {
                    choice = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.nextLine(); // clear the invalid input
                    continue; // go to the next loop iteration
                }
                sc.nextLine(); // Consumes the leftover newline for next input

                // Switch statement to handle user choice
                switch (choice) {
                    // Case 1: Deposit
                    case 1: {
                        BankAccount acc = findAccount(accounts, sc);
                        if (acc != null) {
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = sc.nextDouble();
                            sc.nextLine(); // consume newline
                            acc.deposit(depositAmount);
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;
                    }

                    // Case 2: Withdraw
                    case 2: {
                        BankAccount acc = findAccount(accounts, sc);
                        if (acc != null) {
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = sc.nextDouble();
                            sc.nextLine(); // consume newline
                            acc.withdraw(withdrawAmount);
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;
                    }

                    // Case 3: Check Balance
                    case 3: {
                        BankAccount acc = findAccount(accounts, sc);
                        if (acc != null) {
                            acc.displayBalance();
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;
                    }
                    
                    // Case 4: New Account Registration
                    case 4: {
                        BankAccount newAccount = new BankAccount();
                        newAccount.register(sc);
                        // Check if account number already exists
                        if(accounts.containsKey(newAccount.accountNumber)) {
                            System.out.println("An account with this number already exists. Registration failed.");
                        } else {
                            accounts.put(newAccount.accountNumber, newAccount);
                        }
                        break;
                    }

                    // Case 5: Exit
                    case 5:
                        System.out.println("Exiting. Thank you for banking with us!");
                        return;

                    // Default: Invalid choice
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } // Scanner is automatically closed here
    }
}
