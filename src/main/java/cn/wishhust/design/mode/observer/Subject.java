package cn.wishhust.design.mode.observer;

public interface Subject {

    // 注册观察者
    void registerObserver(Observer o);

    // 移除观察者
    void removeObserver(Observer o);

    // 更新观察者
    void notifyObserver();

}
