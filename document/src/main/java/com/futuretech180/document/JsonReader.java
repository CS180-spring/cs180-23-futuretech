package com.futuretech180.document;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class JsonReader {
    public static void main(String[] args) {

    }

    public ArrayList<SingleReview> fileHolder = new ArrayList<>();
    public void read()
    {

    }

    public JsonReader() {
        String strJson = getJSONFile("items_list.json");

//            System.out.println("Name        Language       Item         Rating     Description");
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(strJson);
            JSONObject mainObj = (JSONObject) obj;
            JSONArray list = (JSONArray) mainObj.get("item list");

            String firstName, lastName, language;
            String itemName, description;
            double rating;
            for (int i = 0; i < list.size(); i++) {
                JSONObject oneLine = (JSONObject) list.get(i);

                firstName = (String) oneLine.get("name");
                lastName = (String) oneLine.get("time");
                language = (String) oneLine.get("languages");
                itemName = (String) oneLine.get("item name");
                rating = (double) oneLine.get("rating");
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

//        try{
//            JsonOutputer jsonOutputer = new JsonOutputer();
//            jsonOutputer.outputToJson(fileHolder);
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }

//        String keyWord = "";
//        for (SingleReview singleReview : fileHolder) {
//            System.out.println(singleReview);
//        }
    }



    public static String getJSONFile(String fileName){
        StringBuilder fileContext = new StringBuilder();
        try{
            //start to read file
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = bufferedReader.readLine()) != null){
                fileContext.append(line).append("\n");
            }
            bufferedReader.close();
            //read file done
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return fileContext.toString();
    }
}
