import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class AddData {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);

        ArrayList<SingleReview> arrayList = new ArrayList<>();

        while (true) {
            System.out.println("Enter your name or 'exit' to finish:");
            String Name = scanner.nextLine();

            if (Name.equals("exit")) {
                break;
            }

            System.out.println("Enter the time or date:");
            String time = scanner.nextLine();

            System.out.println("Enter the language:");
            String language = scanner.nextLine();

            System.out.println("Enter the item name:");
            String item = scanner.nextLine();

            System.out.println("Enter the rating:");
            int rating = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Enter the description:");
            String description = scanner.nextLine();

            SingleReview singleReview = new SingleReview(Name, time, language, item, rating, description);
            arrayList.add(singleReview);
        }

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

        // Add the new data to the existing JSON array
        for (SingleReview s : arrayList) {
            Map<String, Object>  newObject = new LinkedHashMap<>();
            newObject.put("name", s.getFirstName());
            newObject.put("time", s.getTime());
            newObject.put("languages", s.getLanguage());
            newObject.put("item name", s.getItem());
            newObject.put("Rating", s.getRating());
            newObject.put("description", s.getDescription());
            existingList.add(newObject);
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








//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import net.minidev.json.JSONArray;
//import net.minidev.json.JSONObject;
//import net.minidev.json.parser.JSONParser;
//import net.minidev.json.parser.ParseException;
//
//public class AddData {
//
//    public static void main(String[] args) throws IOException, ParseException {
//        Scanner scanner = new Scanner(System.in);
//
//        ArrayList<SingleReview> arrayList = new ArrayList<>();
//
//        while (true) {
//            System.out.println("Enter your name or 'exit' to finish:");
//            String Name = scanner.nextLine();
//
//            if (Name.equals("exit")) {
//                break;
//            }
//
//            System.out.println("Enter the time or date:");
//            String time = scanner.nextLine();
//
//            System.out.println("Enter the language:");
//            String language = scanner.nextLine();
//
//            System.out.println("Enter the item name:");
//            String item = scanner.nextLine();
//
//            System.out.println("Enter the rating:");
//            int rating = scanner.nextInt();
//
//            scanner.nextLine();
//
//            System.out.println("Enter the description:");
//            String description = scanner.nextLine();
//
//            SingleReview singleReview = new SingleReview(Name, time, language, item, rating, description);
//
//            arrayList.add(singleReview);
//        }
//        try{
//            JsonOutputer jsonOutputer = new JsonOutputer();
//            jsonOutputer.outputToJson(arrayList);
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//          scanner.close();
//    }
//}
