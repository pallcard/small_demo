### 反射
##### 一、定义
反射（reflection）是java的特征之一，它允许允许中的Java程序获取自身的信息，并且可以操作累或对象的内部属性。
##### 二、基本运用
反射可以用于判断任意对象所属的类，获得 Class 对象，构造任意一个对象以及调用一个对象。反射相关的类一般都在 java.lang.relfect 包里。
###### 1. 获取Class对象

```java
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

    }

}

// 结果：
java.lang.String
java.lang.String
true
true
true
true

```
**说明**
获取Class对象的三种方法：

* 调用某个对象的getClass方法；

* 直接获取某个类型的class属性：

* 使用Class类的forName静态方法。

**注意：在运行期间，一个类，只有一个Class对象产生。**


###### 2. 判断是否为某个类的实例
一般使用instanceof关键字判断是否为某个类的实例，也可以使用反射中Class对象的isInstance()方法（native方法）判断是否为某个类的实例，

```java
System.out.println(strClass.isInstance("test"));
System.out.println(strClass instanceof Object);
```


###### 3. 创建实例

```java
    // 创建实例
    // 1. newInstance()
    String string = (String) strClass.newInstance();
    System.out.println(string);

    // 2. 先通过Class对象获取指定Constructor对象，再调用Constructor对象的newInstance()方法来创建实例。
    // 这种方法可以指定构造器的实例。
    Constructor constructor = strClass.getConstructor(String.class);
    String string2 = (String) constructor.newInstance("23333");
    System.out.println(string2);
```
**说明**
* 使用Class对象的newInstance()方法来创建Class对象对应类的实例。
* 先通过Class对象获取指定Constructor对象，再调用Constructor对象的newInstance()方法来创建实例。

###### 4. 获取方法

```java
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

```

**说明**
* getDeclaredMethods()方法返回类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
* getDeclaredMethod()方法可以获取特定的私有方法，
* getMethods()方法返回某个类的所有公用（public）方法，包括其继承类的公用方法。
* getMethod()方法返回一个特定的方法，其中第一个参数为方法名称，后面的参数为方法的参数对应Class的对象。


