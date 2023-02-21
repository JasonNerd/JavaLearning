package com.rainbow.common;

import java.util.Random;

public class RandomShapeGenerator {
    Random rd = new Random(226129);
    public Shape next(){
        int i = rd.nextInt(3);
        switch(i){
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }
}
