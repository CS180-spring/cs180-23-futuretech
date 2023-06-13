package com.futuretech180.document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class JsonOutputer {

    // Output the ArrayList of SingleReview objects to a JSON file
    public static void outputToJson(ArrayList<SingleReview> arrayList, String fileName) throws IOException {
        // Create a JSONArray to hold the reviews
        JSONArray list = new JSONArray();

        // Remove the reviews that don't match the keyword search
        arrayList.removeIf(s -> !s.keyWordSearch("1"));

        // Convert each SingleReview object to a JSON object and add it to the JSONArray
        for(SingleReview s:arrayList) {
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("name", s.getFirstName());
            obj.put("time", s.getTime());
            obj.put("languages", s.getLanguage());
            obj.put("item name",s.getItem());
            obj.put("rating", s.getRating());
            obj.put("description",s.getDescription());
            list.add(obj);
        }

        // Create the main JSONObject to hold the JSONArray
        JSONObject newObj = new JSONObject();
        newObj.put("item list", list);

        try(FileWriter file = new FileWriter(fileName)){
            // Write the JSON content to the file
            file.write(newObj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Export the ArrayList of SingleReview objects to a JSON file based on a keyword
    public static void exportFile(ArrayList<SingleReview> arrayList, String keyWord) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the file name you want to export to?");
        String fileName = scanner.nextLine();

        try {
            outputToJson(arrayList, fileName, keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Output the ArrayList of SingleReview objects to a JSON file based on a keyword
    public static void outputToJson(ArrayList<SingleReview> arrayList, String fileName, String keyWord) throws IOException {
        // Create a JSONArray to hold the reviews
        JSONArray list = new JSONArray();

        // Remove the reviews that don't match the keyword search
        arrayList.removeIf(s -> !s.keyWordSearch(keyWord));

        // Convert each SingleReview object to a JSON object and add it to the JSONArray
        for(SingleReview s:arrayList) {
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("name", s.getFirstName());
            obj.put("time", s.getTime());
            obj.put("languages", s.getLanguage());
            obj.put("item name",s.getItem());
            obj.put("rating", s.getRating());
            obj.put("description",s.getDescription());
            list.add(obj);
        }

        // Create the main JSONObject to hold the JSONArray
        JSONObject newObj = new JSONObject();
        newObj.put("item list", list);

        try(FileWriter file = new FileWriter(fileName)){
            // Write the JSON content to the file
            file.write(newObj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
