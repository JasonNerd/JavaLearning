package com.rainbow.tijava.C09interface.interfaceproc;
import static com.rainbow.utils.Print.*;
/*
 * 针对 Processor 策略设计了一个方法
 * 它为每一个输入应用策略
 */
public class Apply {
    public static void process(Processor p, Object input){
        println("Use strategy "+p.name());
        println(p.process(input));
    }
}
