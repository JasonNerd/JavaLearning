package com.thkjava.secabase.C10InnerClass.whyInner;
// 为 Sequence 设计多个 selector
interface Selector{
    boolean end();
    void next();
    Object current();
}

public class Sequence {
    private Object[] sequence;
    private int index;
    Sequence(int n){
        sequence = new Object[n];
    }
    public void add(Object x){
        if(index < sequence.length){
            sequence[index++] = x;
        }
    }
    public Selector select(){ 
        return new Selector() {
            private int i = 0;
            public boolean end() { return i == sequence.length; }
            public void next() { ++i; }
            public Object current() { return sequence[i]; }
        }; 
    }
    public Selector r_select(){
        return new Selector() {
            private int i = sequence.length;
            public boolean end() { return i == 0; }
            public void next() { --i; }
            public Object current() { return sequence[i-1]; }
        };
    }
    public static void main(String[] args) {
        int n = 10;
        Sequence sequence = new Sequence(n);
        for(int i=0; i<n; i++)
            sequence.add(2*i+1);
        // 正序遍历
        Selector s = sequence.select();
        while(!s.end()){
            System.out.print(s.current()+" ");
            s.next();
        }
        System.out.println();
        // 倒序遍历
        Selector rs = sequence.r_select();
        while(!rs.end()){
            System.out.print(rs.current()+" ");
            rs.next();
        }
    }
}
