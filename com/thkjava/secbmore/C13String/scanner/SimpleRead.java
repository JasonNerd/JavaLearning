package com.thkjava.secbmore.C13String.scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class SimpleRead {
    public static BufferedReader input = new BufferedReader(
        new StringReader("Michel Jason\n22 3.1415926")
    );  // 模拟模拟从键盘输入缓冲区
    public static void main(String[] args) {
        try {
            System.out.println("What is your name?");
            String name = input.readLine();
            System.out.println(name);
            System.out.println("Your age? Tell me a double");
            String nums = input.readLine();
            System.out.println(nums);
            String[] numArr = nums.split(" ");
            int age = Integer.parseInt(numArr[0]);
            double dfav = Double.parseDouble(numArr[1]);
            System.out.format("Hello %s, "+
            "in 5 years you will be %d. And your number is %f.", name, age+5, dfav);
        }catch(IOException e){
            System.err.println("I/O Exception.");;
        }
    }
}
