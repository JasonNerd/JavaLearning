package com.thkjava.secabase.C11Collection.exercise;
import java.util.Iterator;
/*  SequenceC
 * 继承自sequenceB, 他实现了 Iterable 接口, 保留了 rIterator
 * 方法, 给定另一个 reverse 参数, 使 for-each 可能有不同的行为
 */
public class SequenceC<T> extends SequenceB<T> implements Iterable<T> {
    private boolean reverse = false;
    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }
    @Override
    public Iterator<T> iterator(){
        if(!reverse)
            return new Iterator<T>() {
            private int i = 0;
            public boolean hasNext() { return i<seq.size(); }
            public T next() { return seq.get(i++); }
            };
        else{
            return rIterator();     // 通过 reverse 参数来控制遍历顺序
        }
    }
    public Iterable<T> reversed(){
        // 返回一个 匿名 Iterable 对象, 需要重写 iterator
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return rIterator();
            }
        };
    }

}
