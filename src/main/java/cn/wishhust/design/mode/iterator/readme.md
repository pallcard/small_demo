#### 说明

迭代器模式目的：提供一个方法按顺序遍历一个集合内对元素，**又不需要暴露该对象对内部表**。

角色：

1. 迭代器角色
2. 具体迭代器角色
3. 容器角色
4. 具体容器角色

具体容器角色在生成迭代器的时候将容器中的内容的引用传递给迭代器角色，迭代器角色有
next、hasNext两个函数来遍历容器内容。
