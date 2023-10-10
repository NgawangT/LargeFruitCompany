package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] userItems = userInput.split(" ");

        ShoppingBasket basket = new ShoppingBasket();
        for (int i = 0; i < userItems.length; i++) {
            double price = getPriceForFruit(userItems[i]);

            if (price == 0.0) {
                System.out.println("Unknown fruit: " + userItems[i]);
                continue;
            }
            basket.addFruit(new Fruit(userItems[i], price));
        }

        basket.getBasketItems();
        System.out.println("Sub-total £" + String.format("%.2f", basket.calculateTotalCost()));
    }

    private static double getPriceForFruit(String fruitName) {
        switch (fruitName.toLowerCase()) {
            case "apple":
                return 0.80;
            case "orange":
                return 0.75;
            case "mango":
                return 2.50;
            case "cherry":
                return 0.24;
            default:
                return 0.0; // 0.0 indicates an unknown fruit
        }
    }
}
