package cn.wishhust.design.mode.factory.factoryMethod;

import cn.wishhust.design.mode.factory.simple.Product;

public abstract class Factory {

    abstract public Product factoryMethod();

    public void doSomething() {
        Product product = factoryMethod();

        // todo
    }

}
