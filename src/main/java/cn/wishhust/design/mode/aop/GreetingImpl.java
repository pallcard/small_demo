package cn.wishhust.design.mode.aop;

public class GreetingImpl implements Greeting {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello! " + name);
    }

    @Override
    public String sayHello2(String name) {
        System.out.println("Hello2! " + name);
        return name;
    }
}