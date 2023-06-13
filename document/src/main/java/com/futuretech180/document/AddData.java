package com.futuretech180.document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class AddData {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);

        ArrayList<SingleReview> arrayList = new ArrayList<>();
        
        // User Input Loop:
        // The program enters a while loop, which serves as a login window page.
        // It prompts the user to enter their name or type "exit" to finish the program.
        // If the user enters "exit," the loop is terminated.
        // Otherwise, the program prompts the user to input various details such as time, language, item name, rating, and description.
        // A SingleReview object is created using the entered data and added to the arrayList.

        // Login window page
        while (true) {
            System.out.println("Enter your name or 'exit' to finish:");
            String Name = scanner.nextLine();

            // Exit the program
            if (Name.equals("exit")) {
                break;
            }

            // Input the data for document, press Enter when finish
            System.out.println("Enter the time or date:");
            String time = scanner.nextLine();

            System.out.println("Enter the language:");
            String language = scanner.nextLine();

            System.out.println("Enter the item name:");
            String item = scanner.nextLine();

            System.out.println("Enter the rating:");
            int rating = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Enter the description:");
            String description = scanner.nextLine();

            SingleReview singleReview = new SingleReview(Name, time, language, item, rating, description);
            arrayList.add(singleReview);
        }

        // JSON File Handling:
        // The program reads the existing JSON data from a file named "output.json" using the Files.readAllBytes() method.
        // If the file is not empty, the JSON data is stored in the jsonData string variable.
        // The JSONObject class from the net.minidev.json library is used to parse the JSON data.
        // If jsonData is not empty, the JSON data is parsed using a JSONParser object, and the resulting JSONObject is assigned to the obj variable.
        // If jsonData is empty, a new JSONObject is created and assigned to the obj variable. Additionally, an empty JSONArray named "items_list" is added to obj.
        
        // Read the existing JSON data from the file
        String jsonData = "";
        File file = new File("output.json");
        if (file.length() != 0) {
            try {
                jsonData = new String(Files.readAllBytes(file.toPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JSONObject obj;
        if (!jsonData.isEmpty()) {
            obj = (JSONObject) new JSONParser(JSONParser.MODE_PERMISSIVE).parse(jsonData);
        } else {
            obj = new JSONObject();
            obj.put("items_list", new JSONArray());
        }

        JSONArray existingList = (JSONArray) obj.get("items_list");

        // Adding Data to JSON:
        // The program retrieves the "items_list" JSONArray from the obj and assigns it to the existingList variable.
        // Using a for-each loop, each SingleReview object from the arrayList is processed.
        // A new LinkedHashMap named newObject is created to store the review data as key-value pairs.
        // The review data, such as name, time, language, item name, rating, and description, is added to newObject.
        // newObject is then added to the existingList JSON array.

        // Add the new data to the existing JSON array
        for (SingleReview s : arrayList) {
            Map<String, Object>  newObject = new LinkedHashMap<>();
            newObject.put("name", s.getFirstName());
            newObject.put("time", s.getTime());
            newObject.put("languages", s.getLanguage());
            newObject.put("item name", s.getItem());
            newObject.put("Rating", s.getRating());
            newObject.put("description", s.getDescription());
            existingList.add(newObject);
        }

        // Writing Updated JSON Data to File:
        // The program uses a FileWriter to write the updated JSON data (stored in obj) back to the "output.json" file using the write() method.
        // If an exception occurs during file writing, it is caught and printed.

        // Write the updated JSON data back to the file
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

// This program allows users to input review data, which is then stored in a JSON file. 
// The existing JSON data is read, new data is added to it, and the updated JSON data is written back to the file.






//============================================================================================
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import net.minidev.json.JSONArray;
//import net.minidev.json.JSONObject;
//import net.minidev.json.parser.JSONParser;
//import net.minidev.json.parser.ParseException;
//
//public class AddData {
//
//    public static void main(String[] args) throws IOException, ParseException {
//        Scanner scanner = new Scanner(System.in);
//
//        ArrayList<SingleReview> arrayList = new ArrayList<>();
//
//        while (true) {
//            System.out.println("Enter your name or 'exit' to finish:");
//            String Name = scanner.nextLine();
//
//            if (Name.equals("exit")) {
//                break;
//            }
//
//            System.out.println("Enter the time or date:");
//            String time = scanner.nextLine();
//
//            System.out.println("Enter the language:");
//            String language = scanner.nextLine();
//
//            System.out.println("Enter the item name:");
//            String item = scanner.nextLine();
//
//            System.out.println("Enter the rating:");
//            int rating = scanner.nextInt();
//
//            scanner.nextLine();
//
//            System.out.println("Enter the description:");
//            String description = scanner.nextLine();
//
//            SingleReview singleReview = new SingleReview(Name, time, language, item, rating, description);
//
//            arrayList.add(singleReview);
//        }
//        try{
//            JsonOutputer jsonOutputer = new JsonOutputer();
//            jsonOutputer.outputToJson(arrayList);
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//          scanner.close();
//    }
//}
