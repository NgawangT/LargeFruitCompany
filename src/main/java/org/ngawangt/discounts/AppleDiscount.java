package org.ngawangt.discounts;
import java.util.List;
import org.ngawangt.basket.ShoppingBasket;
import org.ngawangt.fruits.FruitModel;
import org.ngawangt.fruits.FruitName;

public class AppleDiscount implements Discount {
    @Override
    public boolean applies(List<FruitModel> basketItems) {
        // Check if there are any apples in the basket
        for (FruitModel item : basketItems) {
            if (item.getName() == FruitName.APPLE) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int calculateDiscount(ShoppingBasket basket) {
        List<FruitModel> basketItems = basket.getBasketItems();
        MangoDiscount mangoDiscount = new MangoDiscount();
        int discountInPence = 0;

        int appleCount = 0;
        int mangoCount = 0;
        int applePrice = 0;

        for (FruitModel item : basketItems) {
            if (item.getName() == FruitName.APPLE) {
                appleCount += item.getitemQuantity();
                applePrice = item.getPrice();
            }
            if (item.getName() == FruitName.MANGO) {
                mangoCount += item.getitemQuantity();
            }
        }

        // Calculate the discount for apples (10% off)
        if (appleCount > 0) {
            discountInPence += (appleCount * applePrice * 10 / 100);
        }

        // Apply the discount for getting a free apple with 3 or more mangoes
        if (mangoDiscount.applies(basketItems) && mangoCount >= 3) {
            int applesToDiscount = 1; // You should only discount 1 apple
            for (FruitModel basketItem : basketItems) {
                if (basketItem.getName() == FruitName.APPLE && applesToDiscount > 0) {
                    discountInPence -= (applePrice * 10 / 100); // Subtract the discount from the total
                    applesToDiscount--;
                }
            }
        }

        return discountInPence;
    }
    @Override
    public String getDescription() {
        return "Apple Discount -";
    }
}

