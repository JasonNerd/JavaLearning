package com.rainbow.tijava.C11Collection.s3iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
/*
 * 演示 iterator 的基本使用方法, 这里有
 * hasNext(), next(), remove() 方法等等
 * 不需要考虑容器的具体类型, 只需要直到迭代对象的类型即可(解耦合)
 * -- 迭代器统一了容器的迭代方式
 */
public class IterShow {
    public static void main(String[] args) {
        LinkedList<Snow> sLinkedList = new LinkedList<>(Arrays.asList(
            new Snow(), new Powder(), new Heavy(), new Light(), new Crusty(), new Powder()
        ));
        Iterator<Snow> siter = sLinkedList.iterator();      // 返回一个迭代器
        // 使用迭代器遍历
        while(siter.hasNext()){
            Snow s = siter.next();  // 返回当前遍历元素, 并将指针移到下一位
            System.out.println(s);
            siter.remove();         // 把最近访问的元素删掉
        }
        // 检查
        System.out.println(sLinkedList.isEmpty());
    }
}
