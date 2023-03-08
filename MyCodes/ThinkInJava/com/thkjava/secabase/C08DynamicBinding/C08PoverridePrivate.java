package com.thkjava.secabase.C08DynamicBinding;
import static com.thkjava.utils.Print.*;
/*
 * 永远不要试图覆盖一个 private 方法, private方法默认是final修饰的, 对任何除本类的成员均不可见
 */
public class C08PoverridePrivate {
    private void f(){
        println("C08PoverridePrivate.private.f()");
    }
    public static void main(String[] args) {
        C08PoverridePrivate op = new OverridePrivate();     // 创建 OverridePrivate 对象并向上转型
        op.f();     // C08PoverridePrivate.private.f()
        // 此时, 由于 C08PoverridePrivate 中的 f() 方法是  private 故不可见, 也即子类并未
        // 覆写这一方法, 此时仍然调用父类方法
    }
}

class OverridePrivate extends C08PoverridePrivate{
    public void f(){
        println("OverridePrivate.public.f()");
    }
}