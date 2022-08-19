package com.revature.purrfectbarkery.ui;

import com.revature.purrfectbarkery.models.User;

public class MainMenu implements IMenu {

    private final User user;

    public MainMenu(User user) {
        this.user = user;
    }
    @Override
    public void start() {
        System.out.println("\nWelcome to the shop! " + user.getUsername() + "!");
    }
}
