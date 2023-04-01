package com.thkjava.secbmore.C13String.regulaize;
// relace:
// replaceFirst(regex, str)
// replaceAll(regex, str)
public class Replacing {
    public static void main(String[] args) {
        String s = Splitting.knights;
        System.out.println(s.replaceFirst("f\\w+", "got"));
        System.out.println(s.replaceAll("shrubbery|tree|herring", "apple"));
        // 1. 编写一个正则表达式，检查一个句子是否以大写字母开头，以.号结尾
        System.out.println("The rabbit is eatting carrot.".matches("[A-Z].*\\."));
        System.out.println("let me see.".matches("[A-Z].*\\."));
        System.out.println("Got it!".matches("[A-Z].*\\."));
        // 2. 将字符串Splitting.knights在the和you处分割。
        Splitting.split("the|you");
        // 3. 用下划线替换Splitting.knights中的所有元音字母
        System.out.println(s.replaceAll("[aeiou]", "_"));
    }
}
