package com.futuretech180.document;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
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


    @ModelAttribute("account")
    public UserAccountImpl getUserAccount(){
        return new UserAccountImpl();
    }
    
    @GetMapping("/login")
    public String showLogin(){
        return "login_form";
    }

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

    @GetMapping("/register2")
    public String showForm2(){
        return "register_form2";
    }

    @PostMapping("/register2")
    public String handle_form2(@ModelAttribute("accountDisplay") UserAccountImpl userAcc){
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
