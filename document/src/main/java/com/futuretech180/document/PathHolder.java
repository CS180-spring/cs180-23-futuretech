package com.futuretech180.document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathHolder {
    // Variable to store the username (folder name)
    String username;

    PathHolder(String folderName) {
        username = folderName;
    }

    // Create a user folder with the specified folder name
    public void createUserFolder(String folderName) throws IOException {
        // Set the current username to the specified folder name
        username = folderName;

        String pathToU = "Users/" + folderName;
        new File(pathToU).mkdirs();
    }

    // Get the path of the user folder
    public String getPath() {
        // Construct the path by combining the base directory with the username (folder name)
        return "/Users/" + username + "/";
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

        File file = new File(getPath() + fileName);

        return file.exists();
    }

    public static void main(String[] args) throws IOException {
        PathHolder p = new PathHolder("user1");

        System.out.println("Folder 'user1' exists: " + p.isFolderExisted("user1"));
        System.out.println("File 'sample.json' exists: " + p.isFileExisted("sample.json"));
        System.out.println("File 'sample1.json' exists: " + p.isFileExisted("sample1.json"));
        p.createUserFolder("user1");
    }
}
