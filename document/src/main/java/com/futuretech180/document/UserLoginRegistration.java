package com.futuretech180.document;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//interface UserAccount {
//    void login(String username, String password);
//    void register(String username, String password);
//    void createGuestAccount();
//    void mainMenu();
//}

class UserAccountImpl{ //implements UserAccount {
    private Map<String, String> accounts;
    String username;
    String password;
    private static final String FILE_NAME = "user_accounts.txt"; // File to store usernames and passwords

    public UserAccountImpl() {
        accounts = new HashMap<>();
        loadUserAccounts(); // Load usernames and passwords from file
    }

    public String getUsername()
    {
        return username;// username+ "/" + filename.txt
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void login(String username, String password) {

        if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
            System.out.println("Login successful! Welcome, " + username + "!");
            mainMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }


    public Boolean register(String username, String password) {
        if (!accounts.containsKey(username)) {
            accounts.put(username, password);
            saveUserAccounts(); // Save updated usernames and passwords to file
            System.out.println("Registration successful! Account created for " + username + ".");
            return true;
        } else {
            System.out.println("Username already exists. Please choose a different username.");
            return false;
        }
    }

    public void createGuestAccount() {
        System.out.println("Guest account created! Welcome as a guest user.");
        mainMenu();
    }

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

