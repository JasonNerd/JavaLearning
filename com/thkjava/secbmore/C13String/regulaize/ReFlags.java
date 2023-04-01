package com.thkjava.secbmore.C13String.regulaize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// p 表示以java开头的字符串, 注意考虑多行, 不考虑大小写
public class ReFlags{
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher(
            "java has regex\nJava has regex\n"+
            "JAVA has pretty good regular expressions\n"+
            "Regular expressions are in Java."
        );
        while(m.find()){
            System.out.println(m.group());
        }
    }
}