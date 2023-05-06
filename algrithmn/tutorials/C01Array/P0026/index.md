---
title: "D:\User\mrrai\project\LCcbJava\C01Array\P0026"
date: 2023-04-12T14:51:23+08:00
draft: false
tags: []
tags: ["Java", "算法", "Array", "LeetCode"]
twemoji: true
lightgallery: true
---

## 题目描述
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

```java
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
```

题目链接
[26 Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

## 思路描述
两个指针, 一个指针 j 遍历原始数组, 另一个指针 i 指示无重复数组末尾元素的下标.

```java
public int removeDuplicates(int[] nums) {
    int i=0, j=i+1;
    while (j < nums.length){
        if(nums[i] != nums[j]){ // 遍历到一个新元素
            nums[++i] = nums[j];
        }
        ++j;
    }
    return i+1;
}
```