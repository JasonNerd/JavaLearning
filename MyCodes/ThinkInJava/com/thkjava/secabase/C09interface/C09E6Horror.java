package com.thkjava.secabase.C09interface;
// 例6. C09E6Horror.java
// 实现一个 Monster 接口, 以及一个继承 Moster 的 DangerousMonster, 实现示例
interface Monster{
    void menance();
}
interface DangerousMonster extends Monster{
    void destroy();
}
class DragonZilla implements DangerousMonster{
    @Override
    public void menance() {}

    @Override
    public void destroy() {}
}

interface Lethal{
    void kill();
}
// 接口 Vampire 继承了多个接口
interface Vampire extends DangerousMonster, Lethal{
    void drinkBlood();
}
class VeryBadVampire implements Vampire{
    public void menance() {}
    public void destroy() {}
    public void kill() {}
    public void drinkBlood() {}
}
public class C09E6Horror {
    public static void main(String[] args) {
        new VeryBadVampire();
    }
}
