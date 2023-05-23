package com.futuretech180.document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathHolder {
    // The main entry point of the program
    public static void main(String[] args) throws IOException {
        // Create an instance of PathHolder with username "user1"
        PathHolder p = new PathHolder("user1");

        // Check if the folder "user1" exists and print the result
        System.out.println("Folder 'user1' exists: " + p.isFolderExisted("user1"));

        // Check if the file "sample.json" exists and print the result
        System.out.println("File 'sample.json' exists: " + p.isFileExisted("sample.json"));

        // Check if the file "sample1.json" exists and print the result
        System.out.println("File 'sample1.json' exists: " + p.isFileExisted("sample1.json"));

        // Create a folder named "user1" if it doesn't exist
        p.createUserFolder("user1");
    }

    // Variable to store the username (folder name)
    String username;

    // Constructor for the PathHolder class
    PathHolder(String folderName) {
        username = folderName;
    }

    // Create a user folder with the specified folder name
    public void createUserFolder(String folderName) throws IOException {
        // Set the current username to the specified folder name
        username = folderName;

        // Check if the folder already exists
        if (!isFolderExisted(folderName)) {
            // Create the folder if it doesn't exist
            Path path = Paths.get(getPath());
            Files.createDirectories(path);
            System.out.println("User folder '" + folderName + "' created.");
        } else {
            System.out.println("User folder '" + folderName + "' already exists.");
        }
    }

    // Get the path of the user folder
    public String getPath() {
        // Construct the path by combining the base directory with the username (folder name)
        return "/Users/stephenhuang/IdeaProjects/cs180-23-futuretech" +
                "/Users/" + username + "/";
    }

    // Check if the user folder exists
    public boolean isFolderExisted(String folderName) throws IOException {
        // Set the current username to the specified folder name
        username = folderName;

        // Create a File object representing the user folder
        File file = new File(getPath());

        // Check if the path represents a directory
        return file.isDirectory();
    }

    // Check if a file exists in the user folder
    public boolean isFileExisted(String fileName) throws IOException {
        // Create a File object representing the specified file within the user folder
        File file = new File(getPath() + fileName);

        // Check if the file exists
        return file.exists();
    }
}
