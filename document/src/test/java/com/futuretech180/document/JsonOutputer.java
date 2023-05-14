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

    public static void outputToJson(ArrayList<SingleReview> arrayList, String fileName) throws IOException {

        JSONArray list = new JSONArray();

        arrayList.removeIf(s -> !s.keyWordSearch("1"));

        for(SingleReview s:arrayList)
        {
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("name", s.getFirstName());
            obj.put("time", s.getTime());
            obj.put("languages", s.getLanguage());
            obj.put("item name",s.getItem());
            obj.put("rating", s.getRating());
            obj.put("description",s.getDescription());
            list.add(obj);
        }


        JSONObject newObj = new JSONObject();
        newObj.put("item list", list);

        try(FileWriter file = new FileWriter(fileName)){
            file.write(newObj.toJSONString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
//        System.out.println(list);
    }

    public static void exportFile(ArrayList<SingleReview> arrayList,String keyWord)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the file name your want to export to?");
        String fileName = scanner.nextLine();

        try{
            outputToJson(arrayList,fileName,keyWord);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void outputToJson(ArrayList<SingleReview> arrayList, String fileName,String keyWord) throws IOException {

        JSONArray list = new JSONArray();

        arrayList.removeIf(s -> !s.keyWordSearch(keyWord));

        for(SingleReview s:arrayList)
        {
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("name", s.getFirstName());
            obj.put("time", s.getTime());
            obj.put("languages", s.getLanguage());
            obj.put("item name",s.getItem());
            obj.put("rating", s.getRating());
            obj.put("description",s.getDescription());
            list.add(obj);
        }


        JSONObject newObj = new JSONObject();
        newObj.put("item list", list);

        try(FileWriter file = new FileWriter(fileName)){
            file.write(newObj.toJSONString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
//        System.out.println(list);
    }

}
