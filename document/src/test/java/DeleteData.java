import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class DeleteData {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);

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

        JSONObject obj;
        if (!jsonData.isEmpty()) {
            obj = (JSONObject) new JSONParser(JSONParser.MODE_PERMISSIVE).parse(jsonData);
        } else {
            obj = new JSONObject();
            obj.put("items list", new JSONArray());
        }

        JSONArray existingList = (JSONArray) obj.get("items list");

        // Ask the user for the item name to delete
        System.out.println("Enter the name of the item to delete:");
        String itemToDelete = scanner.nextLine();

        // Search for the item with the matching name and remove it from the existing JSON array
        for (int i = 0; i < existingList.size(); i++) {
            JSONObject item = (JSONObject) existingList.get(i);
            if (item.get("item name").equals(itemToDelete)) {
                existingList.remove(i);
                break;
            }
        }

        // Write the updated JSON data back to the file
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

