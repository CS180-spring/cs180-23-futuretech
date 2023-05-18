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
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            JSONObject json = new JSONObject(content);

            traverseSearch(json,"name", "o");

        } catch (IOException | JSONException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    public static void traverseSearch(Object json, String keyword,String v) throws JSONException
    {
        if (json instanceof JSONArray)
        {
            JSONArray jsonArray = (JSONArray) json;
            for (int i = 0; i < jsonArray.length(); i++) {
                Object element = jsonArray.get(i);

                if(element instanceof JSONObject)
                    traverseSearch(element,keyword,v);
//                else
//                    System.out.print(element + " ");
//                System.out.println();
            }
        }
        else
        if(json instanceof JSONObject)
        {
//            System.out.println("object");
            JSONObject obj = (JSONObject) json;
            Iterator keys = obj.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Object value = obj.get(key);

                if (value instanceof JSONArray) {
                    traverseSearch(value,keyword,v);
                } else {
                    if(Objects.equals(key, keyword) && ((String)value).contains(v))
                        System.out.println(key + ": " + value);
                }
            }
        }
    }

    public static void traverseWithParent(Object json, String keyword,String v,ArrayList<String> parents) throws JSONException
    {
        if(json instanceof JSONObject)
        {
            JSONObject obj = (JSONObject) json;
            Iterator keys = obj.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Object value = obj.get(key);
                if (value instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) json;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Object element = jsonArray.get(i);

                        if(element instanceof JSONObject)
                        {
                            parents.add(key);
                            traverseWithParent(element,keyword,v,parents);
                        }

                    }
                }
                else {
                    if(Objects.equals(key, keyword) && ((String)value).contains(v))
                    {
                        for (int i = 0; i < parents.size(); i++) {
                            System.out.print(parents.get(i)+": ");
                        }
                        System.out.println(key + ": " + value);
                    }

                }
            }
        }
    }

}

