package com.futuretech180.document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@Controller
public class MainMenuController {
    @GetMapping("/mainmenu")
    public String retMainMenu(){
        return "login_success";
    }


    @ModelAttribute("singleReview")
    public SingleReview getSingleReview(){
        return new SingleReview();
    }

    @GetMapping("/insert")
    public String showInsert(){
        return "insert_data";
    }

    @PostMapping("/insert")
    public String handleInsert(@ModelAttribute("review") SingleReview review) throws ParseException{
        AddDataHelper.addItem(review);
        return "insert_success";
    }


    @GetMapping("/view")
    public String showView(){
        return "view_data";
    }
}
