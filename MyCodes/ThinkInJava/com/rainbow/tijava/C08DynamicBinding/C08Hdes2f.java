package com.rainbow.tijava.C08DynamicBinding;
import static com.rainbow.utils.Print.*;
/*
 * 创建一个包含两个方法的基类。在第一个方法中可以调用第二个方法。
 * 然后产生一个继承自该基类的导出类，且覆盖基类中的第二个方法。
 * 为该导出类创建一个对象，将它向上转型到基类型并调用第一个方法，解释发生的情况。
 */

class Bird{
    void fly(){
        sing();
    }
    void sing() {}
}

class Chick extends Bird{
    @Override
    void sing() {
        print("A chick sings like gegege");
    }
}

public class C08Hdes2f {
    public static void main(String[] args) {
        Bird chick = new Chick();   // Chick 继承了 Bird, 创建了一个 Chick 对象, 向上转型, 使用 Bird 引用指向了它
        chick.fly();    // 调用 fly() 方法, 由于后期绑定, 实际执行的是 Chick 中的 fly() 方法.
    }
}
