package cn.wishhust.design.mode.aop;

import java.lang.reflect.Method;

public class TestProxy extends AbstractProxy {

    @Override
    protected void before(Class<?> cls, Method method, Object[] params) {
        System.out.println("before---test");
    }

    @Override
    protected void after(Class<?> cls, Method method, Object[] params) {
        System.out.println("after---test");
    }

    @Override
    protected void error(Class<?> cls, Method method, Object[] params, Throwable e) {
        System.out.println("error---test");
    }

    @Override
    protected void end() {
        System.out.println("end---test");
    }
}
