package cn.wishhust.design.mode.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

    private List<Observer> observers;

    private String msg;


    ConcreteSubject() {
        this.observers = new ArrayList<>();
    }

    public void sendMessage(String msg) {
        this.msg = msg;
        notifyObserver();
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if(index >= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(msg);
        }
    }
}
