package com.rainbow.tijava.C07CodeReUse;
/*
 * 以下展示了一个十分合理的设计(至少目前看是这样)
 * 一个Car由 Engine, Wheel, Window, Door 等等组成
 */
class Engine{
    public void start() {}
    public void rev() {}
    public void stop() {}
}

class Wheel{
    public void inflate(int psi) {}
}

class Window{
    public void rollup() {}
    public void rolldown() {}
}

class Door{
    public Window window = new Window();
    public void open() {}
    public void close() {}
}

class Car {
    public Engine engine;    // 1个引擎
    public Door left, right;  // 2扇门
    public Wheel[] wheels = new Wheel[4];   // 4个轮子
    Car(){
        engine = new Engine();
        left = new Door();
        right = new Door();
        for(int i=0; i<4; i++)
            wheels[i] = new Wheel();
    }
}

public class C07P03CarDeisgn {
    public static void main(String[] args) {
        /*
         * 在面向对象编程中，生成和使用程序代码最有可能采用的方法就是直接将数据和方法
         * 包装进一个类中，并使用该类的对象。也可以运用组合技术使用现有类来开发新的类，
         * 而继承技术其实是不太常用的。因此，尽管在教授OOP的过程中我们多次强调继承，
         * 但这并不意味着要尽可能使用它。
         */
        Car car = new Car();
        car.left.close();
        car.right.close();
        car.left.window.rolldown();
        car.right.window.rollup();
        car.engine.start();
        car.wheels[0].inflate(72);
        car.engine.stop();
        car.left.open(); 
    }
}
