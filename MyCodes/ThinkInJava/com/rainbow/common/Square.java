package com.rainbow.common;
import static com.rainbow.utils.Print.*;

public class Square extends Shape{
    @Override
    public void draw() {
        println("Square.draw()");
    }
    @Override
    public void erase() {
        println("Square.erase()");
    }
}
