package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {
    private List<Fruit> fruits;

    public ShoppingBasket() {
        fruits = new ArrayList<>();
    }

    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (Fruit fruit : fruits) {
            totalCost += fruit.getPrice();
        }
        return totalCost;
    }

    public void getBasketItems() {
        Map<String, Integer> itemCounts = new HashMap<>();

        // Count the occurrences of each fruit
        for (Fruit fruit : fruits) {
            itemCounts.put(fruit.getName(), itemCounts.getOrDefault(fruit.getName(), 0) + 1);
        }

        // Print the items with quantities
        itemCounts.forEach((fruitName, quantity) -> {
            System.out.println(quantity + " x " + fruitName);
        });
    }
    }

