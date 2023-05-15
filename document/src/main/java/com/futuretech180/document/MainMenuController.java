package com.futuretech180.document;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Controller
public class MainMenuController {
    @ModelAttribute("singleReview")
    public SingleReview getSingleReview(){
        return new SingleReview();
    }

    @GetMapping("/insert")
    public String showInsert(){
        return "insert_data";
    }

    @PostMapping("/insert")
    public String handleInsert(@ModelAttribute("review") SingleReview review){
        
        return "insert_success";
    }


    @GetMapping("/view")
    public String showView(){
        return "view_data";
    }
}
