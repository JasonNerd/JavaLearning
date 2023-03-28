package com.thkjava.secbmore.C13String;
/*
 * Java 中, String 是不可变的对象, 另外仅有 String 重载了操作符,
 * 这操作符也即 +, += , 实际上是由 StringBuilder 实现的。
 */

class StrBld{
    public String implict(String[] args){
        String res="";
        for(String s: args)
            res += s;   // 每次循环解释器都要
        return res;
    }

    public String explicit(String[] args){
        StringBuilder sBuilder = new StringBuilder();
        for(String s: args)
            sBuilder.append(s);
        return sBuilder.toString();
    }
}

public class WhileStrBld{
    public static void main(String[] args) {
        String[] aStrings = {"Hello, ", "I ", "am ", "LiHua."};
        System.out.println(new StrBld().implict(aStrings));
        System.out.println(new StrBld().explicit(aStrings));
    }
}