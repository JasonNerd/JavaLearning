package com.thkjava.secbmore.C13String.regulaize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Resetting {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("[frb][aiu][gx]")
                                 .matcher("fix the rug wit bag");
        while(matcher.find())
            System.out.println(matcher.group());
        matcher.reset("new tes fax rag adc");
        while(matcher.find())
            System.out.println(matcher.group());
    }
}
