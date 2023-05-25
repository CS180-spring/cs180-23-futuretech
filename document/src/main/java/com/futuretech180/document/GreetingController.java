package com.futuretech180.document;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;

@Controller
public class GreetingController {

    // Request Mapping Methods:
    // @GetMapping("/greeting") is a handler method that handles GET requests to "/greeting".
    // It accepts an optional request parameter named "name" and a Model object.
    // The method adds the "name" attribute to the model and returns the view name "greeting".
    // The value of the "name" attribute is either the value of the "name" request parameter or the default value "World".
    
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    // @GetMapping("/register")
    // public String showForm(Model model){
    //     User user = new User();
    //     model.addAttribute("user", user);

    //     return "register_form";
    // }

    // @PostMapping("/register")
    // public String submitForm(@ModelAttribute("user1") User user){
    //     // System.out.println(user);
    //     return "register_success";
    // }

    // Model Attributes:
    // @ModelAttribute("account") is a method that provides a model attribute named "account".
    // The method returns a new instance of the UserAccountImpl class.

    @ModelAttribute("account")
    public UserAccountImpl getUserAccount(){
        return new UserAccountImpl();
    }
    
    // Request Mapping Methods for Login and Registration:
    //@GetMapping("/login") is a handler method that handles GET requests to "/login".
    //It returns the view name "login_form".

    @GetMapping("/login")
    public String showLogin(){
        return "login_form";
    }

    // @PostMapping("login") is a handler method that handles POST requests to "/login".
    // It accepts a UserAccountImpl object annotated with @ModelAttribute and performs login validation.
    // If the login is successful, it returns the view name "login_success"; otherwise, it returns "login_failure".

    @PostMapping("login")
    public String handle_login(@ModelAttribute("accountDisplay") UserAccountImpl userAcc){
        Boolean exists = userAcc.login(userAcc.getUsername(), userAcc.getPassword());

        if(exists){
            return "login_success";
        }
        else{
            return "login_failure";
        }
    }

    // @GetMapping("/register2") is a handler method that handles GET requests to "/register2".
    // It returns the view name "register_form2".

    @GetMapping("/register2")
    public String showForm2(){
        return "register_form2";
    }

    // @PostMapping("/register2") is a handler method that handles POST requests to "/register2".
    // It accepts a UserAccountImpl object annotated with @ModelAttribute and performs registration validation.
    // If the registration is successful, it returns the view name "register_success"; otherwise, it returns "dupe_username".

    @PostMapping("/register2")
    public String handle_form2(@ModelAttribute("accountDisplay") UserAccountImpl userAcc) throws IOException {
        // System.out.println(userAcc);
        
        Boolean unique = userAcc.register(userAcc.getUsername(), userAcc.getPassword());

        if(unique){
            return "register_success";
        }
        else{
            return "dupe_username";
        }
    }

}
