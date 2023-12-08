package co.uk.b.antanas.springboot.todowebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    @RequestMapping("login")
    public String login(@RequestParam String name, ModelMap model) {
        // localhost:8080/login?name=Antanas
        name = ", " + name  ;
        model.put("name", name); // Adds value to JSP
        System.out.println("Request param is " + name);
        return "login";
    }
}
