package com.rainbow.tijava.C07CodeReUse;
import static com.rainbow.utils.Print.*;

class WithFinals{
    // Identical to "private" alone:
    private final void f(){
        println("WithFinals.f()");
    }
    // Also automatically "final":
    private void g(){
        println("WithFinals.g()");
    }
}
class OverridingPrivate extends WithFinals {
    private final void f() {    // 注意这不是重写
        println("OverridingPrivate.f()");
    }
    private void g() {
        println("OverridingPrivate.g()");
    }
}
class OverridingPrivate2 extends OverridingPrivate {
    public final void f(){  // 注意这不是重写
        println("OverridingPrivate2.f()");
    }
    public void g() {
        println("OverridingPrivate2.g()");
    }
}
public class C07P04OverPrivate {
    public static void main(String[] args) {
        OverridingPrivate2 a = new OverridingPrivate2();
        a.f();
        a.g();  // is ok
    }
}
