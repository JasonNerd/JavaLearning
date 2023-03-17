---
title: "第04章 -- 访问权限控制"
date: 2023-03-16T22:28:58+08:00
draft: false
tags: ["Java", "Java编程思想"]
categories: ["学习笔记"]
twemoji: true
lightgallery: true
---
# 第04章 -- 访问权限控制
访问控制(隐藏具体实现)与"最初的实现不恰当"有关, 例如某些方法在(开发者)后期维护时发现有缺陷或者更好的方式进行实现时, 就需要对其进行重写, 然而对于使用这些方法的客户(消费者)来说, 他们不希望改变现有代码, 那么开发者如何知道客户使用了哪些方法?这些方法是否可以修改? 实际上, 这一麻烦应交由开发者解决, 也即对各个方法进行权限访问的控制, 规定哪些方法不可以提供给客户使用, 那么这些方法对于客户是透明的, 开发者可以对这些不公开的方法进行修改。Java提供了一些机制来实现访问权限控制, 包括包、访问修饰符public\protected\\\private

## 包: 库单元
包, 或称目录、命名空间, 它隔离各个程序中的变量方法名, 有效解决了命名冲突
例如, 使用 ArrayList:
```java
java.util.ArrayList list = new java.util.ArrayList();
```
利用 import 语法, 使其更简洁
```java
import java.util.ArrayList
// import java.util.*
ArrayList list = new ArrayList()
```
需要注意的是, 这里的 ArrayList 必然是 public 的, 因此可以在任意地方使用, 例如自己的工程文件里。在同一个包(目录)中, 每一个Java源文件仅允许有一个public修饰的类成员, 这个.java源文件被称为编译单元, 在这个编译单元内**若还有其他类(没有权限访问修饰符, 也即默认权限或者包访问权限), 这些类对于包外的类不可见(也即另外的程序员是没法取得和使用这个类), 但这些类可以被同一个包的其他类所使用**--这是合理的, 起初包的路径命名方式就是个人网站的域名反写(例如com.baidu.www), 也就是同一个人编写的各个类(没有修饰符, 默认权限)都可以互相访问, 那么这些类实际上就不对外开放, 该程序员可以**对需要进行开放的类、方法、变量(统称为成员)添加public修饰符, 这样就可以提供给其他程序员使用**。对于每一个.java源文件, 他们必然位于某个包中, 其中源程序的第一行代码应当指明自己的包路径:
```java
package com.baidu.www
```

那么其他程序员如何引用你的成员呢？除了一条简单的**import语句**, 还有这些事情, 指明CLASSPATH这一环境变量(./xxx)的值也即你的成员的根目录。另外，其他程序员如何知道这些public成员的使用方法和功能呢？Java提供了javadoc(开发者)可以对这些public成员进行注解进行说明, 另一方面这也引出了这一问题：客户程序员实际上只需要对这些public成员发送接收消息, 那么一个符合直觉的设计是开发者**实际对外开放一个接口(其中存放着public成员和使用方法)**, 实际实现则位于另外的类中。

对于客户程序员，还有一个问题，如果import的两个包中有类名冲突，这会导致编译错误，此时只能使用全名加以区分。
实现自己的工具类: Print/Range *#TODO*
```java
//: net/mindview/util/Print.java
// Print methods that can be used without
// qualifiers，using Java SE5 static imports:
package net.mindview.util;
import java.io.*;
public class Print {
    // Print with a newline:
    public static void print(Object obj) {
        System.out.printIn(obj);
    }
    // Print a newline by itself:
    public static void print() {
        System.out.println();
    }
    // Print with no line break:
    public static void printnb(Object obj) {
        System.out.print(obj);
    }
    // The new Java SE5 printf() (from C):
    public static PrintStream printf(String format, Object... args){
        return System.out.printf(format，args);
    }
}

//: net/mindview/util/Range.java
// Array creation methods that can be used without
// qualifiers，using Java SE5 static imports:
package net.mindview.util;
public class Range {
    // Produce a sequence [..n)
    public static int[] range(int n) {
        int[] result = new int[n];
        for(int i=0;i < n; i++)
            result[i] = i;
        return result;
    }
    // Produce a sequence [start..end)
    public static int[] range(int start,int end) {
        int sz = end - start;
        int[] result = new intl[sz];
        for(int i=0;i< sz; i++)
            result[i] = start + i;
        return result;
    }
    // Produce a sequence [start..end) incrementing by step
    public static int[] range(int start, int end, int step) {
        int sz = 1 + (end - start)/step;
        int[] result = new int[sz];
        for(int i=0;i< sz; i++)
            result[i] = start + (i * step);
        return result;
    }
}
```


## 私有构造方法 private 单例模式
访问权限的控制常被称为是**具体实现的隐藏**, 把数据和方法包装进类中以及具体实现的隐藏，常共同被称作是封装。其结果是**一个同时带有特征和行为的数据类型**。
默认的包访问权限通常已经提供了充足的隐藏措施，请记住，使用类的客户端程序员是无法访问包访问权限成员的。这样做很好，因为默认访问权限是一种我们常用的权限，同时也是一种在忘记添加任何访问权限控制时能够自动得到的权限。因此，**通常考虑的是，哪些成员是想要明确公开给客户端程序员使用的，从而将它们声明为public**.

而在最初，你可能不会认为自经常会需要使用关键字private，因为没有它，照样可以工作。然而，事实很快就会证明，**private的使用是多么的重要，在多线程环境下更是如此 (正如将在第21章中看到的)**。这是一个说明private终有其用武之地的示例:可能想控制如何创建对象，并阻止别人直接访问某个特定的构造器(或全部构造器)。
```java
//: access/Lunch.java
// Demonstrates class access specifiers， Make a class
// effectively private with private constructors:
class Soup1{
    private Soup1() {}
    // (1) Allow creation via static method:
    public static Soupl makeSoup(){
        return new Soupl();
    }
}
class Soup2 {
    private Soup2(){}
    // (2) Create a static object and return a reference
    // upon request.(The "Singleton" pattern):
    private static Soup2 psl = new Soup2();
    public static Soup2 access(){
        return ps1;
    }
    public void f(){}
}
// Only one public class allowed per file:
public class Lunch {
    void testPrivate() {
    // Can't do this! Private constructor:
    //! Soup1 soup = new Soup1();
    }
    void testStatic() {
        Soup1 soup = Soupl.makeSoup();
    }
    void testSingleton(){
        Soup2.access().f();
    }
}
```

## protected修饰符与继承
这里只说明protected关于权限访问控制的事情, protected 修饰符相对于包访问权限更为宽松，例如基类的 protected 成员可以被其 子类 访问 -- 即便这个类并不位于这个包（可以想象别人对自己包的类进行了继承、改写、再创作）


