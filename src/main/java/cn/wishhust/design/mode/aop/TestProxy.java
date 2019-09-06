package cn.wishhust.design.mode.aop;

import java.lang.reflect.Method;

public class TestProxy extends AbstractProxy {
    public void before(Class<?> cls, Method method, Object[] params) {
        System.out.println("before---test");
    }

    public void after(Class<?> cls, Method method, Object[] params) {
        System.out.println("after---test");
    }

    public void error(Class<?> cls, Method method, Object[] params, Throwable e) {
        System.out.println("error---test");
    }

    public void end() {
        System.out.println("end---test");
    }
}
