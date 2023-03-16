package com.thkjava.secabase.C07CodeReUse;
import static com.thkjava.utils.Print.*;

class Animal0{
    protected String name;
    Animal0(String name){this.name = name;}
    void eat(){println(toString()+"have nothing to eat");}
    void eat(String a){println(toString()+" eat "+a);}
    void eat(Animal0 animal0){println(toString()+" eat "+animal0);}
    @Override
    public String toString() {
        return "Animal0 "+name;
    }
}

class Duck0 extends Animal0{
    Duck0(String name){super(name);}
    @Override
    void eat() {
        println(toString()+" swim in the river.");
    }
    void eat(int i){
        println(toString()+" eat "+i+" times a day.");
    }
    @Override
    public String toString() {
        return "Duck "+name;
    }
}

public class C07P02overLoad {
    public static void main(String[] args) {
        Duck0 joker = new Duck0("joker");
        Duck0 ammy = new Duck0("ammy");
        joker.eat();
        joker.eat("water grass");
        joker.eat(10);
        joker.eat(ammy);    // Duck0 是一种 Animal0
    }
}
