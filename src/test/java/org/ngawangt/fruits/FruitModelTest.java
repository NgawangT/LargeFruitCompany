package org.ngawangt.fruits;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class FruitModelTest {

    FruitModel cherry = new FruitModel("CHERRY", 24);
    @Test
    void getName() {
        assertEquals(cherry.getName(),"CHERRY");
    }

    @Test
    void getPrice() {
        assertEquals(cherry.getPrice(), 24);
    }

    @Test
    void getitemQuantity(){
        assertEquals(cherry.getitemQuantity(), 1);
    }

    @Test
    void setItemQuantity() {

        cherry.setitemQuantity(5);
        assertEquals(cherry.getitemQuantity(), 5);
    }
}