package com.thkjava.secbmore.C13String.format;
// Java 格式化字符串输出
public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 11.4514;
        // Old way
        System.out.println("Row 1: ["+x+" "+y+"]");
        // C style
        System.out.printf("Row 1: [%d %.4f]\n", x, y);
        // Java format style
        System.out.format("Row 1: [%d %.4f]\n", x, y);
    }
}
