package com.rainbow.tijava.C04CtrlExec;
// 重复第3章中的练习10，不要用Integer.toBinaryString方法，而是用三元操作符和按位操作符来显示二进制的1和0
public class C04P01binstr {
    public static void main(String[] args) {
        // 考点: 循环控制 操作符
        int a = 5, b = -5;
        System.out.println(Integer.toBinaryString(a));  // 101
        System.out.println(Integer.toBinaryString(b));  // ffff fffb
        System.out.println(toBinaryString(a));
        System.out.println(toBinaryString(b));
    }

    static String toBinaryString(int val){
        // 使用左移, 每次都取一个最高位, 判断是否为1
        // 同时使用一个标志标记何时出现为1的最高位(此后所有的位均有效)
        // 循环结束条件是某次左移后数字恰等于0
        String res = "";
        int bit, op = 0x80000000;
        boolean highestOk = false;  // 是否已经捕捉到最高位
        while(val != 0){
            bit = (val & op) >>> 31;    // 此处为31, 这是由于val为int型是32位
            if(bit == 1 && !highestOk)
                highestOk = true;       // 首次捕捉到1, 此即为有效最高位
            if(highestOk)       // 说明当前位是有效位
                res += bit;
            val <<= 1;  // val左移1位
        }
        return res;
    }
}
