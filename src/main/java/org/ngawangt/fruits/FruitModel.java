package org.ngawangt.fruits;

public class FruitModel{
    private String name;
    private int price;

    private int itemQuantity;

    public FruitModel(String name, int price) {
        this.name = name;
        this.price = price;
        this.itemQuantity = 1;
    }


    public String getName() {
        return name;
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

    // look at currciuclmum page -> aside for float and double
    // big decimal class approach or use integers and / 100 (easiest approach)

}

