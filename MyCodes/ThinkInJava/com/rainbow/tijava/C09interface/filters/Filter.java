package com.rainbow.tijava.C09interface.filters;
/*
 * Filter 看起来就像是 Processor 一样, 一个信息一个功能
 * 但 Filter.process() 的参数范围仅限于 Waveforms
 */
public class Filter {
    public String name(){
        return getClass().getSimpleName();
    }
    public Waveforms process(Waveforms input){
        return input;
    }
}
