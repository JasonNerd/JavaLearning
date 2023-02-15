# 第07章 - 代码复用(复用类)
在Java中, 包含两类代码复用的方式: **组合和继承**。组合: 只需在新的类中产生现有类的对象。继承: 按照现有类的类型来创建新类。不改变现有类的形式，采用现有类的形式并在其中添加新代码。继承是面向对象程序设计的基石之一，在本章中，读者将会了解到这两种代码重用机制。
*#Tips 1*
toString()方法, 这是所有类(继承自Object)均具有的方法, 该方法将对象以合乎逻辑的方式将类转为字符串String, 可以在自己的类**重写(overriding)**该方法。
*#TODO 1*
> 验证toString()方法, 使用 String 的 +, += 符号

*#Tips 2*
**可以为每个类都创建一个main()方法**。这种在每个类中都设置一个main()方法的技术可使每个类的单元测试都变得简便易行。而且在完成单元测试之后，也无需删除main()，可以将其留待下次测试。**即使是一个程序中含有多个类，也只有命令行所调用的那个类的main()方法会被调用**。
因此，在此例中，如果命令行是java Detergent，那么Detergent.main()将会被调用。即使Cleanser不是一个public 类，如果命令行是java Cleanser，那么Cleanser.main()仍然会被调用。即使-个类只具有包访问权限，其public main()仍然是可访问的。**在此例中，可以看到Detergent.main()明确调用了Clanser.main()，并将从命令行获取的参数传递给了它。当然，也可以向其传递任意的String数组**。
*#TODO 2*
> 验证一个程序里的多个类可以都有main测试方法, 并且可以在一个类的main函数中调用另一个类的main函数.

## 类的继承
继承是所有OOP语言和Java语言不可缺少的组成部分。当创建一个类时，总是在继承，因此，除非已明确指出要从其他类中继承，否则就是在隐式地从Java的标准根类Object进行继承。继承语法是使用 extends 关键字表现的:
```java
public class AAA extends BBB{
    // some var
    // some constructor
    // some method
}
```
### 初始化
初始化(以及加载)总是从基类开始一直向下到当前子类.
### 代理
是指在B类中创建一个A类的对象a, 同时在B类中添加与A类中相同的接口方法, 在B类的中接口方法(例如f())实现采用a.f()的方式进行, 此时a就像是一个代理, 这样做的理由是B类包含着A类: SpaceShip并非真正的SpaceShipControls类型，即便你可以“告诉”SpaceShip向前运动(forward())。更准确地讲，SpaceShip包含SpaceShipControls，与此同时，SpaceShipControls的所有方法在SpaceShip中都暴露了出来, 代理解决了此难题.
### 确保正确的清理
Java中没有C++中析构函数的概念。构函是一种在对象被销时可以被自动调用的函数。其原因可能是因为在Java中，我们的习惯只是忘掉而不是销毁对象，并且让垃圾回收器在必要时释放其内存。
通常这样做是好事，但有时类可能要在其生命周期内执行一些必需的清理活动。正如我们在第5章中所提到的那样，你并不知道垃圾回收器何时将会被调用，或者它是否将被调用。因此**如果你想要某个类清理一些东西，就必须显式地编写一个特殊方法来做这件事，并要确保客户端程序员知晓他们必须要调用这一方法。就像在第12章所描述的那样，其首要任务就是，必须将这一清理动作置于finally子句之中，以预防异常的出现**。
*#TODO 3*
> 实现如下所示的 CADSystem.java
```java
//: reusing/CADSystem.java
// Ensuring proper cleanup.
package reusing;
import static net.mindview.util.Print.*;
class Shape {
    Shape(int i) { 
        print("Shape constructor"); 
    }
    void dispose(){
        print("Shape dispose");
    }
}

class Circle extends Shape {
    Circle(int i){
        super(i);
        print("Drawing Circle")；
    }
    void dispose() {
        print("Erasing Circle");
        super.dispose();
    }
}

class Triangle extends Shape {
    Triangle(int i) {
        super(i);
        print("Drawing Triangle");
    }
    void dispose(){
        print("Erasing Triangle");
        super.dispose();
    }
}

class Line extends Shape {
    private int start, end;
    Line(int start,int end) {
        super(start);
        this.start = start;
        this.end = end;
        print("Drawing Line:"+ start +", "+ end);
    }
    void dispose() {
        print("Erasing Line:"+ start +"," + end);
        super.dispose();
    }
}

public class CADSystem extends Shape {
    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];
    public CADSystem(int i) {
        super(i + 1);
        for(int j = 0; j < lines.length; j++)
            lines[j] = new Line(j, j*j);
        c = new Circle(1);
        t = new Triangle(1);
        print("Combined constructor");
    }
    public void dispose() {
        print("CADSystem,dispose()");
        // The order of cleanup is the reverse
        // of the order of initialization:
        t.dispose();
        c,dispose();
        for(int i = lines.length - 1; i >= ; i--)
            lines[i].dispose();
        super.dispose();
    }

    public static void main(String[] args){
        CADSystem x = new CADSystem(47);
        try {
            // Code and exception handling...
        }finally{
            x.dispose();
        }
    }
}
```
关键字try表示，下面的块 (用一组大括号括起来的范围)是所谓的**保护区guarded region**)这意味着它需要被特殊处理。其中一项特殊处理就是无论try块是怎样退出的保护区的，finally子句中的代码总是要被执行的。**这里fially子句表示的是 "无论发生什么事一定要为x调用dispose"**。

### 重载(overload)而不是覆盖(override)
重载函数是说有许多的方法, 他们执行着类似的功能, 但作用对象(参数列表)不同, 而覆盖是与继承相关的概念, 是指子类中对于基类中的方法进行重写, 函数签名完全相同, 但实现内容由子类确定, 覆盖可以使用**注解@override**进行检查以确保是覆盖而不是重载(子类继承父类, 因此包含了父类的所有方法, 如果写错了参数列表, 就相当于重载, 多了一个新的函数).
*#TODO 4*
> 创建一个类, 它包含了一个重载了三次的方法, 另一个类继承了该类, 重写了其中一个方法, 重载了一个新方法, 展示导出类的对象可以调用这四个方法.

## 组合与继承间的权衡
组合和继承都允许在新的类中放置子对象，组合是显式地这样做，而继承则是隐式地做。读者或许想知道二者间的区别何在，以及怎样在二者之间做出选择。**组合技术通常用于想在新类中使用现有类的功能而非它的接口这种情形**。即，在新类中嵌入某个对象，让其实现所需要的功能，但新类的用户看到的只是为新类所定义的接口，而非所嵌入对象的接口。为取得此效果，需要**在新类中加入一个现有类的private对象**。
**在继承的时候，使用某个现有类，并开发一个它的特殊版本。通常，这味着你在使用一个通用类，并为了某种特殊需要而将其特殊化**。**略微思考一下就会发现，用一个“交通工具对象来构成一部“车子”是毫无意义的，因为“车子”并不包含“交通工具”，它仅是一种交通工具 (is-a关系)。“is-a”(是一个)的关系用继来表达的，而“has-a”(有一个)的关系是用组合来表达的**。

*#TODO 5*
> 实现如下的Car类
```java
//: reusing/Car.java
// Composition with public objects
class Engine{
    public void start() {}
    public void rev(){}
    public void stop(){}
}
class Wheel {
    public void inflate(int psi) {}
}
class Window {
    public void rollup() {}
    public void rolldown() {}
}
class Door {
    public Window window = new Window();
    public void open() {}
    public void close() {}
}
public class Car {
    public Engine engine = new Engine();
    public wheel[] wheel = new Wheel[4];
    public Door left = new Door(), right = new Door(); // 2-door
    public Car(){
        for(int i=0; i<4; i++)
            wheel[i] = new wheel();
    }
    public static void main(String[] args){
        Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
    }
}
```
有时，允许类的用户直接访问新类中的组合成分是极具意义的，也就是说，将成员对象声明为public。如果成员对象自身都隐藏了具体实现，那么这种做法是安全的。当用户能够了解到你正在组装一组部件时，会使得端口更加易于理解。car对象即为一个很好的例子:由于在这个例子中car的组合也是问题分析的一部分(而不仅仅是底层设计的一部分)，所以使成员成为public将有助于客户端程序员了解怎样去使用类，而且也降低了类开发者所面临的代码复杂度。但务必要记得这仅仅是一个特例，一般情况下应该使域成为private。
**在面向对象编程中，生成和使用程序代码最有可能采用的方法就是直接将数据和方法包装进一个类中，并使用该类的对象**。也可以运用组合技术使用现有类来开发新的类，而继承技术其实是不太常用的。因此，尽管在教授OOP的过程中我们多次强调继承，但这并不意味着要尽可能使用它。相反，应当慎用这一技术，其使用场合仅限于你确信使用该技术确实有效的情况。**到底是该用组合还是用继承，一个最清晰的判断办法就是问一问自己是否需要从新类向基类进行向上转型。如果必须向上转型，则继承是必要的，但如果不需要，则应当好好考虑自己是否需要继承。**第8章提出了一个使用向上转型的最具说服力的理由，但只要记得自问一下“**我真的需要向上转型吗?**”就能较好地在这两种技术中做出决定。继承和组合都能从现有类型生成新类型。组合一般是将现有类型作为新类型底层实现的部分来加以复用，而继承复用的是接口。在使用继承时，**由于导出类具有基类接口，因此它可以向上转型至基类，这对多态来讲至关重要**，就像我们将在下一章中将要看到的那样。

## 向上转型
**继承技术最重要的方面并非 "为新的类提供方法", 最重要的方面是用来表现导出类B与基类A之间的关系, 也即 "导出类B是基类A的一种类型"**
假定有一个静态方法接受基类参数`A a`, B和C均继承自A, 那么由于B和C也是A类的一种, 因此可以将B或者C的一个对象实例的引用传入作为参数(这听起来很合理, 实际上编译器也的确支持这一重要的特性)
```java
class Instrument{
    public void play(){};
    public static void compose(Instrument i){i.play();}
}
class Piano extends Instrument{
    public static void main(String args[]){
        Piano p = new Piano;
        Instrument.compose(p);
    }
    void play(){
        print("piano");
    }
}
```
## final关键字


## 总结
尽管面向对象编程对继承极力强调，但在开始一个设计时，一般应优先选择使用组合 (或者可能是代理)，只在确实必要时才使用继承。因为组合更具灵活性。此外，通过对成员类型使用继承技术的添加技巧，可以在运行时改变那些成员对象的类型和行为。因此，可以在运行时改变组合而成的对象的行为。
**在设计一个系统时，目标应该是找到或创建某些类，其中每个类都有具体的用途，而且既不会太大(包含太多的能而难以复用)，也不会小(不添加其他能就无法使用)。**如果你的设计变得过于复杂，通过将现有类拆分为更小的部分而添加更多的对象，通常会有所帮助。当你开始设计一个系统时，应该认识到**程序开发是一种增量过程，犹如人类的学习一样这一点很重要**。程序开发依赖于实验，你可以尽己所能去分析，但当你开始执行一个项目时你仍然无法知道所有的答案。如果将项目视作是一种有机的、进化着的生命体而去培养，而不是打算像盖摩天大楼一样快速见效，就会获得更多的成功和更迅速的回馈。继承与组合正是在面向对象程序设计中使得你可以执行这种实验的最基本的两个工具。

