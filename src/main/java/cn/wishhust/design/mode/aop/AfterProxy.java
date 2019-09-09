package cn.wishhust.design.mode.aop;

import java.lang.reflect.Method;

public class AfterProxy extends AbstractProxy {

    @Override
    protected void after(Class<?> cls, Method method, Object[] params) {
        System.out.println("After");
    }
}
