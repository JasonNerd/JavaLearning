package com.thkjava.secabase.C10InnerClass;
/*
 * 当将内部类向上转型为其基类，尤其是转型为一个接口的时候，内部类就有了用武之地。
 * 实现 Parcel4 类, 主要是 移出整数和字符串包装类使之成为接口，
 * 在其内部定义私有内部类实现接口
 */
class Parcel2{
    protected class PDes implements Destination{
        private String label;
        PDes(String whereTo){ label = whereTo;}
        @Override
        public String readLabel() { return label; }
    }
    private class PCon implements Contents{
        int i = 226;
        @Override
        public int value() {
            return i;
        }
    }
    public PCon getPcon(){
        return new PCon();
    }
}
public class C10E2Parcel2 {
    public static void main(String[] args) {
        Parcel2 foo = new Parcel2();
        Parcel2.PDes pDes = foo.new PDes("null");
        System.out.println(pDes);
    }
}
