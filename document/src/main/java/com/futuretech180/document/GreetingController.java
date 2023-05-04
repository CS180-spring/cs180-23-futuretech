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

    @GetMapping("/register")
    public String showForm(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user){
        System.out.println(user);
        return "register_success";
    }





    @ModelAttribute("account")
    public UserAccount getUserAccount(){
        return new UserAccount();
    }

    @GetMapping("/register2")
    public String showForm2(){
        return "register_form2";
    }

    @PostMapping("/register2")
    public String handle_form2(@ModelAttribute("account") UserAccount userAcc){
        // System.out.println(userAcc);
        
        // @ModelAttribute("userAcc")
        UserAccount newAcc = new UserAccount();
        newAcc.register(userAcc.getUsername(), userAcc.getPassword());

        // userAcc.register(userAcc.getUsername(), userAcc.getPassword());
        // System.out.println(userAcc);

        return "register_success";
    }

}
