package org.ngawangt.discounts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.ngawangt.basket.ShoppingBasket;
import org.ngawangt.fruits.FruitModel;
import org.ngawangt.fruits.FruitName;

class AppleDiscountTest {
    private AppleDiscount appleDiscount;
    private ShoppingBasket basket;

    @BeforeEach
    void setUp() {
        appleDiscount = new AppleDiscount();
        basket = new ShoppingBasket();
    }

    @Test
    void appliesWhenApplesInBasket() {
        // Add apple fruits to the basket
        basket.addFruit(new FruitModel(FruitName.APPLE, 80));

        assertTrue(appleDiscount.applies(basket.getBasketItems()));
    }

    @Test
    void appliesWhenNoApplesInBasket() {
        // Add other fruits (not apples) to the basket
        basket.addFruit(new FruitModel(FruitName.CHERRY, 250));

        assertFalse(appleDiscount.applies(basket.getBasketItems()));
    }

    @Test
    void calculateDiscountForNoApples() {
        // Add other fruits (not apples) to the basket
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));

        int discountAmount = appleDiscount.calculateDiscount(basket);
        assertEquals(0, discountAmount);
    }

    @Test
    void calculateDiscountForApples() {
        // Add apple fruits to the basket
        basket.addFruit(new FruitModel(FruitName.APPLE, 80));
        basket.addFruit(new FruitModel(FruitName.APPLE, 80));
        basket.addFruit(new FruitModel(FruitName.APPLE, 80));

        int discountAmount = appleDiscount.calculateDiscount(basket);
        assertEquals(24, discountAmount);
    }

    @Test
    void calculateDiscountForMangoDiscount() {
        // Add 3 mangoes and 1 apple to the basket
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));
        basket.addFruit(new FruitModel(FruitName.APPLE, 80));
        basket.addFruit(new FruitModel(FruitName.APPLE, 80));

        int discountAmount = appleDiscount.calculateDiscount(basket);
        assertEquals(8, discountAmount);
    }


}
