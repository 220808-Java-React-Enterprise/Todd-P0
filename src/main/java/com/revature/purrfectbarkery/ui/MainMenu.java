package com.revature.purrfectbarkery.ui;

import com.revature.purrfectbarkery.models.Product;
import com.revature.purrfectbarkery.models.Store;
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
                        viewStoreInventory();
                        break;
                    case "2":
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

    private void viewStoreInventory() {
        Scanner sc = new Scanner(System.in);

        exit:
        {
            System.out.println("\n Viewing Barkery locations...");

            List<Store> stores = storeService.getAllStores();

            for (int i = 0; i < stores.size(); i++) {
                System.out.println("[" + (i + 1) + "]" + stores.get(i).getStoreName());
            }
            System.out.println("\n Pick your location!");
            int index = sc.nextInt() - 1;
            //System.out.print("\nPick the purrfect treat!");


            try {
                Store selectedStore = stores.get(index);

                List<Product> products = productService.getAllProductsByStoreId(selectedStore.getStoreid());

                System.out.println("\nName: " + selectedStore.getStoreName());
                for (Product p : products) {
                    System.out.println("Product name: " + p.getProductname());
                    System.out.println("Product price: " + p.getProductprice());
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\nInvalid input!");

            }
        }
    }
}
