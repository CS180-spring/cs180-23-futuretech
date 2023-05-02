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

            /*************** First Name ****************/
            String firstName = (String) mainObj.get("firstName");
            System.out.println("First Name : " + firstName);

            /*************** Last Name ****************/
            String lastName = (String) mainObj.get("lastName");
            System.out.println("Last Name : " + lastName);

            /*************** Language ****************/
            String language = (String) mainObj.get("languages");
            System.out.println("languages: " + language);

            /*************** Item Name ****************/
            String itemName = (String) mainObj.get("item name");
            System.out.println("Item Name : " + itemName);

            /*************** Rating ****************/
            double rating = (double) mainObj.get("Rating");
            System.out.println("Rating : " + rating);

            /*************** Description ****************/
            String description = (String) mainObj.get("description");
            System.out.println("Description : " + description);
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
