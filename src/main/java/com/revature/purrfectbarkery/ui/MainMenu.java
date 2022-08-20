package com.revature.purrfectbarkery.ui;

import com.revature.purrfectbarkery.models.Product;
import com.revature.purrfectbarkery.models.User;
import com.revature.purrfectbarkery.services.ProductService;
import com.revature.purrfectbarkery.services.StoreService;
import com.revature.purrfectbarkery.services.UserService;

import java.util.List;
import java.util.Scanner;

public class MainMenu implements IMenu {
    private final User user;
    private final UserService userService;
    private final StoreService storeService;
    private final ProductService productService;


    public MainMenu(User user, UserService userService, StoreService storeService, ProductService productService) {
        this.user = user;
        this.userService = userService;
        this.productService = productService;
        this.storeService = storeService;
    }


    @Override
    public void start() {
        Scanner sc = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nWelcome " + user.getUsername() + " to Purrfect Barkery!");
                System.out.println("[1] View Store Inventory");
                System.out.println("[2] View Store Locations");
                System.out.println("[x] Sign out!");

                switch (sc.nextLine()) {
                    case "1":
                        System.out.println("woohoo");
                        //viewStoreInventory();
                        break;
                    case "2":
                        //viewStoreLocations();
                        System.out.println("needs work");
                        break;
                    case "x":
                        break exit;
                    default:
                        System.out.println("\nInvalid entry!");
                        break;
                }
            }
        }
    }

//    private void viewStoreInventory() {
//        Scanner sc = new Scanner(System.in);
//
//        exit: {
//            System.out.println("\n Viewing Inventory...");
//            List<Product> prods  = ProductService.getAllProducts();
//
//            for (int i =0; i <prods.size(); i++) {
//                System.out.println("[" + (i+1) + "]" + prods.get(i).getProductname());
//            }
//            System.out.print("\nPick the purrfect treat!");
//            int index = sc.nextInt() - 1;
//
//            //try {
//               // Product selectedProduct = prods.get(index);
//
//                //list price and what type of treat it is?
//
//            //}
//        }
//    }
}
