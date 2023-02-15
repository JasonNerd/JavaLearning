package com.rainbow.utils;
// Print methods that can be used without
// qualifiers，using Java SE5 static imports:

import java.io.PrintStream;

public class Print {
    public static void print(Object object){
        System.out.print(object);
    }
    public static void println(Object object){
        System.out.println(object);
    }
    public static void println(){
        System.out.println();
    }
    // The new Java SE5 printf() (from C):
    public static PrintStream printf(String format, Object... args){
        return System.out.printf(format, args);
    }
}
