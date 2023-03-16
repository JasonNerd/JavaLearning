package com.thkjava.secabase.C09interface.interfaceproc;
import com.thkjava.secabase.C09interface.filters.*;
/*
 * 在不改变 Filter 类库的方式下复用 Apply.process()方法
 * 
 */
// FilterAdapter 实现了 Processor 接口
class FilterAdapter implements Processor{
    // filter是一个代理
    private Filter filter;
    FilterAdapter(Filter filter){
        this.filter = filter;
    }
    @Override
    public String name() {
        return filter.name();
    }
    @Override
    public Object process(Object input) {
        return filter.process((Waveforms)input);
    }
}

// 可以这样思考, FilterAdapter 接受一个 Filter策略, 得到一个
// Processor 对象, 类内部的功能实现则利用 传入的filter策略的方法进行实现
// 这就像是 这个类把 Filter 适配到了 Processor 接口上, 或者说他是一个代理
public class FilterProcess {
    private static Waveforms w = new Waveforms();
    public static void main(String[] args) {
        Apply.process(new FilterAdapter(new LowPass(0.2)), w);
        Apply.process(new FilterAdapter(new HighPass(0.8)), w);
        Apply.process(new FilterAdapter(new BandPass(0.2, 0.8)), w);
    }
}
