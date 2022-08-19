package com.revature.purrfectbarkery.utils;

import com.revature.purrfectbarkery.daos.UserDAO;
import com.revature.purrfectbarkery.services.UserService;
import com.revature.purrfectbarkery.ui.LoginMenu;
import com.revature.purrfectbarkery.utils.database.ConnectionFactory;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
       new LoginMenu(new UserService(new UserDAO())).start();



    }
}
