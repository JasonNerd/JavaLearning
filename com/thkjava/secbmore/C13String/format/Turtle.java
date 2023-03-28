package com.thkjava.secbmore.C13String.format;
/*
 * 使用Formatter类, 在Java中，所有新的格式化功能都由javautil.Formatter类处理。
 * 可以将Formatter看作一个翻译器，它将你的格式化字符串与数据翻译成需要的结果。 
 * 当你创建一个Formatter对象的时候，需要向其构造器传递一些信息，
 * 告诉它最终的结果将向哪里输出. Formatter的构造器经过重载可以接受多种输出目的地，
 * 不过最常用的还是PrintStream()(如上例)、OutputStream和File。
 */

import java.io.PrintStream;
import java.util.Formatter;

public class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name, Formatter f){
        this.f = f;
        this.name = name;
    }

    public void move(int x, int y){
        f.format("Turtle %s is at (%d, %d)\n", name, x, y);
    }
    public static void main(String[] args) {
        PrintStream ps = System.out;
        Formatter f = new Formatter(ps);
        Turtle turtle = new Turtle("null", f);
        turtle.move(3, 4);
        turtle.move(5, 3);
        turtle.move(36, 32);
    }
}
