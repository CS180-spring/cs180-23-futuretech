package com.futuretech180.document;
import java.io.*;
import java.util.Scanner;

public class DeleteLine {
    public static void main(String[] args) {
        // Prompt the user to enter the line number to be deleted
        System.out.print("Enter the line number to be deleted: ");
        Scanner scanner = new Scanner(System.in);
        int lineNumber = scanner.nextInt();
        scanner.close();

        // The file to be modified
        File inputFile = new File("data.txt");
        File tempFile = new File("temp.txt");

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

            // Delete the original file
            inputFile.delete();

            // Rename the temporary file to the original file name
            tempFile.renameTo(inputFile);

            System.out.println("Line " + lineNumber + " has been deleted from the file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
