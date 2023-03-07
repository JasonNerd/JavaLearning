package com.rainbow.tijava.C10InnerClass.whyInner;
interface Incrementable {
    void increment();
}

class Callee1 implements Incrementable{
    private int i = 0;
    public void increment(){
        ++ i;
        System.out.println("after increment, i="+i);
    }
}

class MyIncrement{
    public void increment(){ System.out.println("Some other incrementable operation."); }
}

class Callee2 extends MyIncrement{
    private int i = 0;
    public void increment() {
        super.increment();
        ++i;
        System.out.println("i = "+i);
    }
    private class Closure implements Incrementable{
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }
    public Incrementable getCallbackReference(){
        return new Closure();
    }
}

class Callee3 extends MyIncrement{
    private int i = 0;
    public void increment() {
        super.increment();
        ++i;
        System.out.println("i = "+i);
    }
    public Incrementable getCallbackReference(){
        return new Incrementable() {        // 使用匿名内部类
            @Override
            public void increment() {
                Callee3.this.increment();   // 回调外部类的方法
            }
        };
    }
}
class Caller{
    private Incrementable cbh;
    Caller(Incrementable incr){ cbh = incr; }
    void go(){ cbh.increment(); }
}


public class Callbacks {
    public static void main(String[] args) {
        Caller caller = new Caller(new Callee1());
        Caller caller2 = new Caller(new Callee2().getCallbackReference());
        Caller caller3 = new Caller(new Callee3().getCallbackReference());
        caller.go();
        caller2.go();
        caller3.go();
    }
}

// 在本例中, 有一个标准接口StdIn, 还有一个  Caller调用方 可以接受该接口标准并执行
// 接口中的指方法 为了使用它们, 可以实现一个 CalleeA被调方 , CalleeA实现了接口 StdIn
// 因此 Caller 可以接受 CalleeA -- 这十分正常和自然

// 但另一方面, 还有一个类 CalleeB, 他继承了另一个基类, 基类中的方法与接口中的签名类似
// 但实际执行内容却不同, 如何使得 CalleeB 也能被 Caller 接受并执行其中 "变异了的方法" 呢？
// 这里就需要使用内部类, 首先声明一个私有内部类 CBinner, CBinner 实现了接口 StdIn, 同时
// 也实现了其中的方法, 但实际方法体执行的是外围类 CalleeB 的另一个方法(达到偷天换日的效果)
// 另外设立一个公共方法返回一个 CBinner 类的对象
