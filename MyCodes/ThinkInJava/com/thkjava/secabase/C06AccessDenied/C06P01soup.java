package com.thkjava.secabase.C06AccessDenied;
// 使用私有构造器方法
// 这样做的理由是: 限制创建对象的数量(例如单个)

class Soup1{
    private Soup1(){}
    // 通过公开的静态方法(无法直接创建对象)获取对象实例
    public static Soup1 makeSoup(){
        return new Soup1();
    }
}

class Soup2{
    private Soup2(){}
    // 创建一个静态私有成员, 仅一份
    private static Soup2 sp = new Soup2();
    public static Soup2 access(){
        return sp;  // 将它的引用返回
    }
}

public class C06P01soup {
    public static void main(String[] args) {
        // Soup1 foo = new Soup1(); // is not allowed
        // Soup2 foo = new Soup2();  // is not allowed
        Soup1 sp11 = Soup1.makeSoup();
        System.out.println(sp11.getClass());
        Soup2 sp21 = Soup2.access();
        System.out.println(sp21.getClass());
    }
}
