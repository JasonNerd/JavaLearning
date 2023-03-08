package com.thkjava.common;
import static com.thkjava.utils.Print.*;

public class Triangle extends Shape{
    @Override
    public void draw() {
        println("Triangle.draw()");
    }
    @Override
    public void erase() {
        println("Triangle.erase()");
    }
}
