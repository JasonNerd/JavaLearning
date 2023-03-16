package com.thkjava.secabase.C09interface;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;
/*
 * 假如我们发现一个 RandomDouble 类, 它可以返回随机浮点数
 * 现在我们想把它适配到 Readable 接口, 并使用 Scanner 类进行读取
 */
class RandomDouble{
    private static final Random rd = new Random();
    public double next(){
        return rd.nextDouble();
    }
}

class RDadapter extends RandomDouble implements Readable{
    private int num;
    RDadapter(int num){
        this.num = num;
    }
    @Override
    public int read(CharBuffer cb) {
        if (num-- == 0)
            return -1;  // 读取结束
        String res = Double.toString(next()) + " ";
        cb.append(res);
        return res.length();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(new RDadapter(5));
        while(s.hasNext()){
            System.out.println(s.next());
        }
        s.close();
    }
}