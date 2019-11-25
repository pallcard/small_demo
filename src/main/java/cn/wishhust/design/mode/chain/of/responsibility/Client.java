package cn.wishhust.design.mode.chain.of.responsibility;

public class Client {
    public static void main(String[] args) {
        // 组装责任链
        ConcreteHandler handler1 = new ConcreteHandler("handler1");
        ConcreteHandler handler2 = new ConcreteHandler("handler2");
        ConcreteHandler handler3 = new ConcreteHandler("handler3");
        ConcreteHandler handler4 = new ConcreteHandler("handler4");
        ConcreteHandler handler5 = new ConcreteHandler("handler5");
        ConcreteHandler handler6 = new ConcreteHandler("handler6");
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);
        handler3.setSuccessor(handler4);
        handler4.setSuccessor(handler5);
        handler5.setSuccessor(handler6);

        // 提交请求
        handler1.handleRequest();

    }
}
