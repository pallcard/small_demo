package cn.wishhust.design.mode.factory.factoryMethod;

import cn.wishhust.design.mode.factory.simple.Phone;
import cn.wishhust.design.mode.factory.simple.Product;

public class PhoneFactory extends Factory {

    @Override
    public Product factoryMethod() {
        return new Phone("小米", 1499);
    }
}
