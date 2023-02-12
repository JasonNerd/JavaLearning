package com.rainbow.tijava.C05InitClear;
/*
 * 本小节主要讨论this的用法, this指明了当前对象, 可以作为返回值
 */
class Leaf{
    int i=0;
    Leaf increment(){
        ++i;
        return this;
    }
    void info(){
        System.out.println("Leaf num is "+i);
    }
}


public class C05P01this {
    public static void main(String[] args) {
        Leaf leaf = new Leaf();     // new 一个对象
        // 因为 increment()返回了当前对象, 因而可以连续的调用
        leaf.increment().increment().increment().info();
    }
}
