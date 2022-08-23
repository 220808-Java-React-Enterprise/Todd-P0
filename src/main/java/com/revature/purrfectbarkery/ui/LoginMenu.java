package com.revature.purrfectbarkery.ui;

import com.revature.purrfectbarkery.daos.*;
import com.revature.purrfectbarkery.models.Cart;
import com.revature.purrfectbarkery.models.User;
import com.revature.purrfectbarkery.services.*;
import com.revature.purrfectbarkery.utils.custom_exceptions.InvalidUserException;

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
                        new MainMenu(user, new UserService(new UserDAO()), new StoreService(new StoreDAO()), new ProductService(new ProductDAO()), new InventoryService(new InventoryDAO()), new OrderHistoryService(new OrderHistoryDAO()), new CartService(new CartDAO())).start();
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
        String username = "";
        String password = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("\nLogging in...");

        exit: {
            while (true) {
                System.out.print("\n Enter username: ");
                username = sc.nextLine();

                System.out.print("\n Enter password: ");
                password = sc.nextLine();



                try {
                    User user = userService.login(username, password);
                    if (username.equals("toddles6")) new AdminMenu(user, new UserService(new UserDAO()), new ProductService(new ProductDAO()), new StoreService(new StoreDAO()), new InventoryService(new InventoryDAO()), new OrderHistoryService(new OrderHistoryDAO())).start();
                    else new MainMenu(user, new UserService(new UserDAO()), new StoreService(new StoreDAO()), new ProductService(new ProductDAO()), new InventoryService(new InventoryDAO()), new OrderHistoryService(new OrderHistoryDAO()), new CartService(new CartDAO())).start();
                     //pathing to the mainmenu right above, just need to differentiate from the example
                     break exit;
                } catch (InvalidUserException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }



    private User signup() {
        String username;
        String password;
        String password2;
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
                        try {
                            System.out.print("\nEnter a password: ");
                            password = sc.nextLine();

                            userService.isValidPassword(password);

                            System.out.print("\nRe-enter password: ");
                            password2 = sc.nextLine();

                            userService.checkSamePassword(password, password2);
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
                            return user;
                        case "n":
                            System.out.println("\nLet's give that another try!");
                            break confirmExit;
                        default:
                            System.out.println("\nInvalid entry!");
                            break;
                    }
                }
            }
        }
    }
}

