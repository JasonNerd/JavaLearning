package com.rainbow.tijava.C09interface.interfaceproc;
/*
 * 假设我们设计实现了一个 Processor接口, 我们尝试它是否可以
 * 进行有效的复用
 */
public interface Processor {
    // 返回策略信息
    String name();
    // 为input执行策略
    Object process(Object input);
}
