package com.thkjava.secbmore.C13String;

import java.util.ArrayList;

// 如果你希望toString()方法打印出对象的内存地址，也许你会考虑使用this关键字
public class InfiniteRecurse {
    public String toString(){
        return "Infinite Recursion address: "+this+"\n";
    }
    public static void main(String[] args) {
        ArrayList<InfiniteRecurse> ilist = new ArrayList<>();
        ilist.add(new InfiniteRecurse());
        ilist.add(new InfiniteRecurse());
        ilist.add(new InfiniteRecurse());
        ilist.add(new InfiniteRecurse());
        System.out.println(ilist);
    }
}
/*
 * 由InfiniteRecursion类型转换成String类型。
 * 因为编译器看到-个String对象后面跟着一个“+”，而再后面的对象不是String，于
 * 是编译器试着将this转换成一个String。它怎么转换呢，
 * 正是通过调用this上的toString()方法，于是就发生了递归调用。
 * 如果你真的想要打印出对象的内存地址，应该调用Object.toString()方法，
 * 这才是负责此任务的方法。所以，你不该使用this，而是应该调用super.toString()方法。
 */
