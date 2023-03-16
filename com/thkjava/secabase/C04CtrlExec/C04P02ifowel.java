package com.thkjava.secabase.C04CtrlExec;

import java.util.Random;

// 实现随机生成字母并判断字母是否为元音的程序
// a, e, i, o, u --> "vovel"
// y, w --> Sometimes a vowel
// others --> consonant
public class C04P02ifowel {
    public static void main(String[] args) {
        // 考点: switch-case
        Random rd = new Random(2023);
        for (int i = 0; i < 12; i++) {
            int c = rd.nextInt(26)+'a';
            System.out.print((char)c+": ");
            switch (c) {        // a, e, i, o, u ""
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': System.out.println("vowel");
                          break;
                case 'y':
                case 'w': System.out.println("Sometimes a vowel");
                default:
                    System.out.println("consonant");
            }
        }
    }
}
