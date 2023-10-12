package org.ngawangt.fruits;

import java.util.Map;

public interface ProductRepository {
    Map<FruitName, FruitModel> createProductMap();
}
