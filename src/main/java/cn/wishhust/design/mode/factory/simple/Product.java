package cn.wishhust.design.mode.factory.simple;

public abstract class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.price;

    }
}
