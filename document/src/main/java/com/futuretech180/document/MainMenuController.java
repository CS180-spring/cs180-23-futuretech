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

// @Controller Annotation:
// The @Controller annotation is used to mark the class as a Spring MVC controller.

@Controller
public class MainMenuController {

    // Request Mapping Method for Main Menu:
    // @GetMapping("/mainmenu") is a handler method that handles GET requests to "/mainmenu".
    // It returns the view name "login_success".

    @GetMapping("/mainmenu")
    public String retMainMenu(){
        return "login_success";
    }

    // Model Attributes:
    // @ModelAttribute("singleReview") is a method that provides a model attribute named "singleReview".
    // The method returns a new instance of the SingleReview class.

    @ModelAttribute("singleReview")
    public SingleReview getSingleReview(){
        return new SingleReview();
    }

    // Request Mapping Methods for Inserting and Viewing Data:
    // @GetMapping("/insert") is a handler method that handles GET requests to "/insert".
    // It returns the view name "insert_data".

    @GetMapping("/insert")
    public String showInsert(){
        return "insert_data";
    }

    // @PostMapping("/insert") is a handler method that handles POST requests to "/insert".
    // It accepts a SingleReview object annotated with @ModelAttribute and handles the insertion of the review data.
    // The method calls the AddDataHelper.addItem(review) method to add the review data.
    // It returns the view name "insert_success".

    @PostMapping("/insert")
    public String handleInsert(@ModelAttribute("review") SingleReview review) throws ParseException{
        AddDataHelper.addItem(review);
        return "insert_success";
    }

    // @GetMapping("/view") is a handler method that handles GET requests to "/view".
    // It returns the view name "view_data".
    
    @GetMapping("/view")
    public String showView(){
        return "view_data";
    }
}
