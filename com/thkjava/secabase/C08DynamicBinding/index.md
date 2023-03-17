---
title: "第8章 -- 多态 or 动态绑定"
date: 2023-03-16T22:30:14+08:00
draft: false
tags: ["Java", "Java编程思想"]
categories: ["学习笔记"]
twemoji: true
lightgallery: true
---

**在面向对象的程序设计语言中，多态是继数据抽象和继承之后的第三种基本特征。多态通过分离做什么和怎么做，从另一角度将接口和实现分离开来**。多态不但能够改善代码的组织结构和可读性，还能够创建可扩展的程序。**【封装】通过合并特征和行为来创建新的数据类型。【实现隐藏】则通过将细节"私有化"把接口和实现分离开来，而【多态】的作用则是消除类型之间的耦合关系——继承允许将对象视为它自己本身的类型或其基类型来加以处理。**
这种能力极为重要，因为它允许将多种类型(从同一基类导出的)视为同一类型来处理，而同一份代码也就可以毫无差别地运行在这些不同类型之上了。多态方法调用允许一种类型表现出与其他相似类型之间的区别，只要它们都是从同一基类导出而来的。这种区别是根据方法行为的不同而表示出来的，虽然这些方法都可以通过同一个基类来调用。
**多态又称动态绑定、后期绑定或运行时绑定**

## 简化代码
对象既可以作为它自己本身的类型使用，也可以作为它的基类型使用。而这种把对某个对象的引用视为对其基类型的引用的做法被称作向上转型。如果我们只写这样一个简单方法，它仅**接收基类作为参数，而不是那些特殊的导出类，这正是多态所允许的**。
因此, 对于基类和导出类(is-like-a)共有的接口, 可以通过向上转型的基类引用(但指向的是导出类对象)来对接口方法进行调用, 然而编译器无法得知这一引用实际指向的对象(基类 or 导出类?), 因而不知道要将这一方法调用关联到哪一个方法体上(绑定), 解决方法是后期绑定或者多态绑定: 
解决的办法就是**后期绑定，它的含义就是在运行时根据对象的类型进行绑定。后期绑定也叫做动态绑定或运行时绑定**。如果一种语言想实现后期绑定，就必须具有某种机制，以便在运行时能判断对象的类型，从而调用恰当的方法。也就是说，**编译器一直不知道对象的类型，但是方法调用机制能找到正确的方法体，并加以调用**。后期绑定机制随编程语言的不同而有所不同，但是只要想一下就会得知，不管怎样都**必须在对象中安置某种“类型信息”.**
```java
Shape s = new Circle();
```
这里，创建了一个Circle对象，并把得到的引用立即赋值给Shape，这样做看似错误 (将一种类型赋值给另一种类型)，但实际上是没问题的，因为通过继承，**Cirle就是一种Shape**。因此，编译器认可这条语句，也就不会产生错误信息.

## 方法是默认动态绑定的
**Java中除了static方法和final方法 (private方法属于final方法)之外，其他所有的方法都是后期绑定**。这意味着通常情况下，我们不必判定是否应该进行后期绑定一一它会自动发生。为什么要将某个方法声明为final呢?正如前一章提到的那样，它可以防止其他人覆盖该方法。但更重要的一点或许是:这样做可以有效地“关闭”动态绑定。

```java
// HW1
/*
创建一个Cycle类，它具有子类 Unicycle、Bicycle和 Tricycle.
演示每一个类型的实例都可以经由 ride() 方法向上转型为 Cycle
以练习1为基础，在 Cycle 中添加 wheels() 方法，它将返回轮子的数量。
修改 ride() 方法，让它调用 wheels() 方法，并验证多态起作用了
*/
// HW2
/*
实现如下的示例: 一个对象制造工厂
*/
public class Shape {
    public void draw(){}
    public void erase(){}
}
public class Circle extends Shape {
    public void draw() { print("Circle.draw()");}
    public void erase() { print("Circte.erase()");}
}
public class Square extends Shape {
    public void draw(){ print("Square.draw()");}
    public void erase(){ print("Square.erase()"); }
}
public class Triangle extends Shape {
    public void draw(){ print("Triangle.draw()");}
    public void erase(){ print("Triangle,erase()"); }
}
public class RandomShapeGenerator {
    private Random rand = new Random(47);
    public Shape next(){
        switch(rand.nextInt(3)) {
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }
}
public class Shapesprivate{
    static RandomShapeGenerator gen =new RandomShapeGenerator();
    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        // Fill up the array with shapes:
        for(int i = 0;i< s.length; i++)
            s[i] = gen.next();
        for(Shape shp : s)
            shp.draw();
    }
}
// HW3
/*
创建一个包含两个方法的基类。在第一个方法中可以调用第二个方法。
然后产生一个继承自该基类的导出类，且覆盖基类中的第二个方法。
为该导出类创建一个对象，将它向上转型到基类型并调用第一个方法，解释发生的情况。
*/
```

## 私有方法、静态域、静态方法
私有方法 `private f()` 默认是 `final` 的, 不可以被重写, 其他的类也不可以访问, 也不支持动态绑定, 例如有如下示例:
```java
public class PrivateOverride {
    private void f(){ print("private f()"); }
    public static void main(Stringl] args){
        PrivateOverride po = new Derived();
        po.f();
    }
}
class Derived extends PrivateOverride {
    public void f(){ print("public f()"); }
} // Output:private f()
```
这样的用法似乎看起来十分奇怪, 再看静态域`static`数据和静态方法:
```java
class Super {
    public int field = 0;
    public int getField() {
        return field; 
    }
}
class Sub extends Super {
    public int field = 1;
    public int getField() { return field; }
    public int getSuperField() { return super.field; }
}
public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub(); // Upcast
        System.out.println("sup,field = "+ sup.field+", sup.getField() = "+ sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field ="+sub.field +", sub.getField() = "+sub.getField() + "sub.getSuperField() = "+sub.getSuperField());
    }
}
```
当Sub对象转型为Super引用时, **任何域访问操作都将由编译器解析, 因此不是多态的**。在本例中，为Super.field和Sub.field分配了不同的存储空间。这样，Sub实际上包含两个称为field的域:它自己的和它从Super处得到的。然而，在引用Sub中的field时所产生的默认城并非Super版本的field域。因此，为了得到Super.field，必须显式地指明super.field.
尽管这看起来好像会成为一个容易令人混淆的问题，但是在实践中，它实际上从来不会发生。首先，你**通常会将所有的域都设置成private**，因此不能直接访问它们，其副作用是**只能调用方法来访问**。另外，你**可能不会对基类中的域和导出类中的域赋予相同的名字，因为这种做法容易令人混淆**。如果某个方法是静态的，它的行为就不具有多态性, 静态方法是与类，而并非与单个的对象相关联的

## 再谈初始化
引入继承和动态绑定后, 有必要再说明初始化(加载)的顺序, 总体说来, 总是先初始化已声明的域再调用构造器初始化非静态域, 总是先初始化静态域(与类相关)再初始化非静态域, 总是先初始化基类再初始化导出类。
这就引出了一个有趣的问题, 构造器是静态的, 假如在构造器中调用了一个可被动态绑定的方法, 会产生什么样的行为? 具体的, 在基类中除了一个构造器方法还有一个方法f(), 在导出类中也有构造器和f(), 基类构造器调用了f()方法, 此时在 main测试函数中创建一个 导出类的对象, 首先加载导出类, 初始化静态域, 进入导出类构造器, 进入基类, 初始化基类的静态域, 进入基类构造器, 调用f()方法, 按照动态绑定原则, 应调用导出类的f()方法, 注意此时导出类对象并未初始化完成, 这就产生了矛盾:
```java
class Glyph {
    void draw(){ print("Glyph,draw()");}
    Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}
class RoundGlyph extends Glyph {
    private int radius = 1;
    RoundGlyph(int r){
        radius = r;
        print("RoundGlyph.RoundGlyph()，radius = "+ radius);
    }
    void draw() {
        print("RoundGlyph.draw()，radius =" + radius);
    }
}
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
```
Glyph.draw()方法设计为将要被覆盖，这种覆盖是在RoundGlyph中发生的。但是Glyph构造器会调用这个方法，结果导致了对RoundGlyph.draw()的调用，这看起来似乎是我们的目的但是如果看到输出结果，我们会发现**当Glyph的构造器调用draw()方法时，radius不是默认初始值1，而是0**。这可能导致在屏幕上只画了一个点，或者根本什么东西都没有.
在前一节讲述的初始化顺序并不十分完整，而这正是解决这一谜题的关键所在。初始化的实际过程是:
1)在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的零
2)如前所述那样调用基类构造器。此时，调用被覆盖后的draw()方法(要在调用RoundGlyph构造器之前调用)，由于步骤1的缘故，我们此时会发现radius的值为0
3)按照声明的顺序调用成员的初始化方法。
4)调用导出类的构造器主体。
这样做有一个优点，那就是所有东西都至少初始化成零(或者是某些特殊数据类型中与“零”等价的值)，而不是仅仅留作垃圾。其中包括通过“组合”而人一个类内部的对象引用,其值是null。所以如果忘记为该引用进行初始化，就会在运行时出现异常。查看输出结果时，会发现其他所有东西的值都会是零，这通常也正是发现问题的证据。
另一方面，我们应该对这个程序的结果相当震惊。在逻辑方面，我们做的已经十分完美而它的行为却不可思议地错了，并且编译器也没有报错。(在这种情况下，C++语言会产生更合理的行为。) 诸如此类的错误会很容易被人忽略，而且要花很长的时间才能发现。因此，编写构造器时有一条有效的准则: "**用尽可能简单的方法使对象进入正常状态，如果可以的话，避免调用其他方法**"。在构造器内**唯一能够安全调用的那些方法是基类中的final方法(也适用于private方法，它们自动属于final方法)**。这些方法不能被覆盖，因此也就不会出现上述令人惊讶的问题。你可能无法总是能够遵循这条准则，但是应该朝着它努力。
