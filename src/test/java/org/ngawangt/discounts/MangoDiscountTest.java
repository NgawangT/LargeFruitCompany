package org.ngawangt.discounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.ngawangt.basket.ShoppingBasket;
import org.ngawangt.fruits.FruitModel;
import org.ngawangt.fruits.FruitName;


class MangoDiscountTest {
    private MangoDiscount mangoDiscount;
    private ShoppingBasket basket;

    @BeforeEach
    void setUp() {
        mangoDiscount = new MangoDiscount();
        basket = new ShoppingBasket();
    }

    @Test
    void appliesWhenMangoCountIsEqualOrGreaterThan3() {
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));

        assertTrue(mangoDiscount.applies(basket.getBasketItems()));
    }

    @Test
    void appliesWhenMangoCountIsLessThan3() {
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));
        basket.addFruit(new FruitModel(FruitName.MANGO, 250));

        assertFalse(mangoDiscount.applies(basket.getBasketItems()));
    }
}
