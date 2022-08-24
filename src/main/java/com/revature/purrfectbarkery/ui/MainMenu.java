package com.revature.purrfectbarkery.ui;

import com.revature.purrfectbarkery.models.*;
import com.revature.purrfectbarkery.services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MainMenu implements IMenu {
    private final User user;
    private final UserService userService;
    private final StoreService storeService;
    private final ProductService productService;
    private final InventoryService inventoryService;

    private final OrderHistoryService orderHistoryService;

    private final CartService cartService;


    public MainMenu(User user, UserService userService, StoreService storeService, ProductService productService, InventoryService inventoryService, OrderHistoryService orderHistoryService, CartService cartService) {
        this.user = user;
        this.userService = userService;
        this.productService = productService;
        this.storeService = storeService;
        this.inventoryService = inventoryService;
        this.orderHistoryService = orderHistoryService;
        this.cartService = cartService;
    }


    @Override
    public void start() {

        Scanner sc = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nWelcome " + user.getUsername() + " to Purrfect Barkery!");
                System.out.println("[1] View Store Inventory: ");
                System.out.println("[2] View Cart: ");
                System.out.println("[3] View Order History: ");
                System.out.println("[4] View Store Locations: ");
                System.out.println("[x] Sign out!");

                switch (sc.nextLine()) {
                    case "1":
                        viewProducts();
                        break;
                    case "2":
                        viewCart();
                        break;
                    case "3":
                        viewOrderHistory();
                        break;
                    case "4":
                        viewStoreLocations();
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

    private void viewCart() {
        Scanner sc = new Scanner(System.in);
        String date = LocalDate.now().toString();

        OrderHistory orderHistory;


        exit:
        {
            while (true) {
                System.out.println("\nViewing your cart! ");
                List<Cart> cartList = cartService.getAllCartByCartId(user.getId());
                for (int i = 0; i < cartList.size(); i++) {
                    System.out.println("[" + (i + 1) + "] Name: " + cartList.get(i).getName() + " Quantity: " + cartList.get(i).getQuantity() + " Price: " + cartList.get(i).getCartPrice());
                }

                System.out.println("\nDoes this look right to you?");

                System.out.println("Enter y/n: ");
                switch (sc.nextLine().toLowerCase()) {
                    case "y":
                        orderHistory = new OrderHistory(UUID.randomUUID().toString(), date, user.getId());
                        orderHistoryService.addOrderHistory(orderHistory);
                        break exit;
                    case "n":
                        cartService.deleteCart(user.getId());
                        System.out.println("\nLet's give that another try!");
                        break exit;
                    default:
                        System.out.println("\nInvalid entry!");
                        break;

                }


            }
        }
    }


    private void viewProducts() {
        double total = 0.0;
        int quantity = 0;

        Scanner sc = new Scanner(System.in);

        productexit:
        {
            while (true) {
                //Lists all products
                System.out.println("\nViewing all inventory!");
                List<Product> productList = productService.getAllProducts();
                System.out.println("\n");

                for (int i = 0; i < productList.size(); i++) {
                    System.out.println("[" + (i + 1) + "]" + productList.get(i).getProductname());
                }

                System.out.println("\n");
                System.out.println("Select a product: ");
                // product index
                int index = sc.nextInt() - 1;

                try {

                    // get product from user input
                    Product selectedProduct = productList.get(index);
                    total += selectedProduct.getProductprice();


                    System.out.println("\nItem you wish to add to the cart: ");
                    System.out.println((selectedProduct.getProductname()) + " $" + selectedProduct.getProductprice());
                    System.out.println("\nHow many would you like to order? ");
                    int prodquantity = sc.nextInt();
                    System.out.println("\nQuantity: " + prodquantity);
                    System.out.println("\nTotal: $" + total * prodquantity);


                    // give new cart with updated item/quantity
                    Cart cartSave = new Cart(UUID.randomUUID().toString(), selectedProduct.getProductname(), total, prodquantity, user.getId());
                    cartService.saveCart(cartSave);
                } catch (IndexOutOfBoundsException e) {
                    // select a product outside the list bound
                    System.out.println("\nInvalid input");
                }
                break productexit;

            }


        }
    }

    private void viewOrderHistory() {

        Scanner sc = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nViewing your Order History! ");
                List<OrderHistory> orderHistories = orderHistoryService.getAllOrderHistoryByUserId(user.getId());
                for (int i = 0; i < orderHistories.size(); i++) {
                    System.out.println("[" + (i + 1) + "] Order ID: " + orderHistories.get(i).getOrderId() + " Date Purchased: " + orderHistories.get(i).getDate() + " User ID: " + orderHistories.get(i).getUsers_Id());
                }

                System.out.println("Press x to Exit! ");
                switch (sc.nextLine().toLowerCase()) {
                    case "x":
                        break exit;

                }


            }
        }

    }

    private void viewStoreLocations() {
        Scanner sc = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nViewing Store Locations! ");
                List<Store> stores = storeService.getAllStores();
                for (int i = 0; i < stores.size(); i++) {
                    System.out.println("[" + (i + 1) + "] Store Name: " + stores.get(i).getStoreName() + " Store Location: " + stores.get(i).getStoreLocation());
                }

                System.out.println("\nWe are growing!");
                System.out.println("\nKeep an eye out for a new Store near you :)");


                System.out.println("Press x to Exit! ");
                switch (sc.nextLine().toLowerCase()) {
                    case "x":
                        break exit;

                }


            }
        }

    }

}

