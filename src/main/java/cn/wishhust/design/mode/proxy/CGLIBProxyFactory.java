package cn.wishhust.design.mode.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBProxyFactory implements MethodInterceptor {

    private Object target;

    public CGLIBProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("代理执行");
        Object invoke = method.invoke(target, args);
        System.out.println("代理执行");

        return invoke;
    }

    public static void main(String[] args) {
        UserDao target = new UserDao();
        UserDao proxy = (UserDao) new CGLIBProxyFactory(target).getProxyInstance();
        proxy.savaUser();
        System.out.println("---------");
        proxy.deleteUser();
    }


}
