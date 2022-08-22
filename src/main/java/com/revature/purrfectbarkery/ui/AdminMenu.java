package com.revature.purrfectbarkery.ui;

import com.revature.purrfectbarkery.models.Product;
import com.revature.purrfectbarkery.models.Store;
import com.revature.purrfectbarkery.models.User;
import com.revature.purrfectbarkery.services.StoreService;
import com.revature.purrfectbarkery.services.UserService;
import com.revature.purrfectbarkery.services.ProductService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class AdminMenu implements IMenu {
    private final User user;
    private final UserService userService;

    private final ProductService productService;

    private final StoreService storeService;

    public AdminMenu(User user, UserService userService, ProductService productService, StoreService storeService) {
        this.user = user;
        this.userService = userService;
        this.productService = productService;
        this.storeService = storeService;
    }


    public void start() {
        System.out.println("\nWelcome to the admin menu " + user.getUsername() + "!");
        String AdminInput;
        Scanner sc = new Scanner(System.in);
        //incorporate buying items for the menu that adds stuff to the product database
        exit:
        {
            while (true) {
                System.out.println("\nWelcome to the Purrfect Barkery");
                System.out.println("[1] Check on Inventory!");
                System.out.println("[2] Check on Customers");
                System.out.println("[3] Place order to Store location for Customer");
                System.out.println("[4] Add Store Locations!");
                System.out.println("[5] Add Product to Store!");
                System.out.println("[x] Exit");

                System.out.println("\nEnter: ");
                AdminInput = sc.nextLine();

                switch (AdminInput) {
                    case "1":
                        System.out.println("\nLoading Inventory...");
                        break;
                    case "2":
                        System.out.println("\nSearching for Customer...");
                        //pathing to get user by username or login details
                        break;
                    case "3":
                        System.out.println("\nWhich store location would you like to place an order to? ");
                        //similar pathing as case 1 but diverts to ordering menu like as a customer...?
                        break;
                    case "4":
                        Store store = build();
                        storeService.addNewStore(store);
                        break;
                    case "5":
                        Product product = supply();
                        productService.addProductToStore(product);
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

    private Product addStoreInventory() {
        Scanner sc = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nViewing all inventory!");
                List<Product> productList = productService.getAllProducts();

                for (int i = 0; i < productList.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + productList.get(i).getProductname());
                }
                System.out.println("Select a product: ");
                int index = sc.nextInt() - 1;
            }
        }
    }

    private Store build() {
        String storeName = "";
        String storeLocation = "";
        Store store;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWhat would you like to call the store?! ");
        storeName = sc.nextLine();
        System.out.println("\nWhere would you like the store to be built? ");
        storeLocation = sc.nextLine();




            while (true) {
                System.out.println("\nDoes this look right to you? (y/n)");
                System.out.println("Store name: " + storeName + " Store Location: " + storeLocation);
                System.out.print("\n Enter: ");

                switch (sc.nextLine().toLowerCase()) {
                    case "y":
                        store = new Store(UUID.randomUUID().toString(), storeName, storeLocation);
                        return store;
                    case "n":
                        System.out.println("\nLet's give that another try!");
                        break;
                    default:
                        System.out.println("\nInvalid entry!");
                        break;
                }
            }
        }


    private Product supply() {
        String productName = "";
        int productPrice;
        Product product;
        Scanner sc = new Scanner(System.in);


        System.out.println("\nWhat would you like to sell in the store? ");
        productName = sc.nextLine();
        System.out.println("\nHow much are we selling this for?! ");
        productPrice = sc.nextInt();


        while (true) {
            System.out.println("\nDoes this look right to you? (y/n)");
            System.out.println("Product name: " + productName + " Product price: " + productPrice);
            System.out.print("\n Enter: ");

            switch (sc.nextLine().toLowerCase()) {
                case "y":
                    product = new Product(UUID.randomUUID().toString(), productName, productPrice);
                    return product;
                case "n":
                    System.out.println("\nLet's give that another try!");
                    break;
                default:
                    System.out.println("\nInvalid entry!");
                    break;
            }
        }

    }
}


