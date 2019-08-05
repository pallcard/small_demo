package cn.wishhust.design.mode.factory;

public class SimpleFactory {
    public Product getProduct(String name) {
        if ("phone".equals(name)) {
            return new Phone("小米", 1499);
        } else {
            return new Computer("小米", 5000);
        }
    }


    public static void main(String[] args) {
        Product phone = new SimpleFactory().getProduct("phone");
        System.out.println(phone.toString());
    }
}
