package org.example;
import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<Fruit> fruits;

    public ShoppingBasket() {
        fruits = new ArrayList<>();
    }

    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    public void removeFruit(Fruit fruit) {
        fruits.remove(fruit);
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (Fruit fruit : fruits) {
            totalCost += fruit.getPrice();
        }
        return totalCost;
    }

    public int getFruitCount() {
        return fruits.size();
    }

    public String getBasketItems() {
        String items = "";
        for (Fruit fruit : fruits) {
            items += fruit.getName() + ", ";
        }
        if (!fruits.isEmpty()) {
            items = items.substring(0, items.length() - 2); // Remove the trailing ", "
        }
        return items;
    }


}
