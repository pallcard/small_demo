package main.java.cn.wishhust.design.mode.decorator;

public class Ice extends DrinkDecorator {

    public Ice(IDrink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return 2 + this.drink.cost();
    }

    @Override
    public String describe() {
        return  this.drink.describe() + " with ice";
    }
}
