import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Objects;

public class JsonReader {

    public static void main(String[] args) {
        String fileName = "items list.json";

        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            JSONObject json = new JSONObject(content);

            traverseSearch(json,"name");

//            Iterator<String> keys = json.keys();

//            while (keys.hasNext()) {
//                String key = keys.next();
//                Object value = json.get(key);
//
//                if (value instanceof JSONArray) {
//                    JSONArray jsonArray = (JSONArray) value;
//
//                    processJSONArray(key, jsonArray);
//                } else {
//                    System.out.println("Key: " + key + ", Value: " + value);
//                }
//            }
        } catch (IOException | JSONException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    private static void traverseSearch(Object json, String keyword) throws JSONException
    {
        if (json instanceof JSONArray)
        {
            JSONArray jsonArray = (JSONArray) json;
            for (int i = 0; i < jsonArray.length(); i++) {
                Object element = jsonArray.get(i);

                if(element instanceof JSONObject)
                    traverseSearch(element,keyword);
                else
                    System.out.print(element + " ");
                System.out.println();
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
                    traverseSearch(value,keyword);
                } else {
                    System.out.println(key + ": " + value);
                }
            }
        }
    }

    private static void processJSONArray(String key, JSONArray jsonArray) throws JSONException {
//        System.out.println("Key: " + key + ", Values:");

        for (int i = 0; i < jsonArray.length(); i++) {
            Object element = jsonArray.get(i);

            if (element instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) element;
                Iterator<String> elementKeys = jsonObject.keys();
                while (elementKeys.hasNext()) {
                    String elementKey = elementKeys.next();
                    Object elementValue = jsonObject.get(elementKey);
                    System.out.println("Key: " + elementKey + ", Value: " + elementValue);
                }
            } else if (element instanceof JSONArray) {
                processJSONArray(key, (JSONArray) element);
            }
        }

    }
}
