package com.futuretech180.document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class AddDataHelper {

    // addItem Method:
    // The addItem method takes a SingleReview object as a parameter and is declared with a throws ParseException clause, indicating that it may throw a ParseException 

    static void addItem(SingleReview oneSingleReview, String username, String docName) throws ParseException{
        
        // Read the existing JSON data from the file
        String jsonData = "";
        // String filePath = "items_list.json";
        String filePath = "Users/" + username + "/" + docName;
        File file = new File(filePath);
        Path path = Paths.get(filePath);

        // File Handling:
        // The method initializes variables related to file handling.
        // The JSON data is read from a file named "items_list.json".
        // The file data is stored in the jsonData string variable.
        // The File and Path objects are created using the file path.
        // The file contents are read using the Files.readAllBytes() method and stored in jsonData.

        try {
            // jsonData = new String(Files.readAllBytes(file.toPath()));
            jsonData = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JSON Parsing:
        // A JSONObject named obj is declared to hold the parsed JSON data.
        // If jsonData is not empty, the JSON data is parsed using a JSONParser object in permissive mode, and the resulting JSONObject is assigned to obj.
        // If jsonData is empty, a new JSONObject is created and assigned to obj. Additionally, an empty JSONArray named "items_list" is added to obj.

        JSONObject obj;
        if (!jsonData.isEmpty()) {
            obj = (JSONObject) new JSONParser(JSONParser.MODE_PERMISSIVE).parse(jsonData);
        } else {
            obj = new JSONObject();
            obj.put("items_list", new JSONArray());
        }

        // Accessing Existing JSON Array:
        // The program retrieves the "items_list" JSONArray from the obj and assigns it to the existingList variable.

        JSONArray existingList = (JSONArray) obj.get("items_list");

        //Adding Data to JSON Array:
        // A new LinkedHashMap named newObject is created to store the review data as key-value pairs.
        // The review data, such as language, name, rating, description, time, and item name, is added to newObject.
        // newObject is then added to the existingList JSON array.

        // Add the new data to the existing JSON array
        Map<String, Object>  newObject = new LinkedHashMap<>();
        newObject.put("languages", oneSingleReview.getLanguage());
        newObject.put("name", oneSingleReview.getFirstName());
        newObject.put("rating", oneSingleReview.getRating());
        newObject.put("description", oneSingleReview.getDescription());
        newObject.put("time", oneSingleReview.getTime());
        newObject.put("item name", oneSingleReview.getItem());  
        existingList.add(newObject);

        // Writing Updated JSON Data to File:
        // The method uses a FileWriter to write the updated JSON data (stored in obj) back to the "items_list.json" file using the write() method.
        // If an exception occurs during file writing, it is caught and printed.
        
        // Write the updated JSON data back to the file
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// By calling the addItem method with a SingleReview object, a username, and a document name.
// You can add the review data to the JSON array in the "items_list.json" file.