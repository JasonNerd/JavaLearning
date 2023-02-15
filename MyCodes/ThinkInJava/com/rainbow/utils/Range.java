package com.rainbow.utils;
// Array creation methods that can be used without
// qualifiers，using Java SE5 static imports:
public class Range {
    // get a sequence [0, n)
    public static int[] range(int n){
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = i;
        return arr;
    }
    // get a sequence [a, b)
    public static int[] range(int a, int b){
        int n = b-a;
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = a+i;
        return arr;
    }
    // get a sequence [a, b) with a step s
    public static int[] range(int a, int b, int s){
        int n = (b-a)/s;
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = a+i*s;
        return arr;
    }
}
