package com.thkjava.secabase.C11Collection.exercise;

import java.util.ArrayList;
import java.util.Iterator;
// 使用 iterator 而非 selector
// 可以对 Iterator进行方法重写
// 注意 remove() 方法属于可选
// 同时规定了 泛型 T

public class SequenceB<T> {
    protected ArrayList<T> seq = new ArrayList<>();
    public void add(T o){
        seq.add(o);
    }
    public int size(){
        return seq.size();
    }
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            private int i;
            public boolean hasNext() { return i<seq.size(); }
            public T next() { return seq.get(i++); }
        };
    }
    public Iterator<T> rIterator(){
        return new Iterator<T>() {
            private int i = seq.size();
            public boolean hasNext() { return i>0; }
            public T next() { return seq.get(--i); }
        };
    }

}
