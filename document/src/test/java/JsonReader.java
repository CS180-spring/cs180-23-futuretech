import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

public class JsonReader {
    public static void main(String[] args) {
        String strJson = getJSONFile("items list.json");
//        System.out.println(strJson);


        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(strJson);
            JSONObject mainObj = (JSONObject) obj;
            JSONArray list = (JSONArray) mainObj.get("item list");
            System.out.println("Name        Language       Item         Rating     Description");

            for (int i = 0; i < list.size(); i++) {
                JSONObject oneLine = (JSONObject) list.get(i);
                /*************** First Name ****************/
                String firstName = (String) oneLine.get("firstName");
                System.out.print(firstName);

                /*************** Last Name ****************/
                String lastName = (String) oneLine.get("lastName");
                System.out.print(" " + lastName);

                /*************** Language ****************/
                String language = (String) oneLine.get("languages");
                System.out.print("   " + language);

                /*************** Item Name ****************/
                String itemName = (String) oneLine.get("item name");
                System.out.print("        " + itemName);

                /*************** Rating ****************/
                double rating = (double) oneLine.get("Rating");
                System.out.print("      " + rating);

                /*************** Description ****************/
                String description = (String) oneLine.get("description");
                System.out.println("        " + description);
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String getJSONFile(String fileName){
        String txt = "";
        try{
            //start to read file
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = bufferedReader.readLine()) != null){
                txt += line + "\n";
            }
            bufferedReader.close();
            //read file done
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return txt;
    }
}
