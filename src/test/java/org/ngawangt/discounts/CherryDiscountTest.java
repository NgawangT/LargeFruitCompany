package org.ngawangt.discounts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ngawangt.fruits.FruitModel;
import org.ngawangt.fruits.FruitName;
import org.ngawangt.basket.ShoppingBasket;
import java.util.List;
import java.util.ArrayList;

class CherryDiscountTest {

    private CherryDiscount cherryDiscount;
    private ShoppingBasket basket;
    @BeforeEach
    void setUp() {
        cherryDiscount = new CherryDiscount();
        basket = new ShoppingBasket();
    }

    @Test
    void appliesWhenCherryCountIsGreaterThan4() {
        List<FruitModel> basketItems = new ArrayList<>();

        // Add 5 cherry fruits to the basket
        for (int i = 0; i < 5; i++) {
            basketItems.add(new FruitModel(FruitName.CHERRY, 24));
        }

        assertTrue(cherryDiscount.applies(basketItems));
    }

    @Test
    void appliesWhenCherryCountIsEqualTo4() {
        List<FruitModel> basketItems = new ArrayList<>();

        // Add 4 cherry fruits to the basket
        for (int i = 0; i < 4; i++) {
            basketItems.add(new FruitModel(FruitName.CHERRY, 24));
        }

        assertFalse(cherryDiscount.applies(basketItems));
    }

    @Test
    void appliesWhenCherryCountIsLessThan4() {
        List<FruitModel> basketItems = new ArrayList<>();

        // Add 3 cherry fruits to the basket
        for (int i = 0; i < 3; i++) {
            basketItems.add(new FruitModel(FruitName.CHERRY, 24));
        }

        assertFalse(cherryDiscount.applies(basketItems));
    }

    @Test
    void appliesWhenNoCherryInBasket() {
        List<FruitModel> basketItems = new ArrayList<>();

        assertFalse(cherryDiscount.applies(basketItems));
    }

    @Test
    void calculateDiscountForMoreThan4Cherries() {
        // Add 5 cherry fruits to the basket
        for (int i = 0; i < 5; i++) {
            basket.addFruit(new FruitModel(FruitName.CHERRY, 24));
        }

        int discountAmount = cherryDiscount.calculateDiscount(basket);
        assertEquals(50, discountAmount);
    }

}