package org.ngawangt.fruits;

import java.util.Map;

public interface ProductRepository {
    Map<String, FruitModel> createProductMap();
}
