package cn.wishhust.design.mode.aop;

import java.lang.reflect.Method;

public class BeforeProxy extends AbstractProxy {

    @Override
    public void before(Class<?> cls, Method method, Object[] params) {
        System.out.println("Before");
    }
}
