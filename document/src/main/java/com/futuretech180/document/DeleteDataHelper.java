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

// <<<<<<< alex
    public static boolean deleteItem(String user, String docName, String firstName, String itemDate, String itemLang,
            String itemName, String itemDescr) throws IOException, ParseException {
        // Read the existing JSON data from the file
        String jsonData = "";
        String filePath = "Users/" + user + "/" + docName;
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
            obj.put("items_list", new JSONArray());
        }

        JSONArray existingList = (JSONArray) obj.get("items_list");

        // Check if the existing list is null or empty
        if (existingList == null || existingList.isEmpty()) {
            System.out.println("No items found.");
            return false;
        }

        // Search for the item with the matching name and remove it from the existing
        // JSON array
        boolean itemFound = false;
        for (Object r : existingList) {
            JSONObject item = (JSONObject) r;

            if (item.get("item name").equals(itemName))
                if (item.get("description").equals(itemDescr))
                    if (item.get("time").equals(itemDate))
                        if (item.get("name").equals(firstName))
                            if (item.get("languages").equals(itemLang)) {
                                existingList.remove(r);
                                itemFound = true;
                                break;
                            }
        }

        // Output a message to terminal if the item was not found
        if (!itemFound) {
            System.out.println("Item not found.");
            return false;
        }

        // Write the updated JSON data back to the file
        updateFile(filePath, obj, existingList);
        return true;
    }

    private static void updateFile(String filePath, JSONObject obj, JSONArray existingList) {
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

    // public static void deleteItem() throws IOException, ParseException {
    // String name,descr,date;
    // Scanner scanner = new Scanner(System.in);
    // System.out.println("Enter the item name of the item to delete:");
    // name = scanner.nextLine();
    // System.out.println("Enter the description of the item to delete:");
    // descr = scanner.nextLine();
    // System.out.println("Enter the date(MM-DD-YYYY) of the item to delete:");
    // date = scanner.nextLine();
    // scanner.close();
    // deleteItem(name,descr,date);
    // }

    // public static void main(String[] args) throws IOException, ParseException {
    // DeleteDataHelper deleteDataHelper = new DeleteDataHelper();
    // DeleteDataHelper.deleteItem();
    // }
}
