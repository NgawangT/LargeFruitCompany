package org.ngawangt.discounts;
import java.util.List;
import org.ngawangt.basket.ShoppingBasket;
import org.ngawangt.fruits.FruitModel;
import org.ngawangt.fruits.FruitName;

public class MangoDiscount implements Discount{
    @Override
    public boolean applies(List<FruitModel> basketItems) {
        int mangoCount = 0;
        for (FruitModel item : basketItems) {
            if (item.getName() == FruitName.MANGO) {
                mangoCount += item.getitemQuantity();
            }
        }
        return mangoCount >= 3;
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
        return "1 free apple for every 3 or more mangos";
    }
}

