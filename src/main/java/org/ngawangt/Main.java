package org.ngawangt;

import org.ngawangt.basket.ShoppingBasket;
import org.ngawangt.fruits.FruitModel;
import org.ngawangt.fruits.FruitName;
import org.ngawangt.fruits.FruitRepository;
import org.ngawangt.discounts.CherryDiscount;
import org.ngawangt.discounts.AppleDiscount;
import org.ngawangt.discounts.MangoDiscount;
import org.ngawangt.discounts.BigSpenderDiscount;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] userItems = userInput.split(" ");

        FruitRepository fruitRepository = new FruitRepository();
        Map<FruitName, FruitModel> fruitMap = fruitRepository.createProductMap();

        ShoppingBasket basket = createShoppingBasket(userItems, fruitMap);
        basket.printFruits();

        double subTotal = basket.calculateTotalCostToPounds();
        System.out.println("Sub-total £" + String.format("%.2f", subTotal));

        printDiscounts(basket);
    }

    private static ShoppingBasket createShoppingBasket(String[] userItems, Map<FruitName, FruitModel> fruitMap) {
        ShoppingBasket basket = new ShoppingBasket();

        for (String item : userItems) {
            Optional<FruitName> optionalFruitName = getFruitName(item);

            if (optionalFruitName.isPresent()) {
                FruitName fruitName = optionalFruitName.get();
                FruitModel fruit = fruitMap.get(fruitName);

                if (fruit == null) {
                    System.out.println("Fruit model not found for: " + fruitName);
                    continue;
                }
                basket.addFruit(fruit);
            } else {
                System.out.println("--- Unknown fruit entered: " + item);
            }
        }
        return basket;
    }

    private static Optional<FruitName> getFruitName(String item) {
        try {
            return Optional.of(FruitName.valueOf(item.toUpperCase()));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    private static void printDiscounts(ShoppingBasket basket) {
        AppleDiscount appleDiscount = new AppleDiscount();
        CherryDiscount cherryDiscount = new CherryDiscount();
        MangoDiscount mangoDiscount = new MangoDiscount();
        BigSpenderDiscount bigSpenderDiscount = new BigSpenderDiscount();

        if (mangoDiscount.applies(basket.getBasketItems()) || appleDiscount.applies(basket.getBasketItems()) ||
                cherryDiscount.applies(basket.getBasketItems()) || bigSpenderDiscount.applies(basket.getBasketItems())) {
            System.out.println("\nDiscounts");
        }

        int bigSpenderDeduction = 0;

        if (mangoDiscount.applies(basket.getBasketItems())) {
            int discountAmount = mangoDiscount.calculateDiscount(basket);
            System.out.println(mangoDiscount.getDescription() + discountAmount + "p");
        }
        if (cherryDiscount.applies(basket.getBasketItems())) {
            int discountAmount = cherryDiscount.calculateDiscount(basket);
            System.out.println(cherryDiscount.getDescription() + discountAmount + "p");
        }
        if (appleDiscount.applies(basket.getBasketItems())) {
            int discountAmount = appleDiscount.calculateDiscount(basket);
            System.out.println(appleDiscount.getDescription() + discountAmount + "p");
        }
        if (bigSpenderDiscount.applies(basket.getBasketItems())) {
            bigSpenderDeduction = bigSpenderDiscount.calculateDiscount(basket);
            System.out.println(bigSpenderDiscount.getDescription() + bigSpenderDeduction + "p");
        }

        System.out.println("Total £" + String.format("%.2f", (basket.calculateTotalCostToPounds() - bigSpenderDeduction / 100.0)));
    }
}
