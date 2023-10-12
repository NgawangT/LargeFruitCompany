package org.ngawangt.basket;
import org.ngawangt.fruits.FruitModel;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<FruitModel> basketItems;

    public ShoppingBasket() {
        this.basketItems = new ArrayList<>();
    }

    public List<FruitModel> getBasketItems() {
        return basketItems;
    }

    public void addFruit(FruitModel fruit) {
        // Check if the fruit already exists in the basket
        for (FruitModel basketItem : this.basketItems) {
            if (basketItem.equals(fruit)) {
                // If the fruit is already in the basket, increase its quantity.
                basketItem.setitemQuantity(basketItem.getitemQuantity() + 1);
                return;
            }
        }

        // If not, add the fruit with a quantity of 1 to the basket.
        fruit.setitemQuantity(1);
        this.basketItems.add(fruit);
    }


    public double calculateTotalCostToPounds() {
        int totalCostInPence = 0;
        for (FruitModel basketItem : this.basketItems) {
            totalCostInPence += basketItem.getPrice() * basketItem.getitemQuantity();
        }

        // Convert total cost from pence to pounds (divide by 100.0 to get a double result)
        double totalCostInPounds = totalCostInPence / 100.0;

        return totalCostInPounds;
    }

    public void printFruits() {
        for (FruitModel basketItem : this.basketItems) {
            System.out.println(basketItem.getitemQuantity() + " x " + basketItem.getName());
        }
    }
}