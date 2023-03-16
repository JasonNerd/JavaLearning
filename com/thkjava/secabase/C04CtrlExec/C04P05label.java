package com.thkjava.secabase.C04CtrlExec;

public class C04P05label {
    public static void main(String[] args) {
        // 验证标签语法
        int i = 0;
        outer:
        while (true) {
            System.out.println("Outer while loop");
            while(true){
                i++;
                System.out.println("i = "+i);
                if(i == 1){
                    System.out.println("continue");
                    continue;
                }else if(i == 3){
                    System.out.println("continue outer");
                    continue outer;
                }else if(i == 5){
                    System.out.println("break");
                    break;
                }else if(i == 7){
                    System.out.println("break outer");
                    break outer;
                }
            }
        }
    }
}
/*
 * 分析程序运行结果
 * Outer while loop
 * i = 1
 * continue
 * i = 2
 * i = 3
 * continue outer
 * Outer while loop
 * i = 4
 * i = 5
 * break
 * Outer while loop
 * i = 6
 * i = 7
 * break outer
 */