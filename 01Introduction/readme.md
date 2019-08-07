- [back](../readme.md)

# 概览

本文讲解Java 8 的介绍

## 1 Lambda表达式

```
在其他语言中早就开始支持lambda表达式了，比如scala。在Java中，一个lambda表达式
就是一个匿名的函数。lambda表达式是在使用的时候才撰写的，特别是作为另外一个函数的入参
典型的lambda表达式的格式为:
1. (parameters) -> expression
2. (parameters) -> { statements; }
3. () -> expression
如下案例:
(x, y) -> x + y
这个lambda表达式用于计算两个参数的和

撰写lambda的规则:
1. lambda表达式可以没有或者有一个或多个参数
2. 参数的类型可以显式声明，也可以从上下文推断
3. 多个参数用逗号分隔开，放入括号中
4. 当只有一个参数时，如果推断其类型，则不必使用括号。例如: a -> return a*a.
5. lambda表达式的body中可以没有或者有一或多条执行语句
6. 如果lambda表达式的主体是单语句，则括号不是必需的；有多个语句时，必须用大括号括起来。
```

## 2 函数式接口(Functional Interface)

```
函数式接口首先是一个接口，这个接口只有一个抽象方法，也称之为SAM Interface,
即Single Abstract Method interfaces。
下面是函数式接口的实例:
@FunctionalInterface
public interface MyFirstFunctionalInterface {
    public void firstWork();
}

请注意，即使没有@FunctionalInterface这个注解，依然是函数式接口，
它仅用于通知编译器在接口内强制执行单个抽象方法
在函数式接口中添加default方法也不会导致函数式接口的失效
同时在重载父类的方法也不会导致函数式接口的失效
比如以下案例:

@FunctionalInterface
public interface MyFirstFunctionalInterface
{
    public void firstWork();
 
    @Override
    public String toString();                //Overridden from Object class
 
    @Override
    public boolean equals(Object obj);        //Overridden from Object class
}
```

## 3 默认方法

``` 
在Java 8中，可以在接口中定义默认方法，默认方法在Java 8中引入，以实现lambda表达式的功能。

为什么要引入默认方法?                 
首先，之前的接口是个双刃剑，好处是面向抽象而不是面向具体编程，
缺陷是，当需要修改接口时候，需要修改全部实现该接口的类，
目前的 java 8 之前的集合框架没有 foreach 方法，
通常能想到的解决办法是在JDK里给相关的接口添加新的方法及实现。
然而，对于已经发布的版本，是没法在给接口添加新方法的同时不影响已有的实现。
所以引进的默认方法。他们的目的是为了解决接口的修改与现有的实现不兼容的问题。

默认方法实例:
public interface Moveable {
    default void move(){
        System.out.println("I am moving");
    }
}

public class Animal implements Moveable{
    public static void main(String[] args){
        Animal tiger = new Animal();
        tiger.move();
    }
}
```

## 4 Java 8 Streams

```
另一个重大变化是Java 8 Streams API，它提供了一种以各种方式处理一组数据的机制，
包括过滤，转换或任何其他可能对应用程序有用的方式。

Java 8中的Streams API支持不同类型的迭代，您只需定义要处理的项集，
要对每个项执行的操作以及要存储这些操作的输出。

下例是删除集合中以某种字符开头的字符串
List<String> items;
String prefix;
List<String> filteredList = items.stream().filter(e -> (!e.startsWith(prefix))).collect(Collectors.toList());
```