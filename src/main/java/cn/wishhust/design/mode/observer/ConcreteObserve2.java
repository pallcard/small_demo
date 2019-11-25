package cn.wishhust.design.mode.observer;

public class ConcreteObserve2 implements Observer {

//    public ConcreteObserve(Subject concreteSubject) {
//        concreteSubject.registerObserver(this);
//    }

    @Override
    public void update(String msg) {
        System.out.println("ConcreteObserve2收到message:" + msg);
    }
}
