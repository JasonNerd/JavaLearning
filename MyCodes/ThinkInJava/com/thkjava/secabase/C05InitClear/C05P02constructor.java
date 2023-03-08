package com.thkjava.secabase.C05InitClear;
/*
 * 本小节主要讲述 构造器用于参数初始化, 构造器的重载
 * 在构造器中调用构造器
 */
class Flower{
    int petalCnt = 0;
    String info = "uh";
    Flower(int petalCnt, String info) {
        this.petalCnt = petalCnt;
        this.info = info;
    }
    Flower(){
        this(8, "Qian Niu Flower");     // 调用构造器, 仅能调用一个且仅一次且仅位于构造器中且作为第一句程序
    }
    // 方法的覆盖或重写
    @Override
    public String toString() {
        return info+", petalCnt is "+petalCnt;
    }
}


public class C05P02constructor {
    public static void main(String[] args) {
        System.out.println(new Flower());
    }
}
