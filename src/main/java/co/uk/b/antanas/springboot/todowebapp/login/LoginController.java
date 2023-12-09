package co.uk.b.antanas.springboot.todowebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {


    private final AuthenticationService authenticationService;

    @Autowired
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="login",method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
        boolean authorizedLogin = authenticationService.authenticate(name, password);

        if (authorizedLogin) {
            modelMap.put("name", name);
            return "welcome";
        } else {
            String errorMsg = "Password or User is Incorrect!";
            modelMap.put("errorMsg",errorMsg);
            return "login";
        }
    }
}
