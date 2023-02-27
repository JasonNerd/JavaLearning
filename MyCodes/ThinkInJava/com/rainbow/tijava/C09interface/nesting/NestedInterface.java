package com.rainbow.tijava.C09interface.nesting;

/*
 * 接口可以嵌套(nest)在类或者其他接口中
 */

class A{
    private B bRef;         // 一个私有的 B 的引用
    private interface B{    // 类A的私有接口 B
        void f();
    }
    public class Bclass implements B{
        public void f(){}   // 一个实现了接口B的类
    }
    public B getB(){
        return new Bclass();        // 返回了私有的 B接口引用
    }
    public void receiveB(B b){
        bRef = b;
        bRef.f();
    }
}

public class NestedInterface{
    public static void main(String[] args) {
        A a= new A();
        // Can't access A.D;
        // A.B ad =a.getB();
        // Doesn't return anything but A.B
        // A.Bclass di2 = a.getB();
        // Cannot access a member of the interface:
        // a.getB().f();
        // Only another A can do anything with getD():
        A a2 =new A();
        a2.receiveB(a.getB());
        /*
         * NestingInterfaces展示了嵌套接口的各种实现方式。特别要注意的是，
         * 当实现某个接口时，并不需要实现嵌套在其内部的任何接口。而且，
         * private接口不能在定义它的类之外被实现
         */
    }
}
