package com.thkjava.secabase.C09interface.filters;
/*
 * 假设我们发现了 一组 filter类, 并且实现结构与 Processor 类似, 但他
 * 处理的是 Waveforms 对象, 那么针对于 classsproc 中的 Processor 类, 
 * 或者说 Apply.process() 方法, 我们想要对这些代码加以复用, 应该如何做呢 ?
 */
public class Waveforms {
    private static long counter;    // 仅初始化一次, 0
    private long wid = counter++;   // 每初始化一个新对象都会进行一个初始化
    @Override
    public String toString() {
        return "waveform "+wid;
    }
}
