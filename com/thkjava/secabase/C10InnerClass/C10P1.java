package com.thkjava.secabase.C10InnerClass;
/*
创建一个含有private域和private方法的类。创建一个内部类，
它有一个方法可用来修改外围类的域，并调用外围类的方法。
在外围类的另一方法中，创建此内部类的对象，并且调用它的方法，
然后说明对外围类对象的影响。 
*/

class Gasio{
    private int varI;
    Gasio(int i){ varI = i;}
    private void funV(){
        System.out.println("Gasio.funV()-varI="+varI);
    }
    private class GaInner{
        void funGI(){
            funV();
            varI = varI * varI;
            funV();
        }
    }
    public void getGaIn(){
        GaInner gaInner = new GaInner();
        gaInner.funGI();
    }
}

public class C10P1 {
    public static void main(String[] args) {
        Gasio gasio = new Gasio(8);
        gasio.getGaIn();
    }
}
