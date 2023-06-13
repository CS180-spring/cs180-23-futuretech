package com.futuretech180.document;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserAccount {
    private Map<String, String> accounts = new HashMap<>();
    String username;
    private String password;
    private static final String FILE_NAME = "user_accounts.txt";

    public UserAccount(){
        // accounts = new HashMap<>();
        // loadUserAccounts();
    }

    // Constructors:
    // The class has a default constructor, which initializes the accounts map.
    // Getter and Setter Methods:
    // The class provides getter and setter methods for the username and password variables.

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    // register() Method:
    // The register() method takes a username and password as parameters.
    // It checks if the username already exists in the accounts map.
    // If the username does not exist, it adds the username-password pair to the map, sets the username and password variables, and saves the updated user accounts to the file.
    // If the username already exists, it does not perform the registration.

    public void register(String username, String password){
        if (!accounts.containsKey(username)) {
            accounts.put(username, password);
            this.username = username;
            this.password = password;
            saveUserAccounts(); // Save updated usernames and passwords to file
            // System.out.println("Registration successful! Account created for " + username + ".");
        } else {
            // System.out.println("Username already exists. Please choose a different username.");
        }
    }

    // loadUserAccounts() Method:
    // This method is called internally to load user accounts from the file.
    // It reads each line from the file, splits it by comma (assuming the format is "username,password"), and adds the username-password pair to the accounts map.

    private void loadUserAccounts(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                accounts.put(parts[0], parts[1]);
            }
        }
        catch(IOException e){

        }
    }

    // saveUserAccounts() Method:
    // This method is called internally to save user accounts to the file.
    // It iterates over the entries in the accounts map and writes each username-password pair to a new line in the file.

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
