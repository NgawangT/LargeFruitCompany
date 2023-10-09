package org.example;

public class Main {
    public static void main(String[] args) {

        Fruit apple = new Fruit("APPLE", 0.33);
        Fruit cherry = new Fruit("CHERRY", 0.10);
        Fruit mango = new Fruit("MANGO", 0.45);


        ShoppingBasket basket = new ShoppingBasket();

        basket.addFruit(apple);
        basket.addFruit(cherry);
        basket.addFruit(mango);
        basket.addFruit(apple);
        basket.addFruit(cherry);
        basket.addFruit(mango);

        System.out.println(basket.getBasketItems());
        System.out.println(basket.getFruitCount());
        System.out.println(basket.calculateTotalCost());

    }
}