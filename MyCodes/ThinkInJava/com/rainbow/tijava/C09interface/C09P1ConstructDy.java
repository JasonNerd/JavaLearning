package com.rainbow.tijava.C09interface;
/*
创建一个基类，让它包含抽象方法print()，并在导出类中覆盖该方法。
覆盖后的方法版本可以打印导出类中定义的某个整型变量的值。
在定义该变量之处，赋予它非零值。在基类的构造器中调用这个方法。
现在，在main()方法中，创建一个导出类对象，然后调用它的print()方法。
请解释发生的情形
*/
abstract class BaseC{
    abstract void print();
    BaseC(){
        System.out.println("Before print()");
        print();
        System.out.println("After print()");
    }
}
class ExportC extends BaseC{
    private int it = 8;
    @Override
    void print() {
        System.out.println("ExportC.it = " + it);
    }
}

public class C09P1ConstructDy {
    public static void main(String[] args) {
        ExportC exportC = new ExportC();
        exportC.print();
        /*
         *  Before print()
            ExportC.it = 0
            After print()
            ExportC.it = 8
         */
    }
}
