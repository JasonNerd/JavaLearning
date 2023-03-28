package com.thkjava.secbmore.C13String.format;

import java.util.Formatter;

/*
在插人数据时，如果想要控制空格与对齐，你需要更精细复杂的格式修饰符。以下是其抽象的语法:
%[argument_index$][flags][width][.precision]conversion
最常见的应用是控制一个域的最小尺寸，这可以通过指定width来实现。
Formatter对象通过在必要时添加空格，来确保一个域至少达到某个长度。
在默认的情况下，数据是右对齐，不过可以通过使用"-"标志来改变对齐方向。
 */
public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);

    public void printTitle(){
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }
    public void print(String name, int qty, double price){
        f.format("%-15.15s %5d %10.2f\n", name, qty, price);
        total += price;
    }
    public void printTotal(){
        f.format("%-15s %5s %10.2f\n", "Tax", "", total*0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n", "Total", "", total*1.06);
    }


    public static void main(String[] args) {
        Receipt r = new Receipt();
        r.printTitle();
        r.print("Magic Beans", 4, 4.25);
        r.print("Princess Peas", 3, 5.1);
        r.print("Bears Porridge", 1, 14.25);
        r.printTotal();
    }
}
