package cn.wishhust.design.mode.factory.factoryMethod;

import cn.wishhust.design.mode.factory.simple.Computer;
import cn.wishhust.design.mode.factory.simple.Product;

public class ComputerFactory extends Factory{
    @Override
    public Product factoryMethod() {
        return new Computer("苹果",12111);
    }
}
