package com.rainbow.tijava.C10InnerClass;
/*
 * 实现 Parcel 示例
 * 再次演示 .this / .new 语法
 */
public class C10E3Parcel {
    class Contents{
        private int i = 226;
        public int getVal(){ return i; }
    }
    class Destination{
        private String label;
        Destination(String whereTo){ label = whereTo;}
        public String readLabel(){ return label; }
    }

    public static void main(String[] args) {
        C10E3Parcel foo = new C10E3Parcel();
        Contents c = foo.new Contents();
        System.out.println(c.getVal());
        Destination d = foo.new Destination("null");
        System.out.println(d.readLabel());
    }
}
