package com.revature.purrfectbarkery.ui;

import com.revature.purrfectbarkery.models.*;
import com.revature.purrfectbarkery.services.*;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class AdminMenu implements IMenu {
    private final User user;
    private final UserService userService;

    private final ProductService productService;

    private final StoreService storeService;

    private final InventoryService inventoryService;

    private final OrderHistoryService orderHistoryService;

    public AdminMenu(User user, UserService userService, ProductService productService, StoreService storeService, InventoryService inventoryService, OrderHistoryService orderHistoryService) {
        this.user = user;
        this.userService = userService;
        this.productService = productService;
        this.storeService = storeService;
        this.inventoryService = inventoryService;
        this.orderHistoryService = orderHistoryService;
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
                        viewStoreInventory();
                        break;
                    case "2":
                        System.out.println("\nSearching for Customer...");
                        viewCustomers();
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

    private void viewStoreInventory() {
        Scanner sc = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nViewing all inventory!");
                List<Product> productList = productService.getAllProducts();
                System.out.println("\n");

                for (int i = 0; i < productList.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + productList.get(i).getProductname());
                }
                System.out.println("\n");
                System.out.println("Select a product: ");
                int index = sc.nextInt() - 1;

                try {
                    Product selectedProd = productList.get(index);

                    List<Inventory> inventories = inventoryService.getAllByProdId(selectedProd.getProductid());

                    System.out.println("\n Product Name: " + selectedProd.getProductname());
                    for (Inventory p : inventories) {
                        System.out.println("Product ID: " + p.getProduct_ProductId());
                        System.out.println("Store ID: " + p.getStore_StoreId());
                        System.out.println("Quantity: " + p.getQuantity());
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\n Invalid entry!");

                }
            }

        }
    }

    private void viewCustomers() {
        Scanner sc = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nViewing all Customers!");
                System.out.println("\n");

                // get all users from userservice
                List<User> userList = userService.getAllUsers();

                // delete all admin users
                for (User u : userList) {
                    if (u.getRole().equals("ADMIN")) userList.remove(u);
                }

                // sout all users
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).getRole().equals("CUSTOMER")) {
                        System.out.println("[" + (i + 1) + "]" + userList.get(i).getUsername());
                    }
                }

                System.out.println("\n");
                System.out.println("Select an User: ");
                int index = sc.nextInt() - 1;

                try {
                    User selectedUser = userList.get(index);

                    List<OrderHistory> orderHistories = orderHistoryService.getAllOrderHistoryByUserId(selectedUser.getId());

                    System.out.println("\n User Name: " + selectedUser.getUsername());
                    for (OrderHistory oH : orderHistories) {
                        System.out.println("Product ID: " + oH.getOrderId());
                        System.out.println("Store ID: " + oH.getDate());
                        System.out.println("Quantity: " + oH.getUsers_Id());
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\n Invalid entry!");
                }
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
        double productPrice;
        int quantity;
        Product product;
        Scanner sc = new Scanner(System.in);


        System.out.println("\nWhat would you like to sell in the store? ");
        productName = sc.nextLine();
        System.out.println("\nHow much are we selling this for?! ");
        productPrice = sc.nextDouble();
        System.out.println("\nHow many are we adding to stock?");
        quantity = sc.nextInt();

        exit:
        while (true) {
            System.out.println("\nDoes this look right to you? (y/n)");
            System.out.print("\nEnter: ");
            System.out.println("Product name: " + productName + " Product price: " + productPrice);


            switch (sc.nextLine().toLowerCase()) {
                case "y":
                    product = new Product(UUID.randomUUID().toString(), productName, productPrice, quantity, supply().getStoreid());
//                    if(productName.equals(productName)) {
//                        quantity += sc.nextInt();
//                    }
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


