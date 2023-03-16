package com.thkjava.secabase.C10InnerClass.whyInner;
/* 关于回调的理解(摘录):
 * 1. 回调是一种双向的调用模式，程序模块之间通过这样的接口调用完成通信联系
 * 2. 回调的核心就是回调方将本身即this传递给调用方，这样调用方就可以在调用完毕之后再告诉
 *    回调方它想要知道的信息
 * 3. 回调函数用于层间协作，上层将本层函数安装在下层，这个函数就是回调
 *    而下层在一定条件下触发回调
 * 4. 底层，他在收到一个数据时，除了完成本层的处理工作外，还将进行回调，它将这个数据交给
 *    上层应用层来做进一步处理，这在分层的数据通信中很普遍
 * 5. 回调就是该函数写在高层，低层通过一个函数指针保存这个函数，在某个事件的触发下，
 *    低层通过该函数指针调用高层那个函数
*/
/*比较经典的回调方式：
    1. Class A实现接口CallBack callback——背景1
    2. class A中包含一个class B的引用b ——背景2
    3. class B有一个参数为callback的方法f(CallBack callback) ——背景3
    4. A的对象a调用B的方法 f(CallBack callback) ——A类调用B类的某个方法 C
    5. 然后b就可以在f(CallBack callback)方法中调用A的方法 ——B类调用A类的某个方法D 
*/
/*有一天小王遇到一个很难的问题，问题是 "1 + 1 = ?", 就打电话问小李， 小李一下子也不知道
* 就跟小王说, 等我办完手上的事情, 就去想想答案，, 王也不会傻傻的拿着电话去等小李的答案吧
* 于是小王就对小李说, 我还要去逛街, 你知道了答案就打我电话告诉我, 于是挂了电话, 
* 自己办自己的事情, 过了一个小时, 小李打了小王的电话, 告诉他答案是2 
*/
// 接
interface Solution{
    void solve(String result);
}
// 小王, 提问者, 有一个 question.
class Wang implements Solution{
    private XiaoLi xli;
    Wang(XiaoLi li){
        xli = li;
    }
    public void askQuestion(String question){
        // 1. 向小李询问问题
        System.out.println("Ask a question: "+question);
        new Thread(new Runnable() {
            @Override
            public void run() {
                xli.excuteMessage(Wang.this, question);
            }
        }).start(); // 新开了一个线程
        // 2. 随后独自玩耍
        play();
    }
    @Override
    public void solve(String result) {
        System.out.println("Get result from Li:");
        System.out.println(result);
    }
    void play(){
        System.out.println("I would like to go shopping now. Later call me back.");
        for(int i=0; i<10000000; i++);
        System.out.println("Go shopping over.");
    }
}
// 小李, 回答者, 可以给出答案
class XiaoLi{
    public void excuteMessage(Solution method, String prob){
        // get the message from Wang
        System.out.println("Recieve a problem: " + prob);
        // however, somt other troubles Li
        System.out.println("Dealing with other troubles...");
        for(int i=0; i<1000000; i++);
        // after deal with the above, excute
        System.out.println("Now address the problem.");
        method.solve("The answer is 2.");
    }
}

public class CBeg2 {
    public static void test1(){
        XiaoLi xiaoLi = new XiaoLi();
        Wang wang = new Wang(xiaoLi);
        wang.askQuestion("1 + 1 = ?");
    }
    public static void main(String[] args) {
        test1();
    }
}

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
 * 改写程序, 使得 LowGetData 接受一系列的整数(但没有处理整数的能力), UpperDisposeData 处理这些整数(
 * 例如把他们求和, 求积), 然后再利用接口 AquireRes 把结果传回
 */