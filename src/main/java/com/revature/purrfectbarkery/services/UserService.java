package com.revature.purrfectbarkery.services;

import com.revature.purrfectbarkery.daos.UserDAO;
import com.revature.purrfectbarkery.models.User;
import com.revature.purrfectbarkery.utils.custom_exceptions.InvalidUserException;

import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void isValidUsername(String username){
        if (!username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$"))  throw new InvalidUserException("\nInvalid username! username is 8-20 characters long. no _ or . at the beginning. no __ or _. or ._ or .. inside.");
    }

    public void isValidPassword(String password) {
        if(!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"))  throw new InvalidUserException("\nInvalid password! password must have a minimum of eight characters, at least one letter and one number:");
    }


    public void register(User user){
        userDAO.save(user);
    }

    public List<String> getAllUsernames(){
        return userDAO.getAllUsernames();
    }

    public void checkDuplicateUsername(String username){
        if (userDAO.getUsername(username) != null) throw new InvalidUserException("Sorry, " + username + "has already been taken!")
    }
}
