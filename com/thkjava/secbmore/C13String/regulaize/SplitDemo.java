package com.thkjava.secbmore.C13String.regulaize;

import java.util.Arrays;
import java.util.regex.Pattern;

// 这是一个快速而方便的方法，可以按照通用边界断开输入文本:
public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual use!of exlamation!!points";
        System.out.println(Arrays.toString(Pattern.compile("!+").split(input)));
        System.out.println(Arrays.toString(Pattern.compile("!+").split(input, 3)));
    }
}
/*
[This, unusual use, of exlamation, points]
[This, unusual use, of exlamation!!points]
 */