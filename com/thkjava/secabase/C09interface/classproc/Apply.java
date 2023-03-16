package com.thkjava.secabase.C09interface.classproc;
import static com.thkjava.utils.Print.*;

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
