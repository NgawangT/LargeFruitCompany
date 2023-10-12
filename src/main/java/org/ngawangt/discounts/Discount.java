package org.ngawangt.discounts;
import java.util.List;
import org.ngawangt.fruits.FruitModel;
import org.ngawangt.basket.ShoppingBasket;

public interface Discount {
    boolean applies(List<FruitModel> basketItems);
    int calculateDiscount(ShoppingBasket basket);
    String getDescription();
}



