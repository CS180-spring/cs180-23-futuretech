package com.futuretech180.document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

// @Controller Annotation:
// The @Controller annotation is used to mark the class as a Spring MVC controller.

@Controller
public class MainMenuController {

    String username;
    String docName;

    @ModelAttribute("account")
    public UserAccountImpl getUserAccount() {
        return new UserAccountImpl();
    }

    // Request Mapping Methods for Login and Registration:
    // @GetMapping("/login") is a handler method that handles GET requests to
    // "/login".
    // It returns the view name "login_form".

    @GetMapping("/login")
    public String showLogin() {
        return "login_form";
    }

    // @PostMapping("login") is a handler method that handles POST requests to
    // "/login".
    // It accepts a UserAccountImpl object annotated with @ModelAttribute and
    // performs login validation.
    // If the login is successful, it returns the view name "login_success";
    // otherwise, it returns "login_failure".

    @PostMapping("login")
    public String handle_login(@ModelAttribute("accountDisplay") UserAccountImpl userAcc) {
        if (userAcc.getUsername() == "" || userAcc.getPassword() == "") {
            return "login_form";
        } else {
            Boolean exists = userAcc.login(userAcc.getUsername(), userAcc.getPassword());

            if (exists) {
                this.username = userAcc.getUsername();
                return "login_success";
            } else {
                return "login_failure";
            }
        }
    }

    // @GetMapping("/register2") is a handler method that handles GET requests to
    // "/register2".
    // It returns the view name "register_form2".

    @GetMapping("/register2")
    public String showForm2() {
        return "register_form2";
    }

    // @PostMapping("/register2") is a handler method that handles POST requests to
    // "/register2".
    // It accepts a UserAccountImpl object annotated with @ModelAttribute and
    // performs registration validation.
    // If the registration is successful, it returns the view name
    // "register_success"; otherwise, it returns "dupe_username".

    @PostMapping("/register2")
    public String handle_form2(@ModelAttribute("accountDisplay") UserAccountImpl userAcc) throws IOException {
        // System.out.println(userAcc);

        if (userAcc.getUsername() == "" || userAcc.getPassword() == "") {
            return "register_form2";
        }

        else {
            Boolean unique = userAcc.register(userAcc.getUsername(), userAcc.getPassword());

            if (unique) {
                return "register_success";
            } else {
                return "dupe_username";
            }
        }
    }

    // Request Mapping Method for Main Menu:
    // @GetMapping("/mainmenu") is a handler method that handles GET requests to
    // "/mainmenu".
    // It returns the view name "login_success".

    @GetMapping("/home")
    public String retMainMenu() {
        return "login_success";
    }

    // Model Attributes:
    // @ModelAttribute("singleReview") is a method that provides a model attribute
    // named "singleReview".
    // The method returns a new instance of the SingleReview class.

    @ModelAttribute("singleReview")
    public SingleReview getSingleReview() {
        return new SingleReview();
    }

    // Request Mapping Methods for Inserting and Viewing Data:
    // @GetMapping("/insert") is a handler method that handles GET requests to
    // "/insert".
    // It returns the view name "insert_data".

    @GetMapping("/chooseInsertDoc")
    public String showFiles(Model model) {
        String folderPath = "Users/" + this.username;

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        List<String> fileNames = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }

        model.addAttribute("fileNames", fileNames);

        return "chooseInsert_Doc";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("fileName") String fileName) {
        this.docName = fileName;
        // System.out.println("selected file: " + this.docName);
        return "insert_data";
    }

    @PostMapping("/upload-file")
    @ResponseBody
    public String handleActualFileUpload(@RequestBody String inputStr) {
        System.out.println(inputStr);
        Path source = Path.of(inputStr);
        Path target = Path.of("Users/" + this.username + "/" + inputStr);
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
        return "chooseInsert_Doc";
    }

    // @GetMapping("/insert")
    // public String showInsert() {
    // return "insert_data";
    // }

    @GetMapping("/chooseViewDoc")
    public String showFilesView(Model model) {
        String folderPath = "Users/" + this.username;

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        List<String> fileNames = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }

        model.addAttribute("fileNames", fileNames);

        return "chooseView_Doc";
    }

    @PostMapping("/upload2")
    public String handleFileUpload2(@RequestParam("fileName") String fileName) {
        this.docName = fileName;
        // System.out.println("selected file: " + this.docName);
        return "view_data";
    }

    @GetMapping("/chooseDeleteDoc")
    public String showFilesDelete(Model model) {
        String folderPath = "Users/" + this.username;

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        List<String> fileNames = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }

        model.addAttribute("fileNames", fileNames);

        return "chooseDelete_Doc";
    }

    @PostMapping("/upload3")
    public String handleFileUpload3(@RequestParam("fileName") String fileName) {
        this.docName = fileName;
        return "delete_data";
    }

    @PostMapping("/delete")
    public String handleDelete(@ModelAttribute("review") SingleReview review) throws ParseException, IOException {
        // might need to change parameter
        if (review.getFirstName() == "" || review.getTime() == "" || review.getLanguage() == ""
                || review.getItem() == "" || review.getDescription() == "") {
            return "delete_data";
        } else {
            boolean delete = DeleteDataHelper.deleteItem(this.username, this.docName, review.getFirstName(),
                    review.getTime(), review.getLanguage(), review.getItem(), review.getDescription());
            if (delete) {
                return "delete_success";
            } else {
                return "delete_failure";
            }
        }
    }

    @GetMapping("testLocation")
    @ResponseBody
    public String[] getData() {
        String[] ret = { this.username, this.docName };
        return ret;
        // return ("MainMenuController.username: " + this.username + ",
        // MainMenuController.docName: " + this.docName);
    }

    // @PostMapping("/insert") is a handler method that handles POST requests to
    // "/insert".
    // It accepts a SingleReview object annotated with @ModelAttribute and handles
    // the insertion of the review data.
    // The method calls the AddDataHelper.addItem(review) method to add the review
    // data.
    // It returns the view name "insert_success".

    @PostMapping("/insert")
    public String handleInsert(@ModelAttribute("review") SingleReview review) throws ParseException {
        if (review.getFirstName() == "" || review.getTime() == "" || review.getLanguage() == ""
                || review.getItem() == "" || review.getDescription() == "") {
            return "insert_data";
        } else {
            AddDataHelper.addItem(review, this.username, this.docName);
            return "insert_success";
        }
    }

    // @GetMapping("/view") is a handler method that handles GET requests to
    // "/view".
    // It returns the view name "view_data".

    @GetMapping("/view")
    public String showView() {
        return "view_data";
    }
}
