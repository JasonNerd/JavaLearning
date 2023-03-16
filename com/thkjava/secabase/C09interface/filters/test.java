package com.thkjava.secabase.C09interface.filters;
import com.thkjava.secabase.C09interface.classproc.Apply;
/*
 * 本类测试 filter 的策略 和 Waveforms对象 参数, 能否被
 * Apply.processor()调用, 答案显然是不能, 因为 Filter 不是一种 Processor
 * 这说明 Apply.processor() 与 Process类耦合过紧, 因此尝试进行解耦, 不妨
 * 修改一下 Processor 为 接口，看看会有什么效果
 * 见 "interfaceproc" 包
 */
public class test {
    public static void main(String[] args) {
        // 可不可以填入 Filter 策略和 相应的Waveform参数?
        // 对于 Filter 的设计着而言, 他不清楚你要把它当作 Processor
        // 并复用 Apply.process()方法
        BandPass bpStrategy = new BandPass(0.2, 1.3);   // filter的策略
        Waveforms w = new Waveforms();  // 一个 Waveforms对象
        // Apply.process(bpStrategy, w);   // 报错, 因为 Filter 不是一种 Processor
    }
}
