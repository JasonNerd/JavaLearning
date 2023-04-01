package com.thkjava.secbmore.C13String.regulaize;
import java.util.regex.Matcher;
// Pattern & Matcher
// Pattern pattern = Pattern.compile(s);
// Matcher matcher = pattern.matcher(strInput);

import java.util.regex.Pattern;

public class TestRegularExpression {
    public static String strInput = "abcabcabcdefabc";
    public static void test1(){
        String[] strPatterns = {strInput, "abc+", "(abc)+", "(abc){2}"};
        for(String s: strPatterns){
            System.out.format("Regular expression: \"%s\"\n", s);
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(strInput);
            while(matcher.find()){
                System.out.format("Match \"%s\" at positions [%d, %d]\n", 
                matcher.group(), matcher.start(), matcher.end()-1);
            }
        }
    }
    public static void main(String[] args) {
        // test1();
        // test2();
        test3();
    }
    public static void test2(){
        String strI = "Java now has regular expressions";
        String[] pstr = {"^Java", "\\breg.*", "n.w\\s+h(a|i)s", "s?", 
                        "s*", "s+", "s{4}", "s{1}", "s{0,3}"};
        for(String ps: pstr){
            Pattern p = Pattern.compile(ps);
            Matcher m = p.matcher(strI);
            System.out.println(ps);
            if(m.find())
                System.out.println(m.group());
            else System.out.println("No matches!");
            System.out.println();
        }
    }

    public static void test3(){
        Pattern p = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
        // Pattern p2 = Pattern.compile("\\s*[AEIOUaeiou]\\w+[aeiou]");
        Matcher m = p.matcher("Arline i ae ate eight apples and one orange while Anita hadn't any");
        while(m.find()){
            System.out.format("Match \"%s\" at [%d, %d]\n", m.group(), m.start(), m.end()-1);
        }
        // \s空白符, \w单词字符, \b词边界
        // 一个字符串, 开头可能有1个i, 后面以元音字符开头, 字符前可能有一个至多个空白字符, 
        // 紧接着是一串单词字符, 单词可能以元音字符结尾, 并保留有词边界
    }
}
