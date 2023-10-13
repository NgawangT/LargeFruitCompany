package org.ngawangt.discounts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.ngawangt.basket.ShoppingBasket;
import org.ngawangt.fruits.FruitModel;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
class BigSpenderDiscountTest {
    private BigSpenderDiscount bigSpenderDiscount;

    private ShoppingBasket basket;

    private FruitModel mockFruit;

    @BeforeEach
    void setUp() {
        bigSpenderDiscount = new BigSpenderDiscount();
        mockFruit = mock(FruitModel.class);
        basket = mock(ShoppingBasket.class);
    }

    @Test
    void doesNotApplyWhenTotalCostIsLessThan5() {
        // Add fruits with a total cost of 4 pounds
        when(mockFruit.getPrice()).thenReturn(400);
        when(mockFruit.getitemQuantity()).thenReturn(1);

        // Add the mock FruitModel object to the basket
        when(basket.getBasketItems()).thenReturn(
                List.of(mockFruit)
        );

        assertFalse(bigSpenderDiscount.applies(basket.getBasketItems()));
    }

    @Test
    void appliesWhenTotalCostIsGreaterThan5() {
        // Define the behavior of the mock FruitModel objects
        when(mockFruit.getPrice()).thenReturn(700);
        when(mockFruit.getitemQuantity()).thenReturn(1);

        when(basket.getBasketItems()).thenReturn(
                List.of(mockFruit)
        );

        assertTrue(bigSpenderDiscount.applies(basket.getBasketItems()));
    }

    @Test
    void calculateDiscountReturns0WhenDoesNotApply() {
        BigSpenderDiscount mockDiscount = mock(BigSpenderDiscount.class);

        when(mockDiscount.applies(any())).thenReturn(false);

        when(mockFruit.getPrice()).thenReturn(100);

        when(basket.getBasketItems()).thenReturn(List.of(mockFruit));

        int discount = mockDiscount.calculateDiscount(basket);

        assertEquals(0, discount); // When the discount doesn't apply, the result should be 0.
    }
}
