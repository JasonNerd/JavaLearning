package com.thkjava.common;
import static com.thkjava.utils.Print.*;

public class Circle extends Shape{
    @Override
    public void draw() {
        println("Circle.draw()");
    }
    @Override
    public void erase() {
        println("Circle.erase()");
    }
}
