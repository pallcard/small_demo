package main.java.cn.wishhust.design.mode.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton {
    private volatile static Singleton singleton = null;

    private Singleton() {
        if (null != singleton) {
            throw new RuntimeException("单例模式，操作非法");
        }
    }

    public static Singleton newInstance(){
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton tSingleton = newInstance();
        Constructor[] conArray = tSingleton.getClass().getDeclaredConstructors();
//        若没有再私有构造器里面加入判断，则可以使用反射进行创建对象
//        conArray[0].setAccessible(true);
//        Object o = conArray[0].newInstance();
//        System.out.println(o.toString());

        for (Constructor c : conArray) {
            System.out.println(c.toString());
        }


    }
}
