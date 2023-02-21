package com.rainbow.tijava.C08DynamicBinding;
import static com.rainbow.utils.Print.*;

import java.util.Random;

/*
 * 引入多态的概念后, 本节再谈继承中的初始化问题
 */
/*
 * 这样做有一个优点，那就是所有东西都至少初始化成零(或者是某些特殊数据类型中与等价的值)，而不是仅仅留作垃圾。其中包括通过“组合”而人一个类内部的对象引用“”其值是null。所以如果忘记为该引用进行初始化，就会在运行时出现异常。查看输出结果时，会发现其他所有东西的值都会是零，这通常也正是发现问题的证据。
另一方面，我们应该对这个程序的结果相当震惊。在逻辑方面，我们做的已经十分完美而它的行为却不可思议地错了，并且编译器也没有报错。(在这种情况下，C++语言会产生更合理的行为。 诸如此类的错误会很容易被人忽略，而且要花很长的时间才能发现。因此，编写构造器时有一条有效的准则:“用尽可能简单的方法使对象进入正常状态，如果可以的话，避免调用其他方法”。在构造器内唯一能够安全调用的那些方法是基类中的fimal方法(也适用于private方法，它们自动属于final方法)。这些方法不能被覆盖，因此也就不会出现上述令人惊讶的问题。你可能无法总是能够遵循这条准则，但是应该朝着它努力。
 */
class Meal{
    Meal(){ println("Meal()");  }
}

class Bread{
    Bread(){ println("Bread()");  }
}

class Cheese{
    Cheese(){ println("Cheese()");  }
}

class Lettuce{
    Lettuce(){ println("Lettuce()");  }
}

class Lunch extends Meal{
    private static Cheese mCheese = new Cheese();
    Lunch() { 
        println("Lunch() before eat");
        eat();  // 构造器内部调用了一个非 static 方法, 该方法是动态绑定的
        println("Lunch() after eat");

    }
    public void eat() {
        print(mCheese.getClass().getSimpleName());
    }
}

class PortableLuch extends Lunch{
    private static Bread bread = new Bread();
    private int num = 2;
    private Cheese[] cheeses = new Cheese[2];
    private Lettuce[] lettuces = new Lettuce[2];
    PortableLuch(){
        for(int i=0; i<num; i++){
            cheeses[i] = new Cheese();
            lettuces[i] = new Lettuce();
        }
        eat();  // 若 num=2, 说明它在调用构造器前就初始化了, 而事实确实如此
        Random r = new Random(226129);
        num = r.nextInt(100);  // 重新初始化
    }
    @Override
    public void eat(){
        println("eat "+bread.getClass().getSimpleName()+", " +num +" cheese and lettuce.");
    }
}
public class C08PinitComplete {
    public static void main(String[] args) {
        Lunch l = new PortableLuch(); 
        l.eat();    // 试分析运行结果
        /*
         * 一些基本原则:
         * 1. 应首先调用基类构造器, 确保基类中的变量得到初始化
         * 2. 在加载类的时候静态域会被初始化, 且仅初始化一次
         * 3. 在静态域初始化完成后才开始调用构造器(创建对象)
         * 4. 类的非静态域是在创建对象前完成的
         * 然而还有一些细节需要注意:
         * 1. 为了加载子类, 应该先加载基类, 对于其中的static变量依次进行初始化
         * 这就解释了输出前两行是 Cheese() 和 Bread(). 
         * 2. 此后再依次调用构造器, 假设先不考虑 Lunch()构造器中的调用和输出
         * 那么接着来到 PortableLuch , 就会依次输出 Cheese(), Lettuce(), Cheese(), Lettuce()
         * 这就是在构造器中初始化了两个数组变量. 随后调用 eat() 查看 num
         * eat Bread, 2 cheese and lettuce.
         * 说明 num 已被初始化, 随后在构造器重新初始化
         * eat Bread, 23 cheese and lettuce.
         * 
         * 再看 Lunch()的构造器, 他调用了 eat()方法, 该方法在 PortableLuch 中被覆盖
         * 因此依据多态原则 应调用 覆盖 后 的 方法, 然而一个矛盾是, 此时还在基类中, 子类还未初始化完成
         * 这就导致了一个新机制：在任何初始化工作开始之前, 为对象分配的空间全被初始化为0. 于是输出
         * eat Bread, 0 cheese and lettuce.
         */
    }
}
 /*
* Cheese()
* Bread()
* Meal()
* Lunch() before eat
* eat Bread, 0 cheese and lettuce.
* Lunch() after eat
* Cheese()
* Lettuce()
* Cheese()
* Lettuce()
* eat Bread, 2 cheese and lettuce.
*/