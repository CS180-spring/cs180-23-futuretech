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

public class DeleteData {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);

        // JSON Data Reading:
        // The existing JSON data is read from a file named "output.json" and stored in the jsonData string.
        // If the file is not empty, its content is read using Files.readAllBytes() and converted to a string.
        // If there are any errors during file reading, an exception is caught and printed.

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

        // JSON Parsing:
        // If the jsonData string is not empty, it is parsed using JSONParser from the net.minidev.json.parser package.
        // If the parsing is successful, the parsed object is cast to a JSONObject.
        // If the jsonData string is empty, a new JSONObject is created and an empty JSONArray is added under the key "items_list".

        JSONObject obj;
        if (!jsonData.isEmpty()) {
            obj = (JSONObject) new JSONParser(JSONParser.MODE_PERMISSIVE).parse(jsonData);
        } else {
            obj = new JSONObject();
            obj.put("items_list", new JSONArray());
        }

        // Item Deletion:
        // The user is prompted to enter the name of the item to delete.
        // The user's input is read using the Scanner object.
        // A loop iterates over the existingList JSONArray to search for an item with a matching name.
        // If a match is found, the item is removed from the existingList.
        // A boolean flag itemFound is used to track whether the item was found or not.

        JSONArray existingList = (JSONArray) obj.get("items_list");

        // Ask the user for the item name to delete
        System.out.println("Enter the name of the item to delete:");
        String itemToDelete = scanner.nextLine();

        // Search for the item with the matching name and remove it from the existing JSON array
        boolean itemFound = false;
        for (int i = 0; i < existingList.size(); i++) {
            JSONObject item = (JSONObject) existingList.get(i);
            if (item.get("item name").equals(itemToDelete)) {
                existingList.remove(i);
                itemFound = true;
                break;
            }
        }

        // Item Not Found Handling:
        // If the itemFound flag is false, i.e., the item was not found, a message is printed indicating that the item was not found.
        
        // Output a message if the item was not found
        if (!itemFound) {
            System.out.println("Item not found.");
        }

        // JSON Data Updating and Writing:
        // The updated JSON data is written back to the file using a FileWriter.
        // A new JSONArray named updatedList is created to store the updated items.
        // The items from the existingList are iterated, and each item's properties are extracted and added to a new LinkedHashMap object.
        // The new object is then added to the updatedList.
        // The obj is updated with the updatedList and written to the file using fileWriter.write().
        // If there are any errors during file writing, an exception is caught and printed.

        // Write the updated JSON data back to the file
        try (FileWriter fileWriter = new FileWriter(file)) {
            JSONArray updatedList = new JSONArray();
            for (int i = 0; i < existingList.size(); i++) {
                JSONObject item = (JSONObject) existingList.get(i);
                Map<String, Object> newObject = new LinkedHashMap<>();
                newObject.put("name", item.get("name"));
                newObject.put("time", item.get("time"));
                newObject.put("languages", item.get("languages"));
                newObject.put("item name", item.get("item name"));
                newObject.put("Rating", item.get("Rating"));
                newObject.put("description", item.get("description"));
                updatedList.add(newObject);
            }
            obj.put("items_list", updatedList);
            fileWriter.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
