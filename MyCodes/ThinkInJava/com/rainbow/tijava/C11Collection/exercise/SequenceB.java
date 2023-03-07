package com.rainbow.tijava.C11Collection.exercise;

import java.util.ArrayList;
import java.util.Iterator;
// 使用 iterator 而非 selector
// 注意这里直接使用 ArrayList 的 iterator 即可
// 这看起来和直接使用 ArrayList 并无二致
public class SequenceB {
    private ArrayList<Object> seq = new ArrayList<>();
    public void add(Object o){
        seq.add(o);
    }
    public Iterator<Object> iterator(){
        return seq.iterator();
    }

}
