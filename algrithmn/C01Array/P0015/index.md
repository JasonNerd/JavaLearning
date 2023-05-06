---
title: "D:\User\mrrai\project\LCcbJava\C01Array\P0015"
date: 2023-04-01T14:28:47+08:00
draft: false
tags: []
categories: ["学习笔记"]
twemoji: true
lightgallery: true
---
## 题目描述
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

```java
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

---
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
```

题目链接
[leetcode links](https://leetcode.com/problems/3sum/)

## 思路描述
双指针

```java
package C01Array.P0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, -1, 2}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        // 注意此处不同于 two sum, 输出的三元组是数组中的元素而非下标
        Arrays.sort(nums);  // 先排个序
        int target = 0;
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int j = i+1, k = nums.length-1;
            while(j < k){
                int ijk = nums[i]+nums[j]+nums[k];
                if(ijk == target){
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }else if(ijk < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        output.addAll(s);
        return output;
    }
}

```