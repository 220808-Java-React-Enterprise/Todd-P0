package com.revature.purrfectbarkery.ui;

import com.revature.purrfectbarkery.models.User;
import com.revature.purrfectbarkery.services.UserService;
import com.revature.purrfectbarkery.utils.custom_exceptions.InvalidUserException;

import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

public class LoginMenu implements IMenu {
    private final UserService userService;

    public LoginMenu(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void start() {
        String userInput;
        Scanner sc = new Scanner(System.in);
        exit:
        {
            while (true) {
                System.out.println("\nWelcome to the Purrfect Barkery");
                System.out.println("[1] Sign in");
                System.out.println("[2] Create your Account");
                System.out.println("[x] Exit");

                System.out.println("\nEnter: ");
                userInput = sc.nextLine();

                switch (userInput) {
                    case "1":
                        login();
                        break;
                    case "2":
                        User user = signup();
                        userService.register(user);
                        new MainMenu(user).start();
                        break;
                    case "x":
                        System.out.println("\nCome back again!");
                        break exit;
                    default:
                        System.out.println("\nInvalid entry!");
                        break;
                }
            }
        }


    }

    private void login() {
        System.out.println("\nneeds implementation");
    }

    private User signup() {
        String username;
        String password;
        String name = "";
        String email = "";
        User user;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nCreating new account...");

        exit:
        {
            while (true) {
                usernameExit:
                {

                    while(true){
                        System.out.println("\nEnter a username: ");
                        username = sc.nextLine();

                        try {
                            userService.isValidUsername(username);
                            userService.checkDuplicateUsername(username);
                            break usernameExit;
                        } catch (InvalidUserException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                passwordExit:
                {

                    while(true){
                        System.out.println("\nEnter a password: ");
                        password = sc.nextLine();

                        try {
                            userService.isValidPassword(password);
                            break passwordExit;
                        } catch (InvalidUserException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                }
                System.out.println("Please enter your first and last name :)");
                name = sc.nextLine();
                System.out.println("Enter your email to receive future promotions!");
                email = sc.nextLine();

                confirmExit:{
                    System.out.println("\nDoes this look right to you? (y/n)");
                    System.out.println("Username: " + username + " Password: " + password + " Name: " + name + " Email: " + email);

                    switch (sc.nextLine().toLowerCase()){
                        case "y":
                            user = new User(UUID.randomUUID().toString(), username, password, name, email, "CUSTOMER");
                            break confirmExit;
                        case "n":
                            System.out.println("\nLet's give that another try!");
                        default:
                            System.out.println("\nInvalid entry!");
                            break;
                    }
                }
            }
        }
    }
}

