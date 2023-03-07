package com.rainbow.tijava.C10InnerClass.whyInner.controller;
// The common methods for any control event.
// start()是一个独立的方法, 生成触发事件的时间
// ready()告诉你何时可以运行action()方法
public abstract class Event {
    private long eventTime;
    protected final long delayTime;
    public Event(long delayTime){
        this.delayTime = delayTime;
        start();
    }
    public void start(){    // 设定事件启动时间
        eventTime = System.nanoTime() + delayTime;
    }
    public boolean ready(){ // 倒计时结束, 表示事件就绪
        return System.nanoTime() >= eventTime;
    }
    public abstract void action();
}
