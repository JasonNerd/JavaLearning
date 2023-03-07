package com.rainbow.tijava.C10InnerClass.whyInner.controller;
/*
 * `add()`方法用来将一个Object添加到List的尾端，`size()`方法用来得到
 * List 中元素的个数. `remove()`方法用来从List中移除指定的Event. 
 * `run()`方法循环遍历 eventList，寻找就绪的 (`ready()`)的Event对象
 * 对找到的每一个就绪的 (`ready()`)事件，使用对象的`toString()`打印其信息
 * 调用其`action()`方法，然后从队列中移除此Event
 */

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Event> events = new ArrayList<Event>();
    public void addEvent(Event c){
        events.add(c);
    }
    public void run(){
        while(events.size()>0){
            // Make a copy so you're not modifying the lsit
            // while you're selecting the elements in it.
            for(Event e: new ArrayList<Event>(events)){
                if (e.ready()){
                    System.out.println(e);
                    e.action();
                    events.remove(e);
                }
            }
        }
    }
}
