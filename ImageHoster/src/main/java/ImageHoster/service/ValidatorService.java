package ImageHoster.service;

import ImageHoster.model.User;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidatorService {


    public boolean checkUser(User sessionUser, User imageuser) {
        if (sessionUser.getId() == imageuser.getId()) {
            return true;
        } else {
            return false;
        }
    }

    //Checks if the password contain 1 alphabet 1 number and 1 special charcter
    public boolean checkPasswordStrength(String password) {
        String regex1 = "^(?=.*?[A-Za-z])(?=(.*[\\d]){1,})(?=(.*[\\W]){1,}).{0,}$";
        Pattern p1 = Pattern.compile(regex1);
        Matcher m1 = p1.matcher(password);
        return (m1.matches());
    }
}
