package cn.wishhust.design.mode.aop;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Proxy> proxyList = new ArrayList<Proxy>();
        proxyList.add(new BeforeProxy());
        proxyList.add(new AfterProxy());
        proxyList.add(new TestProxy());
        proxyList.add(new Before2Proxy());

        ProxyManager proxyManager = new ProxyManager(GreetingImpl.class, proxyList);
        GreetingImpl greetingProxy = proxyManager.createProxy();

        greetingProxy.sayHello("Jack");
        System.out.println("------------------");
        System.out.println(greetingProxy.sayHello2("mike"));
    }
}
