package com.thkjava.secabase.C08DynamicBinding;
import static com.thkjava.utils.Print.*;

class Cycle{
    @Override
    public String toString() {
        return "Cycle";
    }
    public int getWheels(){
        return 0;
    }
}

class Unicycle extends Cycle{
    private int wheels = 1;
    public int getWheels() {
        return wheels;
    }
    @Override
    public String toString() {
        return "Unicycle";
    }
}

class Bicycle extends Cycle{
    private int wheels = 2;
    public int getWheels() {
        return wheels;
    }
    @Override
    public String toString() {
        return "Bicycle";
    } 
}

class Tricycle extends Cycle{
    private int wheels = 3;
    public int getWheels() {
        return wheels;
    }
    @Override
    public String toString() {
        return "Tricycle";
    }
}


public class C08PCycle {
    public static void ride(Cycle cycle){
        println("I ride a "+cycle+", and it has "+cycle.getWheels()+" wheels");
    }
    public static void main(String[] args) {
        ride(new Bicycle());    // 传入 Bicycle() 对象
        ride(new Tricycle());
    }
}
