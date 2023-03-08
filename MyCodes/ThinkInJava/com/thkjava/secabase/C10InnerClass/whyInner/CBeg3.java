package com.thkjava.secabase.C10InnerClass.whyInner;
/*
 * 这里模拟了两个类的对象间的异步通信, Wang(回调方, 低层, 无法处理数据的一方) 将 question(信息, 数据) 
 * 交给 XiaoLi(调用方, 高层, 有能力处理数据的一方), 同时为了能够获取处理结果, Wang 还把本身对象的引用 w
 * 也一并交给 XiaoLi, Wang应该还有一个方法获取数据处理结果, 例如 get(), 这样在调用方XiaoLi
 * 有空闲时就 处理数据, 然后调用 w.get(), Wang w 就接受到了这个处理结果.
 * 接口的意义:
 * 底层为了保证 传入的引用不会对自己产生负面影响(也即调用方利用该引用调用了其他与本次数据传输无关的方法,
 * 这可能对底层对象产生危害), 另一方面高层也只想与一个通用的对象对话----这是因为高层还需要与其他的底层
 * 类对象通话, 于是可以利用接口--这即是通信协议。因而对于底层, 他必须有一个变量(内部类)实现通信协议并把消息发送
 * 到高层(调用方)
 * 
 * 所以class Wang 直接实现了 Solution, 似乎是一种奇怪的做法, 这限制了Wang做其他事
 * 
 * 改写程序, 使得 LowCollectData 接受一系列的整数(但没有处理整数的能力), UpperDisposeData 处理这些整数(
 * 例如把他们求和, 求积), 然后再利用接口 AquireRes 把结果传回
 */

import java.util.Random;

interface AquireRes{
    void getSum(int s);   // 获取和
    void getMul(int m);   // 获取积
}

class LowCollectData{
    private int[] itInputs;
    private UpperDisposeData disposer;
    private Getter getter;
    private int sum, mul;
    // 1. 一个实现了接口数据接受协议的内部类
    private class Getter implements AquireRes{
        @Override
        public void getSum(final int s) {
            sum = s;
        }
        @Override
        public void getMul(final int m) {
            mul = m;
        }
    }
    // 2. 构造器, 初始化成员
    LowCollectData(int n, UpperDisposeData disp){
        itInputs = new int[n];
        // 1. 初始化数据, 填充随机数(固定)
        Random r = new Random(226);
        for(int i=0; i<n; i++){
            itInputs[i] = r.nextInt(n) + 1;
        }
        // 2. 初始化一个接收器
        getter = new Getter();
        // 3. 初始化处理器
        disposer = disp;
    }
    // 3. 上传数据, 获取处理结果
    void getResult(){
        disposer.excute(getter, itInputs);
        System.out.println("Get sum: " + sum);
        System.out.println("Get mul: " + mul);
    }
}

class UpperDisposeData{
    /**
     * @param aquireRes
     * @param ips
     * @return
     */
    public void excute(AquireRes aquireRes, int... ips){
        int s = 0, m = 1;
        for(int i: ips)
            s += i;
        for(int i: ips)
            m *= i;
        aquireRes.getMul(m);
        aquireRes.getSum(s);
    }
}

public class CBeg3 {
    public static void main(String[] args) {
        UpperDisposeData d = new UpperDisposeData();
        LowCollectData l = new LowCollectData(10, d);
        l.getResult();
        // 2 10 5 4 6 2 8 8 2 2
        // 2400*512 = 1200*1024 = (10240+2048)*100 = 1228800
    }
}
