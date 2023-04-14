package com.org.trs.seivice;

import com.org.trs.exception.*;
import com.org.trs.model.User;
import com.org.trs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*This class is responsible for taking care of business validation & business operation*/
@Service
public class RegistrationService {
    @Autowired
    UserRepository userRepository;
//    String reg1 = "^[a-zA-Z0-9]{4,15}+$";
//    String reg2 = "^[a-zA-Z0-9]{8,15}+$";
    String reg1 = "^[a-zA-Z]{1,9}";
    String reg2 = "^[a-zA-Z]{3,10}";

    public String registerUser(User user) throws TrsBootException{
        String registrationMessage = null;
        validateUser(user);
        registrationMessage = userRepository.registerUser();
        return registrationMessage;
    }

    private void validateUser(User user) throws TrsBootException{
        if (!isValidUser(user.getUserId()))
            throw new InvalidUserIdException("RegistrationService.INVALID_USER_ID");
        if (!isValidPassword(user.getPassword())) throw new InvalidPasswordException("RegistrationService.INVALID_PASSWORD");
        if (!isValidName(user.getName())) throw new InvalidNameException("RegistrationService.INVALID_NAME");


        if (!isValidCity(user.getCity())) throw new InvalidCityException("RegistrationService.INVALID_CITY");

        if(!isValidEmail(user.getEmail())) throw new InvalidEmailException("RegistrationService.INVALID_EMAIL");
        if(!isValidPhone(user.getPhone())) throw new InvalidPhoneException("RegistrationService.INVALID_PHONE");

    }
    public boolean isValidUser(String userId){
        boolean b1= false;
        Pattern a = Pattern.compile(reg1);
        Matcher b = a.matcher(userId);
        if (b.matches()){
            b1= true;
        }
        return b1;
    }

    public boolean isValidPassword(String password){
        boolean b1 = false;
        Pattern a = Pattern.compile(reg2);
        Matcher b = a.matcher(password);
        if (b.matches()) {
            b1 = true;
        }
        return b1;
    }
    public boolean isValidName(String name){
        boolean b1 = false;
        String reg3 = "^[a-zA-Z]{3,12}";
        Pattern a = Pattern.compile(reg3);
        Matcher b = a.matcher(name);
        if (b.matches())
            b1 = true;
        return b1;
    }
    public boolean isValidEmail(String email){
        String reg5 = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}";
        boolean b1 = false;
        Pattern a = Pattern.compile(reg5);
        Matcher b = a.matcher(email);

        boolean c =  b.matches();
        if(c)
            b1 = true;
        return b1;
    }
    public boolean isValidPhone(String phone){
        String reg6 = "^[0-9]{10}";
        boolean b1 = false;

        Pattern a = Pattern.compile(reg6);
        Matcher b = a.matcher(phone);

        boolean c = b.matches();
        if(c)
            b1= true;
        return b1;
    }
    public boolean isValidCity(String city)  {
        boolean b1 = false;
        String reg4 = "^[a-zA-Z]{3,10}";
        Pattern a = Pattern.compile(reg4);
        Matcher b = a.matcher(city);
        if (b.matches())
            b1 = true;
        return b1;
    }




















}
