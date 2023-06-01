package com.futuretech180.document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class DeleteDataHelper {

    public static<T> void deleteItem(T itemToDelete,String itemType) throws IOException, ParseException {
        // Read the existing JSON data from the file
        String jsonData = "";
        String filePath = "items list.json";
        File file = new File(filePath);
        Path path = Paths.get(filePath);

        if (file.exists() && file.length() != 0) {
            try {
                jsonData = new String(Files.readAllBytes(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JSONObject obj;
        if (!jsonData.isEmpty()) {
            obj = (JSONObject) new JSONParser(JSONParser.MODE_PERMISSIVE).parse(jsonData);
        } else {
            obj = new JSONObject();
            obj.put("items list", new JSONArray());
        }

        JSONArray existingList = (JSONArray) obj.get("items list");

        // Check if the existing list is null or empty
        if (existingList == null || existingList.isEmpty()) {
            System.out.println("No items found.");
            return;
        }

        // Search for the item with the matching name and remove it from the existing JSON array
        boolean itemFound = false;
        for(Object r: existingList){
            JSONObject item = (JSONObject)r;
            if(item.get(itemType).equals(itemToDelete))
            {
                existingList.remove(r);
                itemFound =true;
                break;
            }
        }

        // Output a message to terminal if the item was not found
        if (!itemFound) {
            System.out.println("Item not found.");
        }

        // Write the updated JSON data back to the file
        updateFile(filePath,obj,existingList);
    }

    private static void updateFile(String filePath,JSONObject obj,JSONArray existingList)
    {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
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
            obj.put("items list", updatedList);
            fileWriter.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the item name to delete
        System.out.println("Enter the name of the item to delete:");
        String itemToDelete = scanner.nextLine();


        deleteItem(itemToDelete,"name");

        System.out.println("Enter the rating of the item to delete:");
        double getRating = scanner.nextDouble();
        deleteItem(getRating,"Rating");

        scanner.close();
    }
}
