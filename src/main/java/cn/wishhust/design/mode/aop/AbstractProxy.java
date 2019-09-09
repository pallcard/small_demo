package cn.wishhust.design.mode.aop;

import java.lang.reflect.Method;


public abstract class AbstractProxy implements Proxy {
    @Override
    public void doProxy(ProxyChain proxyChain) {
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        begin();
        try {
            if (filter(cls, method, params)) {
                before(cls, method, params);
                proxyChain.doProxyChain();
                after(cls, method, params);
            } else {
                proxyChain.doProxyChain();
            }
        } catch (Throwable e) {
            error(cls, method, params, e);
        } finally {
            end();
        }
    }

    protected void begin() {
    }

    protected boolean filter(Class<?> cls, Method method, Object[] params) {
        return true;
    }

    protected void before(Class<?> cls, Method method, Object[] params) {
    }

    protected void after(Class<?> cls, Method method, Object[] params) {
    }

    protected void error(Class<?> cls, Method method, Object[] params, Throwable e) {
    }

    protected void end() {
    }
}
