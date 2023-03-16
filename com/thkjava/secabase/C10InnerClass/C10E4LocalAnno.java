package com.thkjava.secabase.C10InnerClass;
/*
 * 演示局部内部类和匿名内部类的使用, 局部内部类是指在某个局部作用域里的类，它仅在该作用域内可见
 * 例如某个方法体, 匿名内部类是指类的定义与该类的对象创建放在一起。
 */

// 1. 局部内部类
class Parcel5{
    public Destination destination(String s){
        // 一个含参数的局部内部类
        class PDestination implements Destination{
            private String label;
            PDestination(String whereTo){
                label = whereTo;
            }
            public String readLabel() {
                return label;
            }
            
        }
        return new PDestination(s);
    }
}
// 2. 匿名内部类
class Parcel6{
    public Contents contents(int x){
        // 定义域=与对象创建放在了一起
        return new Contents() {
            private int val = x;
            public int value() {
                return val;
            }
        };
    }
}
// 3. 创建和使用一个含参构造器的类
class Wrapper{
    private int x;
    Wrapper(int v){ x = v; }
    public int get(){ return x;}
}
class Parcel7{
    Wrapper f(int x){
        return new Wrapper(x){
            @Override
            public int get() {  // 重写了 get() 方法
                return super.get() * 129;
            }
        };
    }
}
// 4. 在匿名内部类内定义并初始化字段
class Parcel8{
    public Destination destination(String s){
        return new Destination() {
            private String whereTo = s;
            public String readLabel() {
                return whereTo;
            }
        };
    } 
}
// 5. 通过实例初始化达到类似于构造器的效果
abstract class Base{
    public Base(int i){
        System.out.println("Base constructor, i = " +i);
    }
    public abstract void f();
}
class AnonymousConstructor{
    public Base getBase(int x){
        return new Base(x) {
            {   // 代码块
                System.out.println("Before AnonymousConstructor.getBase.f()");
            }
            public void f() {
                System.out.println("In AnonymousConstructor.f()");
            }{
                System.out.println("After AnonymousConstructor.getBase.f()");

            }
        };
    }
}
public class C10E4LocalAnno {
    public static void main(String[] args) {
        // 1. 局部内部类
        Parcel5 parcel5 = new Parcel5();
        System.out.println(parcel5.destination("Heart").readLabel());
        // 2. 匿名内部类
        Parcel6 parcel6 = new Parcel6();
        System.out.println(parcel6.contents(8).value());
        // 3. 创建和使用一个含参构造器的类
        System.out.println((new Parcel7()).f(8).get());
        // 4. 在匿名内部类定义并初始化字段
        System.out.println((new Parcel8()).destination("Heart").readLabel());
        // 5. 通过实例初始化达到类似于构造器的效果
        new AnonymousConstructor().getBase(8).f();
        /*
        Base constructor, i = 8
        Before AnonymousConstructor.getBase.f()
        After AnonymousConstructor.getBase.f()
        In AnonymousConstructor.f() 
        */
    }
}
