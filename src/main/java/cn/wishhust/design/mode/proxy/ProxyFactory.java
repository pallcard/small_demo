package cn.wishhust.design.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("代理执行");

        Object invoke = method.invoke(target, args);

        System.out.println("代理执行");

        return invoke;
    }

    public static void main(String[] args) {
        IUserDao userDao = new UserDao();

        IUserDao userProxy = (IUserDao) new ProxyFactory(userDao).getProxyInstance();

        userProxy.savaUser();

        System.out.println("--------");

        userProxy.deleteUser();
    }
}
