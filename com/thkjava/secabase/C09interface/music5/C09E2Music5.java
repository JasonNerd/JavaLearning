package com.thkjava.secabase.C09interface.music5;
import static com.thkjava.utils.Print.*;

enum Note{
    MIDDLE_C, C_SHARP, B_FLAT;  // etc.
}

interface Instrument{
    int VAL = 226;  // static final public
    void adjust();
}

interface Playable{
    void play(Note note);
}

class Wind implements Instrument, Playable{
    @Override
    public void play(Note note) {
        println(this+".play() "+note);
    }
    @Override
    public void adjust() {
        println(this+".adjust() ");
    }
    @Override
    public String toString() {
        return "Wind";
    }
}

class Precussion implements Instrument, Playable{
    @Override
    public void play(Note note) {
        println(this+".play() "+note);
    }
    @Override
    public void adjust() {
        println(this+".adjust() ");
    }
    @Override
    public String toString() {
        return "Precussion";
    }
}

class Stringed implements Instrument, Playable{
    @Override
    public void play(Note note) {
        println(this+".play() "+note);
    }
    @Override
    public void adjust() {
        println(this+".adjust() ");
    }
    @Override
    public String toString() {
        return "Stringed";
    }
}

class WoodWind extends Wind{
    @Override
    public void play(Note note) {
        println(this+".play() "+note);
    }
    @Override
    public String toString() {
        return "WoodWind";
    }
}

class Brass extends Wind{
    @Override
    public void play(Note note) {
        println(this+".play() "+note);
    }
    @Override
    public void adjust() {
        println(this+".adjust() ");
    }
}

public class C09E2Music5 {
    static Note n = Note.B_FLAT;
    static void tune(Playable p){
        p.play(n);
    }
    static void tuneAll(Playable[] ps){
        for(Playable p: ps){
            tune(p);
        }
    }
    public static void main(String[] args) {
        Playable[] ochestra = {
            new Brass(),
            new Precussion(),
            new Stringed(),
            new WoodWind(),
            new Precussion()
        };
        tuneAll(ochestra);
        /*
         * Wind.play() B_FLAT
         * Precussion.play() B_FLAT
         * Stringed.play() B_FLAT
         * WoodWind.play() B_FLAT
         * Precussion.play() B_FLAT
         */
    }
}
