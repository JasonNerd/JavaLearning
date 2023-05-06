---
title: "P0011. 最大盛水量"
date: 2023-03-29T13:59:41+08:00
draft: false
tags: ["Java", "算法", "Array", "LeetCode"]
categories: ["学习笔记"]
twemoji: true
lightgallery: true
---

## 题目描述
Given n non-negative integers a1, a2, …, an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

```java
Input: [1,8,6,2,5,4,8,3,7]
Output: 49
```

题目链接:
https://leetcode.com/problems/container-with-most-water/

## 思路描述
将问题数学化:
```java
// max{(j-i)*min(A[i], A[j])} (0 <= i < j < n)
```
第一种思路, 暴力搜索:
```java
public int maxArea2(int[] height){
    // 暴力搜索, i, j两层遍历 O(n^2)
    int res = 0, n = height.length;
    for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
            int trs = (j-i)*(height[i]>height[j]?height[j]:height[i]);
            res = trs > res ? trs : res;
        }
    }
    return res;
}
```

第二种, 首尾指针, 不断舍弃短板, 遍历得到最大容积
```java
public int maxArea(int[] height){
    int n = height.length, i=0, j=n-1;  // 设定首尾指针
    int res = 0;
    while(i<j){
        int trs = (j-i)*(height[i]>height[j]?height[j]:height[i]);
        res = trs > res ? trs : res;
        if(height[i]<height[j])++i;     // 关键: 舍弃短板
        else --j;
    }
    return res;
}
```

为什么可以直接舍弃掉 A[i], A[j] 中的较小者?
假定 ai 和 aj 构成 A 容器。ak 与 min(ai,aj) 构成 B 容器，k 的取值在 (i,j) 这个区间。为了讨论方便，假设这里 min(ai,aj) = ai
1. ak > ai，由于 ai 小，B 容器的容积大小和最短板有关，V(B) = (k-i) * ai, V(A) = (j-i) * ai, 由于 j - i > k - i ，所以 V(A) > V(B)。
2. ak = ai，V(B) = (k-i) * ai, V(A) = (j-i) * ai, 由于 j - i > k - i ，所以 V(A) > V(B)。
3. ak < ai，由于 ak 小，B 容器的容积大小和最短板有关，V(B) = (k-i) * ak, V(A) = (j-i) * ai, 由于 j - i > k - i ，并且 ai > ak，所以 V(A) > V(B)。

综上所述，V(A) > V(B)，即，ai 和 aj构成的容器，容积大于所有 min(ai, aj) 与中间的墙构成的容器。于是可以直接舍弃短板