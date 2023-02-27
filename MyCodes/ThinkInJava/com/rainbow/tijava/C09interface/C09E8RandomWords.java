package com.rainbow.tijava.C09interface;
/*
 * Java SE5的Scanner类(在第13章中就更多地了解它)的构造器接受的是一个 Readable 接口。
 * 如果你创建了一个新的类，并且想让 Scanner 可以作用于它，那么你就应该让它成为 Readable
 * Readable 接口只要求实现 read() 方法，在read()内部，
 * 将输入内容添加到 CharBuffer ，或者在没有任何输入时返回-1。
 * 
 * 本例将实现一个生成随机单词的类
 */
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

class RandomWords implements Readable{
    private Random rd;
    private static final char[] uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();
    private int cnt, wordlen;
    RandomWords(int cnt){
        this.cnt = cnt;
        this.wordlen = cnt;
        rd = new Random();
        // int seed = rd.nextInt();
        // rd = new Random(seed);
    }
    @Override
    public int read(CharBuffer cb){
        if(cnt--==0)    // cnt 是指 read次数
            return -1;
        cb.append(uppers[rd.nextInt(uppers.length)]);   // 首字母大写
        for(int i=0; i<wordlen-1; i++){
            boolean choice = rd.nextInt(2) == 1;
            if (choice)
                cb.append(lowers[rd.nextInt(lowers.length)]);
            else
                cb.append(vowels[rd.nextInt(vowels.length)]);
        }
        cb.append(" ");     // 注意这个空白符
        return wordlen;
    }
}

public class C09E8RandomWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new RandomWords(6));
        while(scanner.hasNext())
            System.out.println(scanner.next());
    }
}
