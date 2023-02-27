package com.rainbow.tijava.C09interface.classproc;
import static com.rainbow.utils.Print.*;
/*
 * 设计一个类 Processor, 另外一些类继承该类并覆盖其中的方法(例如f(args))
 * 最后有一个类包含一个接受 Processor 和 args 为参数的方法(例如proc())
 * 该方法调用 Processor 的 f(args) 方法, 那么针对同一组args, 若传入不同的
 * Processor, 对于 args 就有着不同的处理方式. 创建一个能够根据所传递的参数
 * 对象的不同而具有不同行为的方法, 被称为策略设计模式。
 * 这类方法包含所要执行的算法中固定不变的部分，而“策略”包含变化的部分。
 * 策略就是传递进去的参数对象，它包含要执行的代码
 */

import java.util.Arrays;

class Processor{
    public String name(){           // 1. 返回信息
        return getClass().getSimpleName();
    }
    Object process(Object input){   // 2. 功能函数
        return input;
    }
}

class Upcase extends Processor{
    @Override
    Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Downcase extends Processor{
    @Override
    String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Splitter extends Processor{
    @Override
    String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}

public class Apply {
    static String testCase = "Duo Qing Zong Bei Wu Qing Wu Cuo Ba Shen Qing Fu Yu Qing";
    public static void process(Processor p, Object s){
        println("Using processor "+p.name());
        println(p.process(testCase));
    }
    public static void main(String[] args) {
        process(new Downcase(), testCase);
        process(new Upcase(), testCase);
        process(new Splitter(), testCase);
    }
}
