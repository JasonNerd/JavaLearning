package com.thkjava.secabase.C11Collection.s3iterator;

import java.util.Iterator;

import com.thkjava.secabase.C11Collection.exercise.SequenceB;
import com.thkjava.secabase.C11Collection.exercise.SequenceC;

/*
 * 对于一个继承自其他基类的子类, 无法再去继承 AbstractCollection
 * 继承带来的限制太多, 因此可以考虑实现一个 iterator 方法
 * 这里重写了 Sequnce 类: com\rainbow\tijava\C11Collection\exercise\SequenceB.java
 * 
 */
public class UseIterator {
    public static SequenceB<Snow> getSeqB(){
        // 获取一个 Snow 的 SeqB 对象
        SequenceB<Snow> snowSeq = new SequenceB<>();
        snowSeq.add(new Snow());
        snowSeq.add(new Light());
        snowSeq.add(new Crusty());
        snowSeq.add(new Powder());
        snowSeq.add(new Snow());
        snowSeq.add(new Heavy());
        return snowSeq;
    }
    public static void testIterator(){
        // 测试 SequenceB 的 iterator
        SequenceB<Snow> sc = getSeqB();
        Iterator<Snow> it = sc.iterator();
        Iterator<Snow> rit = sc.rIterator();
        System.out.println("_---------__---__--");
        while(it.hasNext())
            System.out.println(it.next());
        System.out.println("_---------__---__--");
        while(rit.hasNext())
            System.out.println(rit.next());
        System.out.println("_---------__---__--");
    }
    public static void testIterable(){
        SequenceC<Snow> snowSeqC = new SequenceC<Snow>();
        Iterator<Snow> cit = getSeqB().iterator();
        while(cit.hasNext())
            snowSeqC.add(cit.next());
        for(Snow s: snowSeqC){
            System.out.print(s+", ");
        }
        System.out.println();
        System.out.println("-----------");
        snowSeqC.setReverse(true);  // 倒过来
        for(Snow s: snowSeqC){
            System.out.print(s+", ");
        }
        System.out.println();
        System.out.println("-----------");
        for(Snow s: snowSeqC.reversed()){
            System.out.print(s+", ");
        }
    }
    public static void main(String[] args) {
        // testIterator();
        // 测试 Iterable 
        testIterable();
    }
}
