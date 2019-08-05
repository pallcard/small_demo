package cn.wishhust.reflection;

import java.lang.reflect.Constructor;

public class Demo01 {
    public static void main(String[] args) throws Exception{
        String str = new String();
        // 1.通过对象的getClass方法获得
        Class strClass = str.getClass();
        System.out.println(strClass.getName());

        // 2.通过class属性获得
        // 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
        Class strClass2 = String.class;
        System.out.println(strClass2.getName());
        System.out.println(strClass2 == strClass);

        // 3.使用Class类的forName静态方法
        // 注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
        try{
            Class strClass3 = Class.forName("java.lang.String");
            System.out.println(strClass3 == strClass2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(strClass.isInstance("test"));

        System.out.println(strClass instanceof Object);

        // 创建实例
        // 1. newInstance()
        String string = (String) strClass.newInstance();
        System.out.println(string);

        // 2. 先通过Class对象获取指定Constructor对象，再调用Constructor对象的newInstance()方法来创建实例。
        // 这种方法可以指定构造器的实例。
        Constructor constructor = strClass.getConstructor(String.class);
        String string2 = (String) constructor.newInstance("23333");
        System.out.println(string2);
    }

}
