import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class JsonReader {
    public static void main(String[] args) {
        String strJson = getJSONFile("items list.json");
//        System.out.println(strJson);
        ArrayList<SingleReview> fileHolder = new ArrayList<>();


        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(strJson);
            JSONObject mainObj = (JSONObject) obj;
            JSONArray list = (JSONArray) mainObj.get("item list");
            System.out.println("Name        Language       Item         Rating     Description");

            String firstName, lastName, language;
            String itemName, description;
            double rating;
            for (int i = 0; i < list.size(); i++) {
                JSONObject oneLine = (JSONObject) list.get(i);

                firstName = (String) oneLine.get("firstName");
                lastName = (String) oneLine.get("lastName");
                language = (String) oneLine.get("languages");
                itemName = (String) oneLine.get("item name");
                rating = (double) oneLine.get("Rating");
                description = (String) oneLine.get("description");

                fileHolder.add(new SingleReview(firstName,lastName,language
                        ,itemName,rating,description));
//                System.out.print(firstName);
//                System.out.print(" " + lastName);
//                System.out.print("   " + language);
//                System.out.print("        " + itemName);
//                System.out.print("      " + rating);
//                System.out.println("        " + description);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        String keyWord = "";
        for (SingleReview singleReview : fileHolder) {
            if(singleReview.keyWordSearch(keyWord))
                System.out.println(singleReview);
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
