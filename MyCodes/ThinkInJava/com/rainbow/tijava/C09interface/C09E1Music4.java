package com.rainbow.tijava.C09interface;
// 练习1. C09E1Music4.java
// 创建一个instrument抽象类的继承图, 
//: interfaces/music4/Music4.java

abstract class Instrument{
    abstract void play(Note n);           // 抽象方法只包含签名, 不含方法体
    String what(){ return ""; }
    abstract void adjust();
}
enum Note{
    MIDDLE_C, C_SHARP, B_FLAT;  // etc.
}
class Wind extends Instrument{
    @Override
    void play(Note n) {
        System.out.println("Wind.play()"+n);
    }
    @Override
    String what() {
        return "Wind";
    }
    @Override
    void adjust() {}
    
}
// Percussion
class Percussion extends Instrument{
    @Override
    void play(Note n) {
        System.out.println("Percussion.play()"+n);
    }
    @Override
    String what() {
        return "Percussion";
    }
    @Override
    void adjust() {}
    
}
// Stringed 
class Stringed extends Instrument{
    @Override
    void play(Note n) {
        System.out.println("Stringed.play()"+n);
    }
    @Override
    String what() {
        return "Stringed";
    }
    @Override
    void adjust() {}
    
}
// WoodWind
class WoodWind extends Wind{
    @Override
    void play(Note n) {
        System.out.println("WoodWind.play()"+n);
    }
    @Override
    String what() {
        return "WoodWind";
    }    
}
// Brass
class Brass extends Wind{
    @Override
    void play(Note n) {
        System.out.println("Brass.play()"+n);
    }
    @Override
    void adjust() {
        System.out.println("Brass.adjust()");
    }
}

public class C09E1Music4{
    static final Note t = Note.C_SHARP;
    public static void tune(Instrument e){
        e.play(t);
    }
    public static void tuneAll(Instrument[] e) {
        for(Instrument i: e)
            tune(i);       
    }
    public static void main(String[] args) {
        Instrument[] ochestra = {
            new Brass(),
            new Percussion(),
            new WoodWind(),
            new Stringed()
        };
        tuneAll(ochestra);
    }
}