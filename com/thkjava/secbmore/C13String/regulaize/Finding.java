package com.thkjava.secbmore.C13String.regulaize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finding {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings.");
        while(m.find())
            System.out.println(m.group());
        System.out.println();
        int i=0;
        while(m.find(i)){
            ++i;
            System.out.print(m.group()+" ");
        }
    }
}
