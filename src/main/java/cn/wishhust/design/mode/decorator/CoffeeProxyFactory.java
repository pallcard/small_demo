package main.java.cn.wishhust.design.mode.decorator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CoffeeProxyFactory implements InvocationHandler {

    private Object target;

    public CoffeeProxyFactory(Object target) {
        this.target = target;
    }

    public Object getInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke;

        if ("describe".equals(method.getName())) {
            invoke = method.invoke(target, args);
            invoke += " with milk";
            return invoke;
        } else {
            invoke = method.invoke(target, args);
//            invoke = 1 + (Integer) invoke;
            return invoke;
        }

    }
}
