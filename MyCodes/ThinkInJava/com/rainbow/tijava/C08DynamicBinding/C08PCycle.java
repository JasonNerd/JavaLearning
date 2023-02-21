package com.rainbow.tijava.C08DynamicBinding;
import static com.rainbow.utils.Print.*;
/*
 * 创建一个Cycle类，它具有子类 Unicycle, Bicycle 和 Tricycle.
 * 演示每一个类型的实例都可以经由 ride() 方法向上转型为 Cycle
 * 在 Cycle 中添加 wheels() 方法，它将返回轮子的数量。
 * 修改 ride() 方法，让它调用 wheels() 方法，并验证多态起作用了
 */

class Cycle{
    @Override
    public String toString() {
        return "Cycle";
    }
    public int getWheels(){
        return 0;
    }
}

class Unicycle extends Cycle{
    private int wheels = 1;
    public int getWheels() {
        return wheels;
    }
    @Override
    public String toString() {
        return "Unicycle";
    }
}

class Bicycle extends Cycle{
    private int wheels = 2;
    public int getWheels() {
        return wheels;
    }
    @Override
    public String toString() {
        return "Bicycle";
    } 
}

class Tricycle extends Cycle{
    private int wheels = 3;
    public int getWheels() {
        return wheels;
    }
    @Override
    public String toString() {
        return "Tricycle";
    }
}


public class C08PCycle {
    public static void ride(Cycle cycle){
        println("I ride a "+cycle+", and it has "+cycle.getWheels()+" wheels");
    }
    public static void main(String[] args) {
        ride(new Bicycle());    // 传入 Bicycle() 对象
        ride(new Tricycle());
    }
}
