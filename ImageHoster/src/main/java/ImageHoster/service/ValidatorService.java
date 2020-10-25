package ImageHoster.service;

import ImageHoster.model.User;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {


    public boolean checkUser(User sessionUser, User imageuser){
       if(sessionUser.getId() == imageuser.getId()){
           return true;
       } else{
           return false;
       }
    }
}
