package com.thkjava.secabase.C09interface;
/*
 * 在Java中，一个类可以实现(implements)很多个接口, 但只能从一个类继承，
 * 也即只能有一个父类，然而，这个类可以向上转型为实现的接口的任意一个
 * （当然也可以是父类）。
 */

interface canFight{
    void fight();
} 
interface canSwim{
    void swim();
}
interface canFly{
    void fly();
}
class ActionCharacter{
    public void fight(){}   // 能够战斗
}
class Hero extends ActionCharacter implements canFight, canFly, canSwim{
    // 除了战斗
    @Override
    public void fly() {}    // 还会飞翔
    @Override
    public void swim() {}   // 以及游泳
}

public class C09E5Adventures {
    public static void r(canFight x){x.fight();}
    public static void s(canFly x){x.fly();}
    public static void t(canSwim x){x.swim();}
    public static void u(ActionCharacter x){x.fight();}
    public static void main(String[] args) {
        Hero hero = new Hero();
        r(hero);
        s(hero);
        t(hero);
        u(hero);
    }
}
