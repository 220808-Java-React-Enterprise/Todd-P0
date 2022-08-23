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

    public boolean isValidUsername(String username){
        if (!username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$"))  throw new InvalidUserException("\nInvalid username! username is 8-20 characters long. no _ or . at the beginning. no __ or _. or ._ or .. inside.");
        return true;
    }

    public boolean isValidPassword(String password) {
        if(!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"))  throw new InvalidUserException("\nInvalid password! password must have a minimum of eight characters, at least one letter and one number:");
        return true;
    }


    public void register(User user){
        userDAO.save(user);
    }

    public User login(String username, String password) {
        User user = userDAO.getUserByUsernameAndPassword(username, password);
        if (user == null) throw new InvalidUserException("\nIncorrect username or password! ");
        return user;
    }

    public User getUserById(String id){
        return userDAO.getById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    public List<User> getAllUsernames(String username){
        return userDAO.getAllUsernames(username);
    }

    public boolean checkSamePassword (String password, String password2) {
        if (!password.equals(password2)) throw new InvalidUserException("\nSorry, these passwords do not match!");
        return true;
    }

    public boolean checkDuplicateUsername(String username){
        if (userDAO.getUsername(username) != null) throw new InvalidUserException("Sorry, " + username + " has already been taken!");
        return false;
    }
}
