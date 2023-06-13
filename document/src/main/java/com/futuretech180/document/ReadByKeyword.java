package com.futuretech180.document;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class ReadByKeyword {

    public static void main(String[] args) {
        String fileName = "items list.json";
        ArrayList<String> parent = new ArrayList<>();
        try {
            // Read the content of the JSON file into a string
            String content = new String(Files.readAllBytes(Paths.get(fileName)));

            // Create a JSONObject from the JSON content
            JSONObject json = new JSONObject(content);

            // Call the traverseSearch method to search for a keyword in the JSON
            traverseSearch(json, "name", "o");

        } catch (IOException | JSONException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Traverse the JSON object recursively to search for a keyword
    public static void traverseSearch(Object json, String keyword, String v) throws JSONException {
        if (json instanceof JSONArray) {
            // If the object is a JSONArray, iterate over its elements
            JSONArray jsonArray = (JSONArray) json;
            for (int i = 0; i < jsonArray.length(); i++) {
                Object element = jsonArray.get(i);

                if (element instanceof JSONObject)
                    traverseSearch(element, keyword, v);
            }
        } else if (json instanceof JSONObject) {
            // If the object is a JSONObject, iterate over its keys and values
            JSONObject obj = (JSONObject) json;
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = obj.get(key);

                if (value instanceof JSONArray) {
                    // If the value is a JSONArray, recursively call traverseSearch on it
                    traverseSearch(value, keyword, v);
                } else {
                    // If the value is a string and matches the keyword and contains the search term,
                    // print the key-value pair
                    if (Objects.equals(key, keyword) && ((String) value).contains(v))
                        System.out.println(key + ": " + value);
                }
            }
        }
    }

    // Traverse the JSON object recursively and keep track of the parent keys
    public static void traverseWithParent(Object json, String keyword, String v, ArrayList<String> parents) throws JSONException {
        if (json instanceof JSONObject) {
            JSONObject obj = (JSONObject) json;
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = obj.get(key);
                if (value instanceof JSONArray) {
                    // If the value is a JSONArray, iterate over its elements
                    JSONArray jsonArray = (JSONArray) json;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Object element = jsonArray.get(i);

                        if (element instanceof JSONObject) {
                            // Add the current key to the parents list and recursively call traverseWithParent
                            parents.add(key);
                            traverseWithParent(element, keyword, v, parents);
                        }
                    }
                } else {
                    // If the value is a string and matches the keyword and contains the search term,
                    // print the parent keys followed by the key-value pair
                    if (Objects.equals(key, keyword) && ((String) value).contains(v)) {
                        for (int i = 0; i < parents.size(); i++) {
                            System.out.print(parents.get(i) + ": ");
                        }
                        System.out.println(key + ": " + value);
                    }
                }
            }
        }
    }
}
