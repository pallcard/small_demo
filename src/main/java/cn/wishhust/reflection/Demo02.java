package cn.wishhust.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Demo02 {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = MethodClass.class;

        // 创建类实例
        Object obj = clazz.newInstance();


        // 获取所有共有方法, 包括继承
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("----------");
        // 获取所有私有方法，不包括继承
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method dm : declaredMethods) {
            System.out.println(dm);
        }

        System.out.println("----------");
        // 获取指定方法
        Method add = clazz.getMethod("add", int.class, int.class);
        // 调用方法 （要先创建实例对象）
        Object r = add.invoke(obj, 1, 1);
        System.out.println(r);
        System.out.println(add);

        System.out.println("----------");
        // 获取指定方法(私有)
        Method sub = clazz.getDeclaredMethod("sub", int.class, int.class);
        sub.setAccessible(true);
        Object result = sub.invoke(obj,12, 2);
        System.out.println(result);

    }


}

class MethodClass {
    public int add(int a, int b) {
        return a + b;
    }
    private int sub(int a, int b){
        return a - b;
    }
}
