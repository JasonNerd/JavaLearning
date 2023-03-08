package com.thkjava.secabase.C11Collection.s2features;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import com.thkjava.utils.Stack;

/*
 * 本小节介绍了各种简单的数据结构
 * Set, Map, Stack, Queue, PriorityQueue
 * LinkedList提供了方法以支持队列的行为，并且它实现了Queue接口，
 * 因此LikedList可以用作Queue的一种实现。通过将LinkedList向上转型为Queue即可
 */


public class SimpDS {
    public static void testStack(){
        Stack<Integer> istack = new Stack<>();
        istack.push(2); 
        istack.push(5); 
        istack.push(4);
        istack.pop();
        istack.push(7); 
        istack.push(3); 
        istack.pop();
        System.out.println(istack);
    }
    public static void testSet(){
        // 随机向一个 Set 插入多个随机数
        Set<Integer> iset = new HashSet<>();
        Random r = new Random();
        for(int i=0; i<10000; i++)
            iset.add(r.nextInt(26));
        System.out.println(iset);
        // 并: addAll()
        // 交: 
        // 差: remove()
    }
    public static void main(String[] args) {
        // testStack();
        // testSet();
        // testMap();
        // testQueue();
        testPriority();
    }
    public static void testMap(){
        // 随机产生 10000 个数字, 记录出现次数
        Random r = new Random();
        Map<Integer, Integer> statisc = new HashMap<>();
        for(int i=0; i<10000; i++){
            int key = r.nextInt(26);
            Integer freq = statisc.get(key);    // 自动包装为 Integer
            statisc.put(key, freq==null?1:freq+1);
        }
        System.out.println(statisc);
        // value get(key)
        // map.put(key, value)
        // containsKey() containsValue()
        System.out.println(statisc.containsKey(20));
        System.out.println(statisc.containsValue(408));
    }
    public static void testQueue(){
        Queue<Integer> intQueue = new LinkedList<>();   // 向上转型
        intQueue.addAll(Arrays.asList(4, 5, 8, 1, 9, 7));
        for(int i=0; i<5; i++)
            intQueue.offer(new Random().nextInt(2*i+1));    // 在队列尾部插入新的元素
        printQ(intQueue);
        System.out.println(intQueue.isEmpty()); // true
    }

    public static void printQ(Queue queue){
        while(queue.peek() != null){    // 队头非空, 也即队列不空
            System.out.print(queue.remove()+" ");   // 队头元素出列
        }
        System.out.println();
    }

    public static void testPriority(){
        PriorityQueue<Integer> prioQ = new PriorityQueue<>();
        List<Integer> iList = Arrays.asList(4, 5, 2, 0, -2, 2, 1, 4, 3, 7, 3, 8);
        prioQ.addAll(iList);    // 位于队列头部的最小, 也即以小为优
        System.out.println(prioQ);
        printQ(prioQ);
        // reversed
        prioQ = new PriorityQueue<>(iList.size(), Collections.reverseOrder());
        prioQ.addAll(iList);
        System.out.println(prioQ);
        printQ(prioQ);
    }
}
