import java.util.Scanner;
import java.io.*;

public class AddData {
    public static void main(String[] args) {
        try {
            // Create a FileWriter object in append mode
            FileWriter writer = new FileWriter("data.txt", true);

            // Create a BufferedWriter object
            BufferedWriter buffer = new BufferedWriter(writer);

            // Prompt the user to enter the data to be added to the file
            System.out.println("Enter the data to be added to the file: ");
            Scanner scanner = new Scanner(System.in);
            String data = scanner.nextLine();

            // Write the data to the file
            buffer.write(data);
            buffer.newLine();

            // Close the BufferedWriter and FileWriter objects
            buffer.close();
            writer.close();

            System.out.println("Data has been added to the file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
