package com.thkjava.secabase.C11Collection.s2features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * contains():  是否位于列表
 * remove():    接受 引用 or 下标
 * indexOf():   找到对象下标
 * subList()
 * Collections.sort()
 * Collections.shuffle()
 * retainAll(): 交集
 * set():       修改
 * isEmpty():   是否为空
 * clear():     清空
 * toArray():   转为数组
 */
public class ListAPIs {
    public static void main(String[] args) {
        ArrayList<Integer> iArrayList = new ArrayList<>();
        iArrayList.addAll(Arrays.asList(3, 5, 1, -2, 5, 7, 8));
        // 1. contains()
        System.out.println(iArrayList.contains(5));     // true
        // 2. remove()
        System.out.println(iArrayList.remove(5));   // 7
        System.out.println(iArrayList);                 // [3, 5, 1, -2, 5, 8]
        // 3. indexOf()
        int idx5 = iArrayList.indexOf(5);
        System.out.println(idx5);      // 1
        iArrayList.remove(iArrayList.get(idx5));
        System.out.println(iArrayList);
        // 4. subList()
        ArrayList<Integer> subL = new ArrayList<>(iArrayList.subList(1, 4));
        System.out.println(subL);   // [1, -2, 5]
        Collections.sort(subL);     // sort the list
        System.out.println(subL);   // [-2, 1, 5]
        System.out.println(iArrayList.containsAll(subL));   // true
        Collections.shuffle(subL);  // shuffle the list
        System.out.println(subL);
        System.out.println(iArrayList.containsAll(subL));   // true
        System.out.println(iArrayList);     // [3, 1, -2, 5, 8], 不会对原列表有任何影响
    }
}
