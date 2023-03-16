package com.thkjava.secabase.C08DynamicBinding;
import static com.thkjava.utils.Print.*;

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
