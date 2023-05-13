import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileReader {

    public static List<Item> readItemsFromJsonFile(String filePath) {
        List<Item> itemList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonContentBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContentBuilder.append(line);
            }
            String jsonContent = jsonContentBuilder.toString();

            JSONObject jsonObject = new JSONObject(jsonContent);
            JSONArray itemListJsonArray = jsonObject.getJSONArray("item list");

            for (int i = 0; i < itemListJsonArray.length(); i++) {
                JSONObject itemJson = itemListJsonArray.getJSONObject(i);
                itemList.add(new Item(
                        itemJson.getString("name"),
                        itemJson.getString("time"),
                        itemJson.getString("languages"),
                        itemJson.getString("item name"),
                        itemJson.getDouble("rating"),
                        itemJson.getString("description")
                ));
            }
        } catch (IOException e) {
            System.err.println("Error reading the JSON file: " + e.getMessage());
        }

        return itemList;
    }
}
