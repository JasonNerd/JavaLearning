package com.thkjava.secabase.C09interface.interfaceproc;
/*
 * 复用 Processor 接口集配套的 Apply.process() 方法, 一种模式是
 * 设计实现自己的类。
 */

import java.util.Arrays;

// 专门实现一个处理字符串的 StringProcessor
public abstract class StringProcessor implements Processor{
    @Override
    public String name() {
        return getClass().getSimpleName();
    }
    static String tca = "Duo Qing Zong Bei Wu Qing Nao, Cuo Ba Shen Qing Fu Yu Qing.";   
    public static void main(String[] args) {
        // StringProcessor 部分实现了接口 Processor
        // Downcase 等策略继承 StringProcessor
        // 实现了各自的策略, 随后利用 Apply.process
        // 应用策略 -- 一种十分正常的复用模式
        Apply.process(new Downcase(), tca);
        Apply.process(new Upcase(), tca);
        Apply.process(new Splitter(), tca);
        // 然而对于发现的类库 Filter 而言, 我们无法去
        // 修改它, 这里可以采用【适配器模式】
        // FilterProcess.java
    }
}

class Downcase extends StringProcessor{
    @Override
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}
class Upcase extends StringProcessor{
    @Override
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}
class Splitter extends StringProcessor{
    @Override
    public String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}