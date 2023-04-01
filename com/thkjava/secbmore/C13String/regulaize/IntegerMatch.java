package com.thkjava.secbmore.C13String.regulaize;
// String.matches
// ? 表示可能
public class IntegerMatch {
    public static void main(String[] args) {
        // 1. 匹配一串数字, 前面可能有一个负号
        System.out.println("-78".matches("-?\\d+"));
        System.out.println("78".matches("-?\\d+"));
        // 2. 匹配一个负数
        System.out.println("78".matches("-\\d+"));
        System.out.println("-78".matches("-\\d+"));
        // 3. 匹配一串数字, 前面可能有负号或者正号
        System.out.println("+78".matches("(\\+|-)?\\d+"));
        System.out.println("-78".matches("(\\+|-)?\\d+"));
        System.out.println("78".matches("(\\+|-)?\\d+"));
    }
}
