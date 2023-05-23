package com.futuretech180.document;
import java.io.*;
import java.util.Scanner;

public class DeleteLine {
    public static void main(String[] args) {

        // User Input:
        // The user is prompted to enter the line number to be deleted.
        // The input is read using a Scanner object, and the line number is stored in the lineNumber variable.
        // The Scanner object is then closed to release system resources.

        // Prompt the user to enter the line number to be deleted
        System.out.print("Enter the line number to be deleted: ");
        Scanner scanner = new Scanner(System.in);
        int lineNumber = scanner.nextInt();
        scanner.close();

        // File Initialization:
        // Two File objects, inputFile and tempFile, are created to represent the input file and a temporary file, respectively. 
        // The input file is named "data.txt", and the temporary file is named "temp.txt".

        // The file to be modified
        File inputFile = new File("data.txt");
        File tempFile = new File("temp.txt");

        // File Modification:
        // The code is wrapped in a try-catch block to handle any potential IOException.
        // A BufferedReader object is created to read the contents of the input file using a FileReader.
        // A BufferedWriter object is created to write to the temporary file using a FileWriter.
        // A loop is used to read each line from the input file and write it to the temporary file, excluding the line specified by the lineNumber.
        // The loop maintains a currentLineNumber counter to compare against the lineNumber input.
        // After the loop finishes, both the reader and writer objects are closed.

        try {
            // Create a BufferedReader object to read the input file
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            // Create a BufferedWriter object to write to the temporary file
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            // Read each line from the input file and write it to the temporary file
            String currentLine;
            int currentLineNumber = 1;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLineNumber != lineNumber) {
                    writer.write(currentLine);
                    writer.newLine();
                }
                currentLineNumber++;
            }

            // Close the reader and writer objects
            reader.close();
            writer.close();

            // File Replacement:
            // The original input file is deleted using the delete() method of the File class.
            // The temporary file is renamed to the original file name using the renameTo() method.
            // The output is printed, confirming the deletion of the specified line.

            // Delete the original file
            inputFile.delete();

            // Rename the temporary file to the original file name
            tempFile.renameTo(inputFile);

            System.out.println("Line " + lineNumber + " has been deleted from the file.");

        } 

        // Exception Handling:
        // If an IOException occurs during file operations, the stack trace is printed.
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
