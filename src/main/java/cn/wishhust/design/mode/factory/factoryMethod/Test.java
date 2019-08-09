package cn.wishhust.design.mode.factory.factoryMethod;

import cn.wishhust.design.mode.factory.simple.Product;

public class Test {

    public static void main(String[] args) {
        Factory computerFactory = new ComputerFactory();
        computerFactory.doSomething();

//        Product product = computerFactory.factoryMethod();
//        System.out.println(product.toString());

    }
}
