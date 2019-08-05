package cn.wishhust.design.mode.observer;

public class ConcreteObserve implements Observer {

//    public ConcreteObserve(Subject concreteSubject) {
//        concreteSubject.registerObserver(this);
//    }

    @Override
    public void update(String msg) {
        System.out.println("ConcreteObserve1收到message:" + msg);
    }
}
