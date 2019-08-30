package cn.wishhust.design.mode.aop;

import java.lang.reflect.Method;

import static com.sun.tools.internal.xjc.reader.Ring.begin;

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

    public boolean filter(Class<?> cls, Method method, Object[] params) {
        return true;
    }

    public void before(Class<?> cls, Method method, Object[] params) {
    }

    public void after(Class<?> cls, Method method, Object[] params) {
    }

    public void error(Class<?> cls, Method method, Object[] params, Throwable e) {
    }

    public void end() {
    }
}
