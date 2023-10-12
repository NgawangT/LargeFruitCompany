package org.ngawangt.fruits;

import java.util.HashMap;
import java.util.Map;

public class FruitRepository implements ProductRepository{

    @Override
    public Map<FruitName, FruitModel> createProductMap() {
        Map<FruitName, FruitModel> fruitMap = new HashMap<>();

        // Create and store instances of Fruit for each type of fruit
        fruitMap.put(FruitName.APPLE, new FruitModel(FruitName.APPLE, 80));
        fruitMap.put(FruitName.ORANGE, new FruitModel(FruitName.ORANGE, 75));
        fruitMap.put(FruitName.MANGO, new FruitModel(FruitName.MANGO, 250));
        fruitMap.put(FruitName.CHERRY, new FruitModel(FruitName.CHERRY, 24));

        return fruitMap;
    }
}
