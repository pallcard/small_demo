#### 说明

包含四个部分

1. 抽象组件 ----> IDrink
2. 具体组件 ----> Coffee 
3. 抽象装饰 ----> DrinkDecorator
4. 具体装饰 ----> Milk, Ice

主要使用类的组合来实现对于一个类进行动态的增加功能。
具体组件和抽象装饰都实现了抽象组件，具体组件又是抽象组件的子类，
当调用时，可以要修饰的对象传递给修饰类，这样就可以对抽象对类进行功能对增强。

装饰器模式可以在不增加新的装饰类的情况下对已有的功能进行组合而得到新的功能，
但得修改客户端代码才能使用新的功能。

动态代理则是增加一个新的类来实现功能，哪怕这个功能是对已有功能的组合，但可以不用修改客户端代码。



即区别：1.增不增加新类。2 是否需要更改客户端代码。

代理模式主要是控制对某个特定对象访问，而装饰模式主要是为了给对象添加行为。
