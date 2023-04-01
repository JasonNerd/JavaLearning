package com.thkjava.secbmore.C13String.regulaize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEnd {
    public static final String input = 
    "As long as there is injustice, whenever a\n"+
    "Targathian baby cries out, wherever a distress\n"+
    "signal sounds among the stars ... we'll be there.\n"+
    "This fine ship,and this fine crew ...\n"+
    "Never give up! Never surrender!";

    private static class Display{
        private boolean regexPrinted = false;
        private String regex;
        Display(String regex){this.regex = regex;}
        void display(String message){
            if(!regexPrinted){
                System.out.println(regex);
                regexPrinted = true;
            }
            System.out.println(message);
        }
    }

    static void exmaine(String s, String regex){
        Display display = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while(m.find())     // find all substring that mathes
            display.display("find() '"+m.group()+"' start="+m.start()+" end="+m.end());
        if(m.lookingAt())   // if a substring mathes(start at 0)
            display.display("lookingAt() start="+m.start()+" end="+m.end());
        if(m.matches())     // if whole string mathes(start at 0)
            display.display("matches() start="+m.start()+" end="+m.end());
    }

    public static void main(String[] args) {
        String[] regexes = new String[]{
            "\\w*ere\\w*", "\\w*ever", "T\\w+", "Never.*?!"
        };
        for(String s: input.split("\n")){
            System.out.println("input: "+s);
            for(String reg: regexes)
                exmaine(s, reg);
        }
    }
}
