import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface UserAccount {
    void login(String username, String password);
    void register(String username, String password);
    void createGuestAccount();
    void mainMenu();
}

class UserAccountImpl implements UserAccount {
    private Map<String, String> accounts;
    private static final String FILE_NAME = "user_accounts.txt"; // File to store usernames and passwords

    public UserAccountImpl() {
        accounts = new HashMap<>();
        loadUserAccounts(); // Load usernames and passwords from file
    }

    @Override
    public void login(String username, String password) {
        if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
            System.out.println("Login successful! Welcome, " + username + "!");
            mainMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    @Override
    public void register(String username, String password) {
        if (!accounts.containsKey(username)) {
            accounts.put(username, password);
            saveUserAccounts(); // Save updated usernames and passwords to file
            System.out.println("Registration successful! Account created for " + username + ".");
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    @Override
    public void createGuestAccount() {
        System.out.println("Guest account created! Welcome as a guest user.");
        mainMenu();
    }
    @Override
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- FutureDB ----");
        System.out.println("1. Insert data");
        System.out.println("2. Delete data");
        System.out.println("3. Search data");
        System.out.println("4. Filter data");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.println("Inserting data...");
                // Logic for inserting data
                break;
            case 2:
                System.out.println("Deleting data...");
                // Logic for deleting data
                break;
            case 3:
                System.out.println("Searching data...");
                // Logic for searching data
                break;
            case 4:
                System.out.println("Filtering data...");
                // Logic for filtering data
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }


    private void loadUserAccounts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                accounts.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            // Ignore if file does not exist or any other IO exception occurs
        }
    }

    private void saveUserAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, String> entry : accounts.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save user accounts.");
        }
    }

}


public class UserLoginRegistration {
    public static void main(String[] args) {
        UserAccountImpl userAccount = new UserAccountImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the FutureDB!");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Create Guest Account");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    userAccount.login(loginUsername, loginPassword);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String registerUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String registerPassword = scanner.nextLine();
                    userAccount.register(registerUsername, registerPassword);
                    break;
                case 3:
                    userAccount.createGuestAccount();
                    break;
                case 4:
                    System.out.println("Thank you for using the FutureDB. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
                    break;
            }
        }
    }
}
