package com.thkjava.utils;

import java.util.LinkedList;

public class Stack<T>{
    private LinkedList<T> stack;
    public Stack(){ stack = new LinkedList<T>(); }
    public T top(){ return stack.getFirst(); }  // 返回栈顶元素
    public void pop() { stack.removeFirst(); }  // 弹出栈顶元素
    public void push(T x) { stack.addFirst(x); }     // 栈顶添加元素
    public boolean empty() { return stack.isEmpty();}   // 判空
    public String toString() {
        return stack.toString();
    }
}