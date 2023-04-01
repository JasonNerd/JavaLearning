package com.thkjava.secbmore.C13String.regulaize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheReplacements {
    public static final String text = "/*! "+
    "Here's a block of a text to use as input to\n"+
    "    the regular expression matcher. Note that we'll\n"+
    "    first extract the bock of text by looking for\n"+
    "    the special delimiters, then process the\n"+
    "    extacted block. !*/";
    public static void main(String[] args) {
        // 匹配文本字符串, 除去开头结尾, 中间的换行符、空白符也计入.
        Matcher m = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(text);
        String inputString="";
        if(m.find())
            inputString = m.group(1);
        // 将多个空格替换为1个
        inputString = inputString.replaceAll(" {2,}", " ");
        // 将位于行首的多余空格去掉, 允许多行模式
        System.out.println(inputString.replaceAll("(?m)^ +", " ")); 

        // replaceFirst
        System.out.println(inputString.replaceFirst("(?i)[aeiou]", "VOWEL(1)"));
        // replace incrementally
        StringBuffer sBuffer = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]\\w{1,2}[aeiou]");
        Matcher m2 = p.matcher(inputString);
        while(m2.find())
            m2.appendReplacement(sBuffer, m2.group().toUpperCase());
        m2.appendTail(sBuffer);
        System.out.println(sBuffer);
    }
}

