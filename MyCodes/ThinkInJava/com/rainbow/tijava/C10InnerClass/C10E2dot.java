package com.rainbow.tijava.C10InnerClass;
/*
 * 内部类返回外部类对象的引用 Outer.this
 * 其他类创建内部类对象 x.new Inner (x is an instance of outer)
 */

class DotThis{
    void f(){
        System.out.println("DotThis.f()");
    }
    class InnerC{
        DotThis getOuter(){
            return DotThis.this;    // 返回外部类的对象的引用
        }
    }
    public InnerC getIn(){
        return new InnerC();
    }
}


public class C10E2dot {
    public static void main(String[] args) {
        // 1. 先利用 getIn() 获得内部类的对象
        DotThis d = new DotThis();
        DotThis.InnerC di = d.getIn();
        di.getOuter().f();
        System.out.println(di.getOuter() == d);     // true
        // 2. 在使用 .new 语法生成内部类的对象
        DotThis.InnerC di2 = d.new InnerC();
        di2.getOuter().f();
        System.out.println(di2.getOuter() == d);    // true
    }
}
