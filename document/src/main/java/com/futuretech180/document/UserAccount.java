package com.futuretech180.document;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserAccount {
    private Map<String, String> accounts;
    String username;
    private String password;
    private static final String FILE_NAME = "user_accounts.txt";

    public UserAccount(){
        accounts = new HashMap<>();
        // loadUserAccounts();
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public void register(String username, String password){
        if (!accounts.containsKey(username)) {
            accounts.put(username, password);
            this.username = username;
            this.password = password;
            // saveUserAccounts(); // Save updated usernames and passwords to file
            // System.out.println("Registration successful! Account created for " + username + ".");
        } else {
            // System.out.println("Username already exists. Please choose a different username.");
        }
    }

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
