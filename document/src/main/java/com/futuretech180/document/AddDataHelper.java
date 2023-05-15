package com.futuretech180.document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class AddDataHelper {
    static void addItem(SingleReview oneSingleReview) throws ParseException{
        // Read the existing JSON data from the file
        String jsonData = "";
        String filePath = "C:\\Projects\\cs180\\cs180-23-futuretech\\items list.json";
        File file = new File("output.json");
        try {
            // jsonData = new String(Files.readAllBytes(file.toPath()));
            jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject obj;
        if (!jsonData.isEmpty()) {
            obj = (JSONObject) new JSONParser(JSONParser.MODE_PERMISSIVE).parse(jsonData);
        } else {
            obj = new JSONObject();
            obj.put("items list", new JSONArray());
        }

        JSONArray existingList = (JSONArray) obj.get("item list");

        // Add the new data to the existing JSON array
        Map<String, Object>  newObject = new LinkedHashMap<>();
        newObject.put("name", oneSingleReview.getFirstName());
        newObject.put("time", oneSingleReview.getTime());
        newObject.put("languages", oneSingleReview.getLanguage());
        newObject.put("item name", oneSingleReview.getItem());
        newObject.put("rating", oneSingleReview.getRating());
        newObject.put("description", oneSingleReview.getDescription());
        existingList.add(newObject);

        // Write the updated JSON data back to the file
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
