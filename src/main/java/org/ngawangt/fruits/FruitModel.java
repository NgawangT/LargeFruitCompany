package org.ngawangt.fruits;

public class FruitModel{
    private FruitName fruitName;
    private int price;

    private int itemQuantity;

    public FruitModel(FruitName fruitName, int price) {
        this.fruitName = fruitName;
        this.price = price;
        this.itemQuantity = 1;
    }


    public FruitName getName() {
        return fruitName;
    }

    public int getPrice() {
        return price;
    }

    public int getitemQuantity() {
        return itemQuantity;
    }

    public void setitemQuantity(int quantity) {
        this.itemQuantity = quantity;
    }

}

