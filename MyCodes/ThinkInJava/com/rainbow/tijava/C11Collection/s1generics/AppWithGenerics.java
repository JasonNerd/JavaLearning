package com.rainbow.tijava.C11Collection.s1generics;
import java.util.ArrayList;

class Fuji extends Apple{
    @Override
    public String toString() {
        return "Apple "+getApid()+"(Fuji)";
    }
}
class Gala extends Apple{
    @Override
    public String toString() {
        return "Apple "+getApid()+"(Fuji)";
    }
}
class Xygen extends Apple{
    @Override
    public String toString() {
        return "Apple "+getApid()+"(Fuji)";
    }
}


public class AppWithGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        // apples.add(new Orange());    // is not compliable
        for(int i=0; i<apples.size(); i++){
            System.out.println(apples.get(i));
        }
        // but you can upcast(automatic)
        apples.add(new Fuji());     // 将 Apple 子类添加到 Apple 的容器
        apples.add(new Gala());     // 操作可行
        apples.add(new Xygen());
        // you can use for-each method to tranverse
        for(Apple a: apples)
            System.out.println(a);
    }
}
