package com.rainbow.tijava.C07CodeReUse;
/*
 * 本程序将展现一个继承语法的示例, 同时, 验证:
 * 1. 一个程序中可以编写多个类
 * 2. 每个类都可以有一个 main 测试方法
 * 3. 可以 import 自己写的 public类、方法、变量
 * 4. 每个类都可以转为String, 这是通过重写toString()实现的
 * 5. 初始化时总是从 基类 开始, 慢慢的向外扩展
 * 6. 清理时总是从外层开始, 向内部延申
 */
// 注意这个 static 表示引用 static 成员
import static com.rainbow.utils.Print.*;

class Shape{
    Shape(int i){
        println("Shape constructor");
    }
    void dispose(){
        println("Shape dispose");
    }
    @Override
    public String toString() {
        return "This is a universal shape.";
    }
    public static void main(String[] args) {
        println(new Shape(0));  // main is available and have no negative effect
    }
}

class Circle extends Shape{
    Circle(int i){
        super(i);
        println("Draw a Circle");
    }
    void dispose(){
        println("Erasing Circle");
        super.dispose();
    }
}

class Triangle extends Shape{
    Triangle(int i){
        super(i);
        println("Draw a Triangle");
    }
    @Override
    void dispose() {
        println("Erasing Triangle");
        super.dispose();
    }
}

class Line extends Shape{
    private int start, end;
    Line(int start, int end){
        super(start);
        this.start = start;
        this.end = end;
        println("Drawing Line: "+ start +", "+ end);
    }
    @Override
    void dispose() {
        println("Erasing Line: "+ start +", "+ end);
        super.dispose();
    }
}

class CADSystem extends Shape{
    private Circle circle;
    private Triangle triangle;
    private Line[] lines = new Line[3];
    CADSystem(int i){
        super(i);   // 先调用基类构造器
        circle = new Circle(1); // 再依次进行初始化
        triangle = new Triangle(2);
        for (int j=0; j<lines.length; j++) {
            lines[j] = new Line(j, j*j);
        }
    }
    @Override
    void dispose() {
        // 按照与初始化顺序相反的次序依次 清理
        for(int i=lines.length-1; i>=0; i--)
            lines[i].dispose();
        triangle.dispose();
        circle.dispose();
        super.dispose();
    }
}
public class C07P01inheritValidate {
    public static void main(String[] args) {
        CADSystem cSystem = new CADSystem(2023);
        try{
            // do something
        }finally{
            cSystem.dispose();
        }
    }
    /*
     * Shape constructor
     * Shape constructor
     * Draw a Circle
     * Shape constructor
     * Draw a Triangle
     * Shape constructor
     * Drawing Line: 0, 0
     * Shape constructor
     * Drawing Line: 1, 1
     * Shape constructor
     * Drawing Line: 2, 4
     * Erasing Line: 2, 4
     * Shape dispose
     * Erasing Line: 1, 1
     * Shape dispose
     * Erasing Line: 0, 0
     * Shape dispose
     * Erasing Triangle
     * Shape dispose
     * Erasing Circle
     * Shape dispose
     * Shape dispose
     */
}
