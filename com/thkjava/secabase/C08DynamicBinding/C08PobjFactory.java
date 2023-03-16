package com.thkjava.secabase.C08DynamicBinding;
import com.thkjava.common.*;


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
