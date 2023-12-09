package co.uk.b.antanas.springboot.todowebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String user, String password) {
        boolean isValidUsername = user.equalsIgnoreCase("tony");
        boolean isValidPassword = password.equalsIgnoreCase("1122");

        return isValidUsername && isValidPassword;
    }
}
