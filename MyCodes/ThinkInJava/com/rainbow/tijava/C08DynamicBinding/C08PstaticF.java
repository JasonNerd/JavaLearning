package com.rainbow.tijava.C08DynamicBinding;
import static com.rainbow.utils.Print.*;
/*
 * 任何域访问操作都将由编译器解析, 因此域不是多态的
 * 这也就引出了 getter() setter() 方法的作用
 * 他们看起来如此简单, 不过是提供了访问修改私有域成员的接口
 * 然而一个更重要的原因是方法是默认遵循动态绑定机制的
 */

class SpClass{
    public int fldi = 30;
    public int getFldi() {
        return fldi;
    }
    public static void show(){
        println("SpClass");
    }
}
class SbClass extends SpClass{
    public int fldi = 22;
    @Override
    public int getFldi() {
        return fldi;
    }
    public static void show(){  // 静态方法不参与子类的覆写
        println("SpClass");
    }
}


public class C08PstaticF {
    public static void main(String[] args) {
        SpClass sp = new SbClass();
        println(sp.fldi);   // 30
        println(sp.getFldi());  // 22
        // sp.show();  // SpClass
        // 静态方法与类而非对象相关, 由编译器解析
        /*
         * 尽管这看起来好像会成为一个容易令人混淆的问题，但是在实践中，它实际上从来不会发生。
         * 首先，你通常会将所有的域都设置成private，因此不能直接访问它们，而只能使用 getter() 方法。
         * 另外，你可能不会对基类中的域和导出类中的域赋予相同的名字，因为这种做法容易令人混淆。
         * 如果某个方法是静态的，它的行为就不具有多态性, 静态方法是与类，而并非与单个的对象相关联的
         */
    }
}
