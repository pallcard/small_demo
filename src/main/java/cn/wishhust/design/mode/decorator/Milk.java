package cn.wishhust.design.mode.decorator;

public class Milk extends DrinkDecorator{

    public Milk(IDrink drink) {
        this.drink = drink;
    }


    @Override
    public double cost() {
        return 1 + this.drink.cost();
    }

    @Override
    public String describe() {
        return  this.drink.describe() + " with milk";
    }
}
