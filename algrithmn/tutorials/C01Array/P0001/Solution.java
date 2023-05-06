package C01Array.P0001;

import java.util.HashMap;
import java.util.Map;

/*
题目
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1]
题目大意
在数组中找到 2 个数之和等于给定值的数字，结果返回 2 个数字在数组中的下标。

2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
只会存在一个有效答案
 */
public class Solution{
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i=0; i<n; i++){
            Integer v = hashTable.get(target-nums[i]);
            if (v != null){
                return new int[]{v, i};
            }
            hashTable.put(nums[i], i);  // 注意是先判断再放自己 ==> {3, 3}
        }
        return null;
    }
    public static void main(String[] args) {
        int[] nums = {2, 8, 3, 1, 4};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}