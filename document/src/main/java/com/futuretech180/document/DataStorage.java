package com.futuretech180.document;
import java.io.IOException;
import java.util.Scanner;

public class DataStorage {
        // Object Initialization:
        // An instance of the UserAccountImpl class is created and assigned to the userAccount variable.

    public static void main(String[] args) throws IOException {
        UserAccountImpl userAccount = new UserAccountImpl();

        Scanner scanner = new Scanner(System.in);

        // User Interaction Loop:
        // The program enters an infinite while loop to interact with the user until it is terminated.
        // It displays a menu of options to the user, including login, register, create a guest account, and exit.
        // The user is prompted to enter a choice (1, 2, 3, or 4) using the Scanner object.
        // The newline character is consumed to avoid issues with subsequent nextLine() calls.

        while (true) {
            System.out.println("Welcome to the FutureDB!");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Create Guest Account");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Switch Statement:
            // The user's choice is evaluated using a switch statement.

            switch (choice) {

                // Case 1: Login Option
                // The user is prompted to enter a username and password.
                // The login() method of the UserAccountImpl object is called with the provided username and password.
                
                // Login option
                case 1:     
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    userAccount.login(loginUsername, loginPassword);
                    break;

                // Case 2: Register Option
                // The user is prompted to enter a username and password.
                // The register() method of the UserAccountImpl object is called with the provided username and password.

                // Register option
                case 2:     
                    System.out.print("Enter username: ");
                    String registerUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String registerPassword = scanner.nextLine();
                    userAccount.register(registerUsername, registerPassword);

                    break;
                
                // Case 3: Create Guest Account Option
                // The createGuestAccount() method of the UserAccountImpl object is called.

                //  Login as Guest, which not finish
                case 3:     
                    userAccount.createGuestAccount();
                    break;

                // Case 4: Exit Option
                // A goodbye message is printed.
                // The Scanner object is closed to release system resources.
                // The program is terminated using System.exit(0) with an exit code of 0.
                
                //  Exit option
                case 4:     
                    System.out.println("Thank you for using the FutureDB. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                
                // Default Case:
                // If the user enters an invalid choice, an error message is displayed.
                
                default:
                    System.out.println("Invalid Choice. Please try again.");
                    break;
            }
        }
    }
}
