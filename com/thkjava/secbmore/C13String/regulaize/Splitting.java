package com.thkjava.secbmore.C13String.regulaize;

import java.util.Arrays;
// split(regex);    把字符串从匹配的地方切开
public class Splitting {
    public static String knights = "Then, when you have found "+
    "the shrubbery, you must cut down the mightiest tree in the forest... "+
    "with... a herring!";
    public static void split(String regex){
        System.out.println(Arrays.toString(knights.split(regex)));
    }
    public static void main(String[] args) {
        split(" ");
        split("\\W+");  // W匹配非单词字符, w匹配单词字符
        split("n\\W+"); // 单词字符就是 [a-zA-Z0-9]
        // 匹配所有 n开头的后面有1个到多个非单词字符
        
    }
}
