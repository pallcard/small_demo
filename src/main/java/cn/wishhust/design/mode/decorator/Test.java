package cn.wishhust.design.mode.decorator;

public class Test {
    public static void main(String[] args) {
        IDrink drink = new Coffee();
        drink = new Milk(drink);
        drink = new Ice(drink);
        System.out.println(drink.cost());
        System.out.println(drink.describe());

        System.out.println("+++++++++++++++");
        System.out.println("动态代理");
        System.out.println("+++++++++++++++");
        IDrink iDrink = new Coffee();
        IDrink drinkProxy =  (IDrink) new CoffeeProxyFactory(iDrink).getInstance();
        // 修改返回，存在问题
        System.out.println(drinkProxy.cost());
        System.out.println(drinkProxy.describe());



    }
}
