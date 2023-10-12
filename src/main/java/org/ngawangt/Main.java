package org.ngawangt;

import org.ngawangt.basket.ShoppingBasket;
import org.ngawangt.fruits.FruitModel;
import org.ngawangt.fruits.FruitRepository;
import org.ngawangt.discounts.CherryDiscount;
import org.ngawangt.discounts.AppleDiscount;
import org.ngawangt.discounts.MangoDiscount;
import org.ngawangt.discounts.BigSpenderDiscount;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] userItems = userInput.split(" ");

        // create fruitRepository instance to use createProductMap for
        // retrieving fruit data to assign as a fruit object.
        FruitRepository fruitRepository = new FruitRepository();
        Map<String, FruitModel> fruitMap = fruitRepository.createProductMap();

        ShoppingBasket basket = new ShoppingBasket();

        AppleDiscount appleDiscount = new AppleDiscount();
        CherryDiscount cherryDiscount = new CherryDiscount();
        MangoDiscount mangoDiscount = new MangoDiscount();
        BigSpenderDiscount bigSpenderDiscount = new BigSpenderDiscount();


        for (String item : userItems) {
            FruitModel fruit = fruitMap.get(item.toLowerCase());

            if (fruit == null) {
                System.out.println("Unknown fruit: " + item);
                continue;
            }
            basket.addFruit(fruit);
        }
        basket.printFruits();

        double subTotal = basket.calculateTotalCostToPounds();
        System.out.println("Sub-total £" + String.format("%.2f", subTotal ));//

        if (mangoDiscount.applies(basket.getBasketItems()) || appleDiscount.applies(basket.getBasketItems()) || cherryDiscount.applies(basket.getBasketItems()) || bigSpenderDiscount.applies(basket.getBasketItems())) {
            System.out.println("\nDiscounts");
        }


        int bigSpenderDeduction = 0;

        if (mangoDiscount.applies(basket.getBasketItems())) {
            int discountAmount = mangoDiscount.calculateDiscount(basket);
            System.out.println("1 Free Apple -" + discountAmount + "p");
        }
        if (cherryDiscount.applies(basket.getBasketItems())) {
            int discountAmount = cherryDiscount.calculateDiscount(basket);
            System.out.println("Cherry Discount -" + discountAmount + "p");
        }
        if (appleDiscount.applies(basket.getBasketItems())) {
            int discountAmount = appleDiscount.calculateDiscount(basket);
            System.out.println(appleDiscount.getDescription() + discountAmount + "p" );
        }
        if (bigSpenderDiscount.applies(basket.getBasketItems())) {
            bigSpenderDeduction= bigSpenderDiscount.calculateDiscount(basket);
            System.out.println("Big Spender Discount -" + bigSpenderDeduction + "p");
        }

        System.out.println("Total £" + String.format("%.2f", (subTotal - bigSpenderDeduction / 100.0)));
    }
}

