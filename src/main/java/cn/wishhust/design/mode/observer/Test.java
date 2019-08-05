package cn.wishhust.design.mode.observer;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
//        ConcreteObserve concreteObserve = new ConcreteObserve(concreteSubject);
        concreteSubject.registerObserver(new ConcreteObserve());
        concreteSubject.registerObserver(new ConcreteObserve2());
        concreteSubject.registerObserver(new ConcreteObserve());
        concreteSubject.registerObserver(new ConcreteObserve2());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        concreteSubject.sendMessage("are you ok?");
    }
}
