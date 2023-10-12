package org.ngawangt.fruits;

import java.util.HashMap;
import java.util.Map;

public class FruitRepository implements ProductRepository{

    @Override
    public Map<String, FruitModel> createProductMap() {
        Map<String, FruitModel> fruitMap = new HashMap<>();

        // Create and store instances of Fruit for each type of fruit
        fruitMap.put("apple", new FruitModel("apple", 80));
        fruitMap.put("orange", new FruitModel("orange", 75));
        fruitMap.put("mango", new FruitModel("mango", 250));
        fruitMap.put("cherry", new FruitModel("cherry", 24));

        return fruitMap;
    }
}
