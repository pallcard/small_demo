package cn.wishhust.design.mode.decorator;

public class Coffee implements IDrink{
    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String describe() {
        return "coffer";
    }
}
