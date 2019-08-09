package cn.wishhust.design.mode.singleton;


/**
 *
 * 当Singleton被加载时，静态内部类SingletonHolder没有被加载进内存。只有当调用getInstance() 方法时，会使得SingletonHolder被加载，
 * 此时初始化INSTANCE实例，JVM保证INSTANCE只被初始化一次。
 *
 */

public class Singleton2 {

    private Singleton2(){}

    private static class SingletonHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
