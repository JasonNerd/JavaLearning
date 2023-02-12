package com.rainbow.tijava.C03Operator;
/*
 * 算术操作演示
 */
public class C03P01 {
    public static void main(String[] args) {
        // demo01StringAdd();
        demo4ConstValExp();
    }
    // 3-1. 赋值, 算术运算(+-*/%, =)演示
    static void demo01StringAdd(){
        int a = 1, b = 2, c = 3;
        String string = "Date 2023-02-10: ";
        System.out.println(string+a+b+c); // Date 2023-02-10: 123
        System.out.println(string+(a+b+c)); // Date 2023-02-10: 6
        System.out.println(""+a);   // int -> String
    }
    // 3-2. 自增运算符
    static void demo2AutoIncre(){
        int i = 2;
        int j = ++i, k = i++;
        System.out.println("j="+j+", i="+i+", k="+k); // 3, 4, 3
    }
    // 3-3. 关系运算符(>, <) 逻辑运算(&& || !) 三元运算符
    // 字符串常量是专门有个常量池, s1=="10"为真而s1==s2为假
    static void demo3LogicOp(){
        String s1 = "10", s2 = new String("10");
        // s1 && s2; // 非法, 逻辑运算仅用于布尔值间
        boolean con1 = s1 == s2;  // false
        boolean con2 = s1 == "10"; // true
        boolean con3 = "10" == "10"; // true
        boolean con4 = "10".equals("10");   // true
        boolean con = (con1 && con2) || (con3 && con4);    // true
        int res = con ? 1: 0;
        System.out.println(con1);   // false
        System.out.println(con2);   // true
        System.out.println(con3);   // true
        System.out.println(con4);   // true
        System.out.println(con);    // true
        System.out.println(res);    // 1
    }

    // 3-4. 常量与指数记数, 移位运算
    static void demo4ConstValExp(){
        int i1 = Integer.MAX_VALUE, i2 = Integer.MIN_VALUE;
        System.out.println(Integer.toHexString(i1)); // 7fff ffff, 2^31-1, 21473647
        System.out.println(Integer.toHexString(i2)); // 8000 0000, -2^31, -21473648
        System.out.println(Integer.toHexString(i1>>2)+", "+(i1>>2));    // 右移2位, 1fff ffff, 536870911
        System.out.println(Integer.toHexString(i1<<2)+", "+(i1<<2));    // 左移2位, ffff fffc, -4, 非法结果
        System.out.println(Integer.toHexString(i1>>>2)+", "+(i1>>>2));  // 逻辑右移2位, 1fff ffff, 536870911
        System.out.println(Integer.toHexString(i2>>2)+", "+(i2>>2));    // 右移2位, e000 0000, -536870912
        System.out.println(Integer.toHexString(i2<<2)+", "+(i2<<2));    // 左移2位, 0000 0000, 0, 非法结果
        System.out.println(Integer.toHexString(i2>>>2)+", "+(i2>>>2));  // 逻辑右移2位, 2000 0000, 536870912, 非法结果
        // float和double的表示区间
        // 其实就是IEEE754浮点数标准, 以单精度浮点数也即32位float为例, 分为
        // 符号位(1)S, 阶码(8)T, 尾数(23)M 三个部分, 尾数原码表示, 有隐含1, 也即(1+M): 2-2^(-23)
        // 解码用移码表示, 偏置为127, 范围从0~255变为-127~128, -127的阶码为全8个0而128阶码全1, 有特殊用途
        // 因此阶码范围是-126~127, 于是float最大绝对值((2-2^(-23))*2^127), 16进制: 7F7F FFFF
        // 最小绝对值((1+0)*2^-126): 0080 0000
        float f1 = Float.MAX_VALUE, f2 = Float.MIN_NORMAL;
        System.out.println(Float.toHexString(f1));
        System.out.println(Float.toHexString(f2));

    }

}
