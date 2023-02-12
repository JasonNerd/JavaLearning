package com.rainbow.tijava.C05InitClear;
/*
 * 本小节主要说明 变量的初始化顺序
 * 一是在定义时初始化
 * 二是在构造器中初始化
 * 三是与类（而非对象）绑定的静态变量
 */
public class C05P03initOrder {
    public static void main(String[] args) {
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
    /*
     * 程序输出分析: 首先是初始化两个变量 table 和 cupboard, 这就要先加载两个类
     * 首先是table类加载, 初始化两个静态变量
     * 输出:
     * Bowl(1)
     * Bowl(2)
     * 创建table对象, 调用构造器, 输出:
     * Table()
     * f1(1)
     * 接着加载 Cupboard 类, 先初始化两个静态变量, 再非静态成员, 输出
     * Bowl(4)
     * Bowl(5)
     * Bowl(3)
     * 接着调用 Cupboard 的构造函数, 输出
     * Cupboard()
     * f1(2)
     * 接着执行静态方法 main
     * Creating new Cupboard() in main
     * Bowl(3)
     * Cupboard()
     * f1(2)
     * Creating new Cupboard() in main
     * Bowl(3)
     * Cupboard()
     * f1(2)
     * f2(1)
     * f3(1)
     */
}

class Bowl{
    Bowl(int marker){
        System.out.println("Bowl(" + marker +")");
    }
    void f1(int marker){
        System.out.println("f1("+ marker +")");
    }
}
class Table{
    static Bowl bowl1 = new Bowl(1);
    Table(){
        System.out.println("Table()");
        bowl2.f1(1);
    }
    void f2(int marker){
        System.out.println("f2("+ marker +")");
    }
    static Bowl bowl2 = new Bowl(2);
}
class Cupboard{
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard(){
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }
    void f3(int marker){
        System.out.println("f3("+ marker +")");
    }
    static Bowl bowl5 = new Bowl(5);
}
