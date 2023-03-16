package com.thkjava.secabase.C11Collection.s1generics;
/*考虑一个 Apple 对象的容器, 容器类型使用 ArrayList 它继承自 List, 可以认为是长度可以扩张的数组, 
* 有一个 `add()` 方法向序列末尾添加元素, `get()` 方法通过下标访问这些元素, `size()`方法返回 容器中的元素个数.
* 正常情况下编译器会报告警告信息，因为这个示例没有使用泛型。在这里，我们使用Java SE5所特有的注解来抑制了警告信息。
* 注解以@符号开头，可以接受参数，这里的 @SuppressWarnings 注解及其参数表示只有有关“不受检查的异常”的警告信息应该被抑制
*/

import java.util.ArrayList;

class Apple {
    private static long apcnt=10010;
    private long apid;
    Apple(){ apid = apcnt++; }
    public long getApid() {
        return apid;
    }
    @Override
    public String toString() {
        return "Apple "+getApid();
    }
}
class Orange{}

public class AppleNoGenerics {
    
    public static void main(String[] args) {
        // 不给定容器类型
        @SuppressWarnings("unchecked")
        ArrayList apples = new ArrayList();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Orange());   // 加入了一个 Orange 对象, 这只有在运行时才才会被检测到
        for(int i=0; i<apples.size(); i++){
            System.out.println("Apple "+((Apple)apples.get(i)).getApid());
        }
    }
}
