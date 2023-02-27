package com.rainbow.tijava.C09interface;
/*
创建一个不包含任何方法的抽象类，从它那里导出一个类，并添加一个方法。
创建一个静态方法，它可以接受指向基类的引用，将其向下转型到导出类，然后再调用该静态方法。
在main()中，展现它的运行情况。然后，为基类中的方法加上abstract声明，这样就不再需要进行向下转型。
*/
abstract class Animal{
    abstract void eat();
}
class Dog extends Animal{
    void eat(){
        System.out.println("Dog eat");
    }
    static void f(Animal a){
        a.eat();
    }
}
public class C09P2Abs {
    public static void main(String[] args) {
        Dog.f(new Dog());
    }
}
