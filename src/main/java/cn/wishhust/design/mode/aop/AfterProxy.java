package cn.wishhust.design.mode.aop;

import java.lang.reflect.Method;

public class AfterProxy extends AbstractProxy {

    @Override
    public void after(Class<?> cls, Method method, Object[] params) {
        System.out.println("After");
    }
}
