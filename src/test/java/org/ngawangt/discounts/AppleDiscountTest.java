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
        basket.addFruit(new FruitModel(FruitName.APPLE, 80));

        assertTrue(appleDiscount.applies(basket.getBasketItems()));
    }

    @Test
    void appliesWhenNoApplesInBasket() {
        basket.addFruit(new FruitModel(FruitName.CHERRY, 250));

        assertFalse(appleDiscount.applies(basket.getBasketItems()));
    }

    @Test
    void calculateDiscountForNoApples() {
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));

        int discountAmount = appleDiscount.calculateDiscount(basket);
        assertEquals(0, discountAmount);
    }

    @Test
    void calculateDiscountForApples() {
        basket.addFruit(new FruitModel(FruitName.APPLE, 80));
        basket.addFruit(new FruitModel(FruitName.APPLE, 80));
        basket.addFruit(new FruitModel(FruitName.APPLE, 80));

        int discountAmount = appleDiscount.calculateDiscount(basket);
        assertEquals(24, discountAmount);
    }

    @Test
    void calculateDiscountForMangoDiscount() {
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));
        basket.addFruit(new FruitModel(FruitName.APPLE, 80));
        basket.addFruit(new FruitModel(FruitName.APPLE, 80));

        int discountAmount = appleDiscount.calculateDiscount(basket);
        assertEquals(8, discountAmount);
    }


}
