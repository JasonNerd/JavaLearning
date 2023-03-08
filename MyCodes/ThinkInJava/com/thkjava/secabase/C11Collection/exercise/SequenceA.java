package com.thkjava.secabase.C11Collection.exercise;

// 修改innerclasses/Sequencejava，使你可以向其中添加任意数量的元素

import java.util.ArrayList;
class CPrint{
    private int i;
    CPrint(int i){this.i = i;}
    public String toString() {
        return "This is "+i;
    }
}
public class SequenceA{
    private ArrayList<Object> arrList = new ArrayList<>();
    public void add(Object obj){
        arrList.add(obj);
    }
    public Selector selector(){
        return new Selector() {
            private int i = 0;
            public boolean hasNext() { return i < arrList.size(); }
            public void next() { ++i; }
            public Object current() { return arrList.get(i); }
        };
    }
    public Selector r_selector(){
        return new Selector() {
            private int i = arrList.size();
            public boolean hasNext() { return i > 0; }
            public void next() { --i; }
            public Object current() { return arrList.get(i-1); }
        };
    }
    public static void main(String[] args) {
        SequenceA sequenceA = new SequenceA();
        Selector selector = sequenceA.selector();
        sequenceA.add(new CPrint(3));
        sequenceA.add(new CPrint(5));
        sequenceA.add(new CPrint(8));
        sequenceA.add(new CPrint(4));
        while(selector.hasNext()){
            System.out.println(selector.current());
            selector.next();
        }
    }
}
