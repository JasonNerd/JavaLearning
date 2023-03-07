package com.rainbow.tijava.C10InnerClass.whyInner;
/*
 * 回调方调用调用方进行数据爬取
 * 调用方调用回调方进行数据存储
 * 调用方调用回调方进行日志记录
 */

interface Handler{
    void handle(String info);
}

class Task{
    private String info;
    public void setInfo(String info) {
        this.info = info;
    }
    public void call(){
        Crawler.getInstance().crawl(new Handler() {
            @Override
            public void handle(String info) {
                setInfo(info);  // 将传入的信息保存
            }
            
        });
    }
    @Override
    public String toString() {
        return "Task "+info;
    }
}

class Crawler{
    private static Crawler instance = null;
    public static Crawler getInstance(){
        if (instance == null)
            instance = new Crawler();
        return instance;
    }
    // crawl到的信息
    private String getInfo(){
        return "info from crawler";
    }
    public void crawl(Handler handler){
        handler.handle(getInfo());  // 向 handler 传入
    }
}
public class CBeg4 {
    public static void main(String[] args) {
        Task task = new Task();
        task.call();
        System.out.println(task);
    }
}
