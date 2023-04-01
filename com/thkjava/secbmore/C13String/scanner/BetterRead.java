package com.thkjava.secbmore.C13String.scanner;

import java.util.Scanner;

public class BetterRead {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(SimpleRead.input);
        String name = stdin.next();
        int age = stdin.nextInt();
        double dnum = stdin.nextDouble();
        System.out.format("Hi %s.\n", name);
        System.out.format("In 5 years you'll be %d years old.\n", age+5);
        System.out.format("Favourite double is %f.", dnum);
        stdin.close();
    }
}
