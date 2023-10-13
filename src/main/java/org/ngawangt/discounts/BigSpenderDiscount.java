package org.ngawangt.discounts;

import java.util.List;
import org.ngawangt.basket.ShoppingBasket;
import org.ngawangt.fruits.FruitModel;

public class BigSpenderDiscount implements Discount{
    @Override
    public boolean applies(List<FruitModel> basketItems) {
        int totalCostInPence = 0;
        for (FruitModel item : basketItems) {
            totalCostInPence += item.getPrice() * item.getitemQuantity();
        }
        double totalCostInPounds = totalCostInPence / 100.0;
        return totalCostInPounds > 5.0;
    }

    @Override
    public int calculateDiscount(ShoppingBasket basket) {
        List<FruitModel> basketItems = basket.getBasketItems();
        int totalCostInPence = 0;
        for (FruitModel item : basketItems) {
            totalCostInPence += item.getPrice() * item.getitemQuantity();
        }
        return totalCostInPence * 2 / 100;
    }

    @Override
    public String getDescription() {
        return "Big Spender Discount -";
    }
}

