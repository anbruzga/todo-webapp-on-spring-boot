package co.uk.b.antanas.springboot.todowebapp.login;

import co.uk.b.antanas.springboot.todowebapp.security.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {


    private UserContext userContext;

    @Autowired
    public WelcomeController(UserContext userContext) {
        this.userContext = userContext;
    }

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model) {
        model.put("name", userContext.getLoggedInUsername());
        return "welcome";
    }

}
