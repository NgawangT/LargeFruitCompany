package org.ngawangt.discounts;
import java.util.List;
import org.ngawangt.basket.ShoppingBasket;
import org.ngawangt.fruits.FruitModel;
import org.ngawangt.fruits.FruitName;

// Cherry Discount (50p discount if more than 4 cherries):
public class CherryDiscount implements Discount {
    @Override
    public boolean applies(List<FruitModel> basketItems) {
        int cherryCount = 0;
        for (FruitModel item : basketItems) {
            if (item.getName() == FruitName.CHERRY) {
                cherryCount += item.getitemQuantity();
            }
        }
        return cherryCount > 4;
    }

    @Override
    public int calculateDiscount(ShoppingBasket basket) {
        return 50; // 50 pence discount for more than 4 cherries
    }

    @Override
    public String getDescription() {
        return "50p discount for more than 4 cherries";
    }
}

