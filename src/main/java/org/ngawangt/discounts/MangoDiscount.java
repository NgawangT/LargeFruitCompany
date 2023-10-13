package org.ngawangt.discounts;
import java.util.List;
import org.ngawangt.basket.ShoppingBasket;
import org.ngawangt.fruits.FruitModel;
import org.ngawangt.fruits.FruitName;

public class MangoDiscount implements Discount{
    @Override
    public boolean applies(List<FruitModel> basketItems) {
        int mangoCount = 0;
        int appleCount = 0;
        boolean apply = false;

        for (FruitModel item : basketItems) {
            if (item.getName() == FruitName.MANGO) {
                mangoCount += item.getitemQuantity();
            }
            if (item.getName() == FruitName.APPLE) {
                appleCount += item.getitemQuantity();
            }
        }
        if (mangoCount >= 3 && appleCount > 0) {
            apply = true;
        }
        return apply;
    }

    @Override
    public int calculateDiscount(ShoppingBasket basket) {
        List<FruitModel> basketItems = basket.getBasketItems();

        int itemPrice = 0;
        for (FruitModel item : basketItems) {
            if (item.getName() == FruitName.APPLE) {
                itemPrice = item.getPrice();
                break;
            }

        }
        return itemPrice;
    }

    @Override
    public String getDescription() {
        return "1 Free Apple -";
    }
}

