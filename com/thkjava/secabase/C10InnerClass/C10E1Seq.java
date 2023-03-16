package com.thkjava.secabase.C10InnerClass;

/*
 * 例一、Sequnce.java
关键词：内部类、迭代器设计模式
Selector 是一个接口, 包含 end()/ current()/ next() 方法
Suquence 类包含一个private的序列, 包含一个 add() 方法, 一个实现了
Selector 的私有内部类 SequenceSelector
 */

interface Selector{
    boolean end();      // 是否到序列尾部
    Object current();   // 当前位置元素
    void next();        // 移动到下一位置
}

class Sequence{
    private int iter=0;
    private Object[] seq;
    
    Sequence(int seqLen){
        seq = new Object[seqLen];
    }
    public SequenceSelector selector(){
        return new SequenceSelector();
    }
    public void add(Object x){
        if(iter < seq.length)  // 如果没有到末尾
            seq[iter++] = x;  // 当前元素赋值, 移到下一个元素
    }
    private class SequenceSelector implements Selector{
        int i = 0;
        @Override
        public boolean end() { return i == seq.length; }
        @Override
        public Object current() { return seq[i]; }
        @Override
        public void next() { ++i; }
    }
}

public class C10E1Seq{
    public static void main(String[] args) {
        Sequence it10 = new Sequence(10);
        for (int i=0; i<100; i++)
            it10.add(i*2+1);
        Selector sel = it10.selector(); // SequenceSelector 是隐藏的, 但接口 Selector 却是通用的
        while(!sel.end()){
            System.out.println(sel.current());
            sel.next();
        }
    }
}