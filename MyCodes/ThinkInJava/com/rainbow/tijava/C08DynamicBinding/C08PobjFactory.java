package com.rainbow.tijava.C08DynamicBinding;
import com.rainbow.common.*;
/*
 * 实现一个对象制造工厂: 【工厂设计模式】
 * 具体的, 以几何图形系列为例:
 * Shape, Circle, Square, Triangle
 * 他们都有  draw() 和 erase() 方法
 */


public class C08PobjFactory {
    static RandomShapeGenerator shapeGen = new RandomShapeGenerator();
    public static void main(String[] args) {
        int n = 10;
        Shape[] shapes = new Shape[n];
        for(int i=0; i<shapes.length; i++){
            shapes[i] = shapeGen.next();    // 随机填入对象
        }
        for(Shape s: shapes){   // 访问每一个对象
            s.draw();
            s.erase();
        }
    }
}
