package cn.wishhust.design.mode.aop;

import java.lang.reflect.Method;

public class Before2Proxy extends AbstractProxy {

    @Override
    protected void before(Class<?> cls, Method method, Object[] params) {
        System.out.println("Before2");
    }
}
