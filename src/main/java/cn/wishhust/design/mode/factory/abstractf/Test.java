package cn.wishhust.design.mode.factory.abstractf;

public class Test {
    public static void main(String[] args) {

        AbstractFactory abstractFactory = new ConcreteFactory1();
        AbstractProductA productA = abstractFactory.createProductA();
        productA.use();
    }
}
